package cn.itcast.Algorithms;

public class MaxPQ {
	private int[] pq;
	private int N;
	
	public MaxPQ(int maxN) {
		pq=new int[maxN+1];
		N=0;
	}
	
	public boolean isEmpty() {
		return N==0;
	}
	
	public int size() {
		return N;
	}
	
	private void swim(int k) {
		while(k>1&&pq[k/2]<pq[k]) {
			exch(pq,k,k/2);
			k=k/2;
		}
	}
	
	private void sink(int k) {
		while(2*k<=N) {
			int j=2*k;
			if(j<N&&pq[j]<pq[j+1]) j++;
			if(pq[k]>=pq[j]) break;
			exch(pq,k,j);
			k=j;
		}
	}
	
	public void insert(int s) {
		pq[++N]=s;
		swim(N);
	}
	
	public double delMax() {
		int max=pq[1];
		exch(pq,1,N--);
		pq[N+1]=0;
		sink(1);
		return max;
	}
	
	public static void exch(int[] a,int i,int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
}
