package cn.itcast.JianZhiOffer;

public class ChengJiArray {//√Ê ‘Ã‚66
	public static int[] multiply(int[] a) {
		if(a==null||a.length<2) return null;
		int[] b=new int[a.length];
		b[0]=1;
		for(int i=1;i<a.length;i++) {
			b[i]=b[i-1]*a[i-1];
		}
		int temp=1;
		for(int i=a.length-2;i>=0;i--) {
			temp*=a[i+1];
			b[i]*=temp;
		}
		return b;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
