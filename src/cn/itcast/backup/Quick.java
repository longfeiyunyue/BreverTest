package cn.itcast.backup;

public class Quick {
	
	public static void sort(int[] arr) {
		sort(arr,0,arr.length-1);
	}
	
	public static void sort(int[] arr,int lo,int hi) {
		if(lo>=hi) return;
		int j=partition(arr,lo,hi);
		sort(arr,lo,j-1);
		sort(arr,j+1,hi);
	}
	
	private static int partition(int[] arr,int lo,int hi) {
		int i=lo,j=hi+1;
		int v=arr[lo];
		while(true) {
			while(arr[++i]<v) if(i>=hi) break;
			while(arr[--j]>v) if(j<=lo) break;
			if(i>=j) break;
			exch(arr,i,j);
		}
		exch(arr,lo,j);
		return j;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void exch(int[] a,int i,int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
}
