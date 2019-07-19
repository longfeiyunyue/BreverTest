package cn.itcast.Algorithms;

public class IndexMinPQ {
	private int N;
	private int[] pq;//堆,索引->键
	private int[] qp;//键反向找堆中的位置，键->索引
	private Double[] keys;//键值对
	
	public IndexMinPQ(int n) {
		N=0;
		pq=new int[n+1];
		qp=new int[n+1];
		keys=new Double[n+1];
		for(int i=0;i<n+1;i++) qp[i]=-1;
	}
	
	public void insert(int k,double val) {
		pq[++N]=k;
		keys[k]=val;
		qp[k]=N;
		swim(N);
	}
	
	public double delMin() {
		Double min=keys[pq[1]];
		exch(1,N--);
		sink(1);
		qp[pq[N+1]]=-1;
		keys[pq[N+1]]=null;
		pq[N+1]=0;
		return min;
	}
	
	private void exch(int i,int j) {
		int temp=pq[i];
		pq[i]=pq[j];
		pq[j]=temp;
		qp[pq[i]]=j;
		qp[pq[j]]=j;
	}
	
	private void swim(int n) {
		while(n>1&&keys[pq[n]]<keys[pq[n/2]]) {
			exch(n,n/2);
			n=n/2;
		}
	}
	
	private void sink(int n) {
		while(2*n<N) {
			int j=2*n;
			if(j<N&&keys[pq[j]]>keys[pq[j+1]]) j++;
			if(keys[pq[n]]<keys[pq[j]]) break;
			exch(n,j);
			n=j;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
