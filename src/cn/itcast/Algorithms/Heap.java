package cn.itcast.Algorithms;

import java.util.Arrays;

public class Heap {
	
	public Heap() {
		
	}
	
	public static void sort(int[] pq) {
		int N=pq.length;
		for(int i=N/2;i>=1;i--) sink(pq,i,N);
		while(N>1) {
			exch(pq,1,N--);
			sink(pq,1,N);
		}
	}
	
	public static void sink(int[] pq,int k,int n) {
		while(2*k<=n) {
			int j=2*k;
			if(j<n&&pq[j-1]<pq[j+1-1]) j++;
			if(pq[k-1]>=pq[j-1]) break;
			exch(pq,k,j);
			k=j;
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {2,1,5,3,88,4,5,780,9};
        sort(a);
        System.out.println(Arrays.toString(a));
	}

	private static void exch(int[] a,int i,int j) {
		int temp=a[i-1];
		a[i-1]=a[j-1];
		a[j-1]=temp;
	}
}
