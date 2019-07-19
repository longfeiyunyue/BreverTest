package cn.itcast.JianZhiOffer;

public class Fabnoicc {//√Ê ‘Ã‚10
	
	public static int sum(int n) {
		int[] arr=new int[n+1];
		arr[0]=0;
		arr[1]=1;
		for(int i=2;i<=n;i++) arr[i]=arr[i-1]+arr[i-2];
		return arr[n];
	}
	
	public static int jump(int n) {
		int[] arr=new int[n+1];
		arr[0]=0;
		arr[1]=1;
		arr[2]=2;
		for(int i=3;i<=n;i++) arr[i]=arr[i-1]+arr[i-2];
		return arr[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sum(40));
	}

}
