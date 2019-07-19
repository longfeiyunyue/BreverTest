package cn.itcast.Letcode;

public class TestBiggestZiDuan {
	
	public static int sum(int[] arr) {
		int[] opt=new int[arr.length];
		int res=arr[0];
		opt[0]=arr[0];
		for(int i=1;i<arr.length;i++) {
			opt[i]=Math.max(arr[i],opt[i-1]+arr[i]);
			res=Math.max(opt[i], res);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
