package cn.itcast.Algorithms;

import java.util.PriorityQueue;
import java.util.Queue;



public class BinarySearchST<Key extends Comparable<Key>,Value> {
	private Key[] keys;
	private Value[] vals;
	private int N;
	
	public BinarySearchST(int maxN) {
		keys=(Key[])new Comparable[maxN];
		vals=(Value[])new Object[maxN];
		N=0;
	}
	
	private int rank(Key k) {
		int lo=0;
		int hi=N-1;
		while(lo<=hi) {
			int mid=lo+(hi-lo)/2;
			if(k.compareTo(keys[mid])<0) hi=mid-1;
			else if(k.compareTo(keys[mid])>0) lo=mid+1;
			else return mid;
		}
		return lo;
	}
	
	public void put(Key key,Value val) {
		int i=rank(key);
		if(i<N&&key.compareTo(keys[i])==0) {
			vals[i]=val;
			return;
		}
		
		for(int k=N;k>i;k--) {
			keys[k]=keys[k-1];
			vals[k]=vals[k-1];
		}
		
		keys[i]=key;
		vals[i]=val;
		N++;
	}
	
	public Value get(Key key) {
		if(isEmpty()) return null;
		int i=rank(key);
		if(i<N&&key.compareTo(keys[i])==0) return vals[i];
		else return null;
	}
	
	public void delete(Key key) {
		int i=rank(key);
		if(i<N&&key.compareTo(keys[i])==0) {
			for(int k=i;k<N-1;k++) {
				keys[k]=keys[k+1];
				vals[k]=vals[k+1];
			}
			N--;
			keys[N]=null;
			vals[N]=null;
		}
	}
	public boolean contains(Key k) {
		return get(k)!=null;
	}
	
	public Iterable<Key> keys(Key lo,Key hi){
		Queue<Key> q=new PriorityQueue<Key>();
		for(int i=rank(lo);i<rank(hi);i++) {
			q.add(keys[i]);
		}
		if(contains(hi)) q.add(keys[rank(hi)]);
		return q;
	}
	
	public boolean isEmpty() {
		return N==0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchST<Integer,String> st=new BinarySearchST<Integer,String>(30);
		st.put(1, "a");
    	st.put(2, "b");
    	st.put(4, "d");
    	st.put(5, "e");
    	st.put(3, "c");
    	System.out.println(st.rank(4));
    	System.out.println(st.get(4));
	}

}
