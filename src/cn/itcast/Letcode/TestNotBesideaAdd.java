package cn.itcast.Letcode;

public class TestNotBesideaAdd {
	
	public static int sum(int[] arr) {
		int N=arr.length;
		int[] opt=new int[N];
		opt[0]=arr[0];
		if(N>0) opt[1]=Math.max(arr[0],arr[1]);
		for(int i=2;i<N;i++) {
			int a=arr[i]+opt[i-2];
			int b=opt[i-1];
			opt[i]=Math.max(a, b);
		}
		return opt[N-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,4,1,7,8,3};
        System.out.println(sum(arr));
	}

}
