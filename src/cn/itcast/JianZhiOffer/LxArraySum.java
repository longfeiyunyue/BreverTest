package cn.itcast.JianZhiOffer;

public class LxArraySum {
	
	public static int sum(int[] arr) {
		int[] opt=new int[arr.length];
		opt[0]=arr[0];
		int result=opt[0];
		for(int i=1;i<arr.length;i++) {
			opt[i]=Math.max(arr[i], opt[i-1]+arr[i]);
			result=Math.max(result,opt[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,-2,3,10,-4,7,2,-5};
        System.out.println(sum(arr));
	}

}
