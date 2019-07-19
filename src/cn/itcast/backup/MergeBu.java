package cn.itcast.backup;

public class MergeBu {
	private static int[] aux;
	
	public static void sort(int[] a) {
		int N=a.length;
		aux=new int[N];
		for(int sz=1;sz<N;sz=sz+sz) {
			for(int lo=0;lo<N-sz;lo+=sz+sz)
				merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
		}
	}
	
	private static void merge(int[] a,int lo,int mid,int hi) {
		int i=lo;
		int j=mid+1;
		for(int k=lo;k<=hi;k++) aux[k]=a[k];
		for(int k=lo;k<=hi;k++) {
			if(i>mid) a[k]=aux[j++];
			else if(j>hi) a[k]=aux[i++];
			else if(aux[i]<aux[j]) a[k]=aux[i++];
			else a[k]=aux[j++];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
