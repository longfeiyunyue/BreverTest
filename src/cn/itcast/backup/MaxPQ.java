package cn.itcast.backup;

public class MaxPQ {
	private int[] pq;
	private int N;
	
	public MaxPQ(int n) {
		pq=new int[n+1];
		N=0;
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
	
	private void swim(int k) {
		while(k>1&&pq[k/2]<pq[k]) {
			exch(pq,k,k/2);
			k=k/2;
		}
	}
	
	public void insert(int i) {
		pq[++N]=i;
		swim(N);
	}
	
	public int delMax() {
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
