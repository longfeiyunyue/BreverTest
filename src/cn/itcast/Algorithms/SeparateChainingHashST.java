package cn.itcast.Algorithms;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;



@SuppressWarnings("unused")
public class SeparateChainingHashST<Key,Value> {

	private int n;
	private int m;
	private static final int minCap=9;
	private SequentialSearchST<Key,Value>[] st;
	
	public SeparateChainingHashST() {
		this(minCap);
	}
	
	public SeparateChainingHashST(int c) {
		this.m=c;
		st=(SequentialSearchST<Key,Value>[])new SequentialSearchST[c];
		for(int i=0;i<c;i++)
			st[i]=new SequentialSearchST<Key,Value>();
	}
	
	private int hash(Key key) {
		return (key.hashCode()&0x7fffffff)%m;
	}
	
	public boolean contains(Key key) {
		return get(key)!=null;
	}
	
	public void put(Key key,Value val) {
		if(n>=2*m) resize(2*m);
		int hash=hash(key);
		if(!st[hash].contains(key)) n++;		
		st[hash].put(key, val);
	}
	
	public Value get(Key key) {
		int hash=hash(key);
		if(!st[hash].contains(key)) return null;
		return st[hash].get(key);
	}
	
	private void resize(int cap) {
		SeparateChainingHashST<Key,Value> temp=new SeparateChainingHashST<Key,Value>(cap);
		for(int i=0;i<m;i++)
			for(Key k:st[i].keys())
				temp.put(k, st[i].get(k));
		this.st=temp.st;
		this.n=temp.n;
		this.m=temp.m;
	}
	
	public void delete(Key key) {
		int hash=hash(key);
		if(!contains(key)) return;
		n--;
		st[hash].delete(key);
		if(n>minCap&&n<2*m) resize(m/2);
	}
	
	public Iterable<Key> keys(){
		Queue<Key> q=new PriorityQueue<Key>();
		for(int i=0;i<m;i++) {
			for(Key k:st[i].keys()) q.add(k);
		}
		return q;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SeparateChainingHashST<Integer,String> st=new SeparateChainingHashST<Integer,String>(10);
		st.put(1, "a");
		//System.out.println(st.size());
    	st.put(2, "b");
    	st.put(3, "c");
    	st.put(3, "d");
    	st.delete(2);
    	for(Integer key:st.keys())
    		System.out.println(st.get(key));
	}

}
