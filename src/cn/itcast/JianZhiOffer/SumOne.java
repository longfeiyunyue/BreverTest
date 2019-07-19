package cn.itcast.JianZhiOffer;

public class SumOne {//√Ê ‘Ã‚15
	
	public static int sum(int n) {
		int count=0;
		int flag=1;
		while(flag!=0) {
			if((flag&n)==flag) count++;
			flag=flag<<1;
		}
		return count;
	}
	
	public static int sum2(int n) {
		int count=0;
		while(n!=0) {
			count++;
			n=n&(n-1);
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sum2(9));
	}

}
