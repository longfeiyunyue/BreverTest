package cn.itcast.JianZhiOffer;

public class SecondArrayFind {//√Ê ‘Ã‚4
	
	public static boolean find(int[][] arr,int key) {
		if(key<arr[0][0]) return false;
		int row=0;
		int col=arr[0].length-1;
		while(row<arr.length&&col>=0) {
			if(key==arr[row][col]) return true;
			else if(key<arr[row][col]) col--;
			else row++;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] arr = new int[3][3];
        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[0][2] = 3;
        arr[1][0] = 2;
        arr[1][1] = 3;
        arr[1][2] = 4;
        arr[2][0] = 3;
        arr[2][1] = 4;
        arr[2][2] = 5;
        System.out.println(find(arr,2));
	}

}
