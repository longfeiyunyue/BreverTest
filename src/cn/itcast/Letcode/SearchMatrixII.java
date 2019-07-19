package cn.itcast.Letcode;

public class SearchMatrixII {//”––Úæÿ’Û≤È’“
	
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix==null||matrix.length==0||matrix[0].length==0) return false;
		int row=0;
		int col=matrix[0].length-1;
		while(row<matrix.length&&col>=0) {
			if(target==matrix[row][col]) return true;
			else if(target<matrix[row][col]) col--;
			else row++;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
