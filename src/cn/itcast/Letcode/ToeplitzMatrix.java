package cn.itcast.Letcode;

public class ToeplitzMatrix {//�Խ�Ԫ����ȵľ���
	public boolean isToeplitzMatrix(int[][] matrix) {
		for(int i=1;i<matrix.length;i++) {
			for(int j=1;j<matrix[i].length;j++) {
				if(matrix[i][j]!=matrix[i-1][j-1]) return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
