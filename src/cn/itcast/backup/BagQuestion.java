package cn.itcast.backup;

public class BagQuestion {
	
	public static int maxValue(int[] w,int[] v,int cap) {
		int row=w.length+1;
		int col=cap+1;
		int[][] price=new int[row][col];
		for(int i=0;i<row;i++) price[i][0]=0;
		for(int j=0;j<col;j++) price[0][j]=0;
		for(int i=1;i<row;i++) {
			for(int c=1;c<col;c++) {
				if(c<w[i-1]) price[i][c]=price[i-1][c];
				else {
					int val1=price[i-1][c-w[i-1]]+v[i-1];
					int val2=price[i-1][c];
					price[i][c]=Math.max(val1, val2);
				}
			}
			
		}
		return price[row-1][cap];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] w= {5, 4, 6, 3};
        int[] v= {10, 40, 30, 50};
        int p=maxValue(w,v,10);
        System.out.println(p);
	}

}
