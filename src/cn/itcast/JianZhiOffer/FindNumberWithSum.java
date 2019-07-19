package cn.itcast.JianZhiOffer;

public class FindNumberWithSum {//ÃæÊÔÌâ57
	
	public static int[] find(int[] arr,int s) {
		if(arr==null&&arr.length<2) return null;
		int start=0;
		int end=arr.length-1;
		int[] res=new int[2];
		while(end>start) {
			int sum=arr[start]+arr[end];
			if(sum==s) {
				res[0]=arr[start];
				res[1]=arr[end];
				break;
			}
			else if(sum<s) start++;
			else end--;
		}
		return res;
	}
	
	public static void find2(int s) {
		if(s<3) return;
		int small=1;
		int big=2;
		int mid=1+(s-1)/2;
		int sum=small+big;
		while(small<mid&&big<s) {
			if(sum==s) printf(small,big);
			while(sum>s&&small<mid) {
				sum-=small;
				small++;
				if(sum==s) printf(small,big);
			}
			big++;
			sum+=big;
		}
		
	}
	
	private static void printf(int small,int big) {
		for(int i=small;i<=big;i++)  System.out.print(i+",");
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,4,7,11,15};
        int[] res=find(arr,15);
        /*for(int i=0;i<res.length;i++) System.out.print(res[i]+",");
        System.out.println(res[0]+"--"+res[1]);*/
        find2(15);
	}

}
