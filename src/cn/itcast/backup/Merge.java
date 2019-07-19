package cn.itcast.backup;

public class Merge {
	private static int[] aux;
	
	private static void merge(int[] arr,int lo,int mid,int hi) {
		for(int k=lo;k<=hi;k++) aux[k]=arr[k];
		int i=lo,j=mid+1;
		for(int k=lo;k<=hi;k++) {
			if(j>hi) arr[k]=aux[i++];
			else if(i>mid) arr[k]=aux[j++];
			else if(aux[i]>aux[j]) arr[k]=aux[j++];
			else arr[k]=aux[i++];
		}
	}
	
	private static void sort(int[] arr,int lo,int hi) {
		if(lo>=hi) return;
		int mid=lo+(hi-lo)/2;
		sort(arr,lo,mid);
		sort(arr,mid+1,hi);
		merge(arr,lo,mid,hi);
	}
	
	public static void sort(int[] arr) {
		aux=new int[arr.length];
		sort(arr,0,arr.length-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
