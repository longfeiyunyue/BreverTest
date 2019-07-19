package cn.itcast.backup;

public class FindK {

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
	
	public int find(int[] arr,int k) {
		int lo=0;
		int hi=arr.length-1;
		while(lo<=hi) {
			int j=partition(arr,lo,hi);
			if(j==k) return arr[k-1];
			else if(j>k) hi=j-1;
			else lo=j+1;
		}
		return arr[k-1];
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
