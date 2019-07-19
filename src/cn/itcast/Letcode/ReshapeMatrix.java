package cn.itcast.Letcode;

public class ReshapeMatrix {//¸Ä±ä¾ØÕóÎ¬¶È
	
	public static int[][] matrixReshape(int[][] nums,int r,int c){
		if(r*c!=nums[0].length*nums.length) return nums;
		int[][] res=new int[r][c];
		int row=nums.length;
		int col=nums[0].length;
		int a=0,b=0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				res[i][j]=nums[a][b++];
				if(b==col) {
					b=0;
					a++;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
