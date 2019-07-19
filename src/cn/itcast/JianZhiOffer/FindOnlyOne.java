package cn.itcast.JianZhiOffer;

public class FindOnlyOne {//√Ê ‘Ã‚56
	
	public static int[] find(int[] arr) {
		if(arr.length<2) return null;
		int[] res=new int[2];
		int re=0;
		for(int i=0;i<arr.length;i++) re^=arr[i];
		int bit=findFirstBit(re);
		int d1=0;
		int d2=0;
		for(int i=0;i<arr.length;i++) {
			if(isBit(arr[i],bit)) d1^=arr[i];
			else d2^=arr[i];
		}
		res[0]=d1;
		res[1]=d2;
		return res;
	}
	
	private static boolean isBit(int s,int cot) {
		s=s>>cot;
		return (s&1)==0;
	}
	
	private static int findFirstBit(int s) {
		int count=0;
		while((s&1)==0) {
			count++;
			s=s>>1;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {2,4,3,6,3,2,5,5};
        int[] co=find(a);
        for(int i=0;i<co.length;i++) System.out.println(co[i]);
	}

}
