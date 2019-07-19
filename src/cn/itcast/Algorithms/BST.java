package cn.itcast.Algorithms;

import java.util.PriorityQueue;
import java.util.Queue;



public class BST<Key extends Comparable<Key>,Value> {
	private Node root;

	private class Node{
		public Key key;
		public Value val;
		public Node left,right;
		public int N;
		public Node(Key key,Value val,int n) {
			this.key=key;
			this.val=val;
			this.N=n;
		}
	}
	
	public int size() {
		return size(root);
	}
	
	private int size(Node x) {
		if(x==null) return 0;
		return x.N;
	}
	
	public void put(Key key,Value val) {
		root=put(root,key,val);
	}
	
	private Node put(Node x,Key key,Value val) {
		if(x==null) return new Node(key,val,1);
		int cmp=x.key.compareTo(key);
		if(cmp<0) x.right=put(x.right,key,val);
		else if(cmp>0) x.left=put(x.left,key,val);
		else x.val=val;
		x.N=size(x.left)+size(x.right)+1;
		return x;
	}
	
	public Value get(Key key) {
		return get(root,key).val;
	}
	
	private Node get(Node x,Key key) {
		if(x==null) return null;
		int cmp=key.compareTo(x.key);
		if(cmp<0) return get(x.left,key);
		else if(cmp>0) return get(x.right,key);
		else return x;
	}
	
	public Value min() {
		return min(root).val;
	}
	
	private Node min(Node x) {
		if(x.left==null) return x;
		return min(x.left);
	}
	
	public Value max() {
		return max(root).val;
	}
	
	private Node max(Node x) {
		if(x.right==null) return x;
		return max(x.right);
	}
	
	public Key floor(Key k) {
		Node x=floor(root,k);
		if(x!=null) return x.key;
		return null;
	}
	
	private Node floor(Node n,Key k) {
		if(n==null) return null;
		int i=k.compareTo(n.key);
		if(i<0) return floor(n.left,k);
		else if(i==0) return n;
		else {
			Node x=floor(n.right,k);
			if(x!=null) return x;
			else return n;
		}
	}
	
	public Key ceiling(Key k) {
		Node x=ceiling(root,k);
		if(x!=null) return x.key;
		return null;
	}
	
	private Node ceiling(Node n,Key k) {
		if(n==null) return null;
		int cmp=k.compareTo(n.key);
		if(cmp>0) return ceiling(n.right,k);
		else if(cmp==0) return n;
		else {
			Node x=ceiling(n.left,k);
			if(x!=null) return x;
			else return n;
		}
	}
	
	public Key select(int k) {
		return select(root,k).key;
	}
	
	private Node select(Node x,int k) {
		if(x==null)  return null;
		int t=size(x.left);
		if(t>k)  return select(x.left,k);
		else if(t<k)  return select(x.right,k-t-1);
		else  return x;
	}
	
	public int rank(Key key) {
		return rank(root,key);
	}
	
	private int rank(Node x,Key key) {
		if(x==null)  return 0;
		int t=key.compareTo(x.key);
		if(t<0)  return rank(x.left,key);
		else if(t>0)  return size(x.left)+1+rank(x.right,key);
		else return size(x.left);
	}
	
	public void deleteMin() {
		root=deleteMin(root);
	}
	
	private Node deleteMin(Node x) {
		if(x.left==null) return x.right;
		x.left=deleteMin(x.left);
		x.N=size(x.left)+size(x.right)+1;
		return x;
	}
	
	public void delete(Key k) {
		root=delete(root,k);
	}
	
	private Node delete(Node x,Key k) {
		if(x==null) return null;
		int cmp=k.compareTo(x.key);
		if(cmp<0) x.left=delete(x.left,k);
		else if(cmp>0) x.right=delete(x.right,k);
		else {
			if(x.left==null) return x.right;
			if(x.right==null) return x.left;
			Node n=x;
			x=min(x.right);
			x.right=deleteMin(n.right);
			x.left=n.left;
		}
		x.N=size(x.left)+size(x.right)+1;
		return x;
	}
	
	public Iterable<Key> keys(Key lo,Key hi){
		Queue<Key> q=new PriorityQueue<Key>();
		keys(root,q,lo,hi);
		return q;
	}
	
	private void keys(Node x,Queue<Key> q,Key lo,Key hi) {
		if(x==null) return;
		int locmp=lo.compareTo(x.key);
		int hicmp=hi.compareTo(x.key);
		if(locmp<0) keys(x.left,q,lo,hi);
		if(locmp<=0&&hicmp>=0) q.add(x.key);
		if(hicmp>0) keys(x.right,q,lo,hi);
	}
	
	public int height() {
		return height(root);
	}
	
	private int height(Node x) {
		if(x==null) return -1;
		return 1+Math.max(height(x.left), height(x.right));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST<Integer,String> st=new BST<Integer,String>();
		st.put(33, "a");
		st.put(14, "b");
		st.put(15, "c");
		st.put(2, "d");
		st.put(4, "e");
		st.put(15, "s");
		System.out.println(st.rank(15));
		System.out.println(st.select(1));
		System.out.println(st.ceiling(3));
		System.out.println(st.ceiling(14));
		//System.out.println(st.keys( st.min(),st.max()));
	}

}
