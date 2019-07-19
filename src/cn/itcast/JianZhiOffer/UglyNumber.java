package cn.itcast.JianZhiOffer;

public class UglyNumber {
	
	public static int getUglyNumber(int k) {
		int[] arr=new int[k];
		arr[0]=1;
		int nextIndex=1;
		int t2=0,t3=0,t5=0;
		while(nextIndex<k) {
			arr[nextIndex]=Math.min(arr[t2]*2,Math.min(arr[t3]*3,arr[t5]*5));
			while(arr[t2]*2<=arr[nextIndex]) t2++;
			while(arr[t3]*3<=arr[nextIndex]) t3++;
			while(arr[t5]*5<=arr[nextIndex]) t5++;
			nextIndex++;
		}
		return arr[nextIndex-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=15;
        System.out.println(getUglyNumber(a));
	}

}
