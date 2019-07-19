package cn.itcast.JianZhiOffer;

public class FindPath {//√Ê ‘Ã‚12
	private static boolean flag=false;
	
	public static boolean hasPath(char[][] matrix,char[] str,int row,int col) {
		StringBuffer sb=new StringBuffer();
		boolean[][] marked=new boolean[row][col];
		for(int i=0;i<row;i++)
			for(int j=0;j<col;j++) marked[i][j]=false;
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(matrix[i][j]==str[0]) {
					sb.append(matrix[i][j]);
					marked[i][j]=true;
					dfs(matrix,str,i,j,sb,marked,1);
					sb.deleteCharAt(sb.length()-1);
					marked[i][j]=false;
				}
			}
		}
		return flag;
	}
	
	private static void dfs(char[][] matrix,char[] str,int row,int col,
			StringBuffer sb,boolean[][] marked,int cur) {
		if(sb.length()==str.length) {
			flag=true;
			System.out.println(sb.toString());
			return;
		}
		int[][] pows= {{0,1},{0,-1},{1,0},{-1,0}};
		for(int i=0;i<pows.length;i++) {
			int x=row+pows[i][0];
			int y=col+pows[i][1];	
			if(x<0||x>matrix.length-1||y<0||y>matrix[0].length-1) continue;
			if(matrix[x][y]==str[cur]&&!marked[x][y]) {
				sb.append(matrix[x][y]);
				marked[x][y]=true;
				cur++;
				dfs(matrix,str,x,y,sb,marked,cur);
				sb.deleteCharAt(sb.length()-1);
				marked[x][y]=false;
				cur--;
			}
		}
		
	}
	
	public static void main(String[] args){
		 char[][]arr = {{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
	        char []str = {'b','c','c','e','d'};
	        System.out.println(hasPath(arr,str, arr.length, arr[0].length));
	}

}
