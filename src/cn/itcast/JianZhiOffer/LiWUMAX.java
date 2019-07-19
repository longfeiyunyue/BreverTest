package cn.itcast.JianZhiOffer;

public class LiWUMAX {//√Ê ‘Ã‚47
	
	public static int max(int[][] arr) {
		int row=arr.length;
		int col=arr[0].length;
		int[][] opt=new int[row][col];
		opt[0][0]=arr[0][0];
		for(int j=1;j<col;j++) opt[0][j]=opt[0][j-1]+arr[0][j];
		for(int i=1;i<row;i++) opt[i][0]=opt[i-1][0]+arr[i][0];
		for(int i=1;i<row;i++) {
			for(int j=1;j<col;j++) {
				opt[i][j]=arr[i][j]+Math.max(opt[i-1][j],opt[i][j-1]);
			}
		}
		return opt[row-1][col-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr= {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        int sum=max(arr);
        System.out.println(sum);
	}

}
