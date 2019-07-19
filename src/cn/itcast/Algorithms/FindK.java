package cn.itcast.Algorithms;

import java.util.Arrays;



public class FindK {
	
	private static int partition(int[] a,int lo,int hi) {
		int i=lo;
		int j=hi+1;
		int v=a[lo];
		while(true) {
			while(a[++i]<v) if(i>=hi) break;
			while(a[--j]>v) if(j<=lo) break;
			if(i>=j) break;
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
	}
	
	public static int findK(int[] a,int k) {
		int lo=0;
		int hi=a.length-1;
		while(lo<hi) {
			int j=partition(a,lo,hi);
			if(j==k) return a[k-1];
			if(k<j) hi=j-1;
			if(k>j) lo=j+1;
		}
		return a[k-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {2,1,5,3,88,4,5,780,9};
        System.out.println(findK(a,4));
        Heap.sort(a);
		System.out.println(Arrays.toString(a));
	}
	public static void exch(int[] a,int i,int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
}
