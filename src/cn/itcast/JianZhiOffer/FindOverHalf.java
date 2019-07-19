package cn.itcast.JianZhiOffer;

public class FindOverHalf {//√Ê ‘Ã‚39
	
	private static int paratition(int[] arr,int lo,int hi) {
		int i=lo;
		int j=hi+1;
		int v=arr[lo];
		while(true) {
			while(arr[++i]<=v) if(i>=hi) break;
			while(arr[--j]>=v) if(j<=lo) break;
			if(i>=j) break;
			exch(arr,i,j);
		}
		exch(arr,lo,j);
		return j;
	}
	
	public static int select(int[] arr,int k) {//method1
		int lo=0;
		int hi=arr.length-1;
		while(lo<hi) {
			int j=paratition(arr,lo,hi);
			if(k==j) return arr[j];
			else if(k>j) lo=j+1;
			else hi=j-1;
		}
		return -1;
	}
	
	public static boolean check(int[] arr,int key) {
		int cot=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==key) cot++;
		}
		if(cot*2>=arr.length) return true;
		return false;
	}
	
	public static int morethan(int[] arr) {//method2
		int res=arr[0];
		int cot=1;
		for(int i=1;i<arr.length;i++) {
			if(cot==0) {
				res=arr[i];
				cot=1;
			}
			else if(res==arr[i]) cot++;
			else if(res!=arr[i]) cot--;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,2,3,2,2,2,5,4,2};
		int s=select(a,a.length/2);
		if(check(a,s)) System.out.println(s);
		int res=morethan(a);
		if(check(a,res)) System.out.println(res);
	}
	public static void exch(int[] arr,int i,int j) {
		int temo=arr[i];
		arr[i]=arr[j];
		arr[j]=temo;
	}
}
