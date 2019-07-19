package cn.itcast.Algorithms;

import java.util.PriorityQueue;
import java.util.Queue;


public class SequentialSearchST<Key,Value> {
	private Node first;
	private int N;
		
	public SequentialSearchST() {
		this.first=null;
		this.N=0;
	}

	private class Node{
		Node next;
		Key key;
		Value value;
		public Node(Key key,Value value,Node next) {
			this.key=key;
			this.value=value;
			this.next=next;
		}
	}
	
	public void put(Key key,Value value) {
		for(Node x=first;x!=null;x=x.next) {
			if(key.equals(x.key)) {
				x.value=value;
				return;
			}			
		}
		first=new Node(key,value,first);
		N++;
	}
	
	public Value get(Key key) {
		for(Node x=first;x!=null;x=x.next) {
			if(x.key.equals(key)) return x.value;
		}
		return null;
	}
	
	public int size() {
		return N;
	}
	
	public void delete(Key key) {
		first=delete(first,key);
	}
	
	private Node delete(Node x,Key key) {
		if(x==null) return null;
		if(x.key.equals(key)) {
			N--;
			return x.next;
		}
		x.next=delete(x.next,key);
		return x;
	}
	
	public Iterable<Key> keys(){
    	Queue<Key> q=new PriorityQueue<Key>();
        for (Node x = first; x != null; x = x.next)
            q.add(x.key);
        return q;
    }
	
	public boolean contains(Key key) {
		return get(key)!=null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SequentialSearchST<Integer,String> st=new SequentialSearchST<Integer,String>();
    	st.put(1, "a");
    	st.put(2, "b");
    	st.put(3, "c");
    	st.delete(2);
    	System.out.println(st.keys());
	}

}
