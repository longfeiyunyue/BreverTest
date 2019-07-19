package cn.itcast.Algorithms;

public class RedBlackBST<Key extends Comparable<Key>,Value> {
	
	private Node root;
	private static final boolean RED=true;
	private static final boolean BLACK=false;
	
	private class Node{
		Key key;
		Value val;
		Node left,right;
		int N;
		boolean color;
		public Node(Key key,Value val,int n,boolean color) {
			this.key=key;
			this.val=val;
			this.N=n;
			this.color=color;
		}
	}
	
	public int size() {
		return size(root);
	}
	
	private int size(Node n) {
		if(n==null) return 0;
		return n.N;
	}
	
	private boolean isRed(Node x) {
		return x.color==RED;
	}
	
	private Node rotateLeft(Node h) {
		Node x=h.right;
		h.right=x.left;
		x.left=h;
		x.color=h.color;
		h.color=RED;
		x.N=h.N;
		h.N=size(h.left)+size(h.right)+1;
		return x;
	}
	
	private Node rotateRight(Node h) {
		Node x=h.left;
		h.left=x.right;
		x.right=h;
		x.color=h.color;
		h.color=RED;
		x.N=h.N;
		h.N=size(h.left)+size(h.right)+1;
		return x;
	}
	
	private void flipColors(Node h) {
		h.color=RED;
		h.left.color=BLACK;
		h.right.color=BLACK;
	}
	
	public void put(Key key,Value val) {
		root=put(root,key,val);
		root.color=BLACK;
	}
	
	private Node put(Node x,Key key,Value val) {
		if(x==null) return new Node(key,val,1,RED);
		int cmp=key.compareTo(x.key);
		if(cmp<0) x.left=put(x.left,key,val);
		else if(cmp>0) x.right=put(x.right,key,val);
		else x.val=val;
		if(!isRed(x.left)&&isRed(x.right)) x=rotateLeft(x);
		if(isRed(x.left)&&isRed(x.left.left)) x=rotateRight(x);
		if(isRed(x.left)&&isRed(x.right)) flipColors(x);
		x.N=size(x.left)+size(x.right)+1;
		return x;
	}
	
	public Value get(Key key) {
		Node x=get(root,key);
		if(x==null) return null;
		return x.val;
	}
	
	private Node get(Node x,Key key) {
		if(x==null) return null;
		int v=key.compareTo(x.key);
		if(v<0) return get(x.left,key);
		else if(v>0) return get(x.right,key);
		else return x;
	}
	
	public Key min() {
		Node x=min(root);
		if(x==null) return null;
		return x.key;
	}
	
	private Node min(Node e) {
		if(e.left==null) return e;
		else return min(e.left);
	}
	
	public Key max() {
		Node e=max(root);
		if(e==null) return null;
		return e.key;
	} 
	
	private Node max(Node e) {
		if(e.right==null) return e;
		return max(e.right);
	}
	
	public Key select(int k) {
		Node x=select(root,k);
		if(x==null) return null;
		return x.key;
	}
	
	private Node select(Node x,int k) {
		if(x==null) return null;
		int i=size(x.left);
		if(k<i) return select(x.left,k);
		else if(k>i) return select(x.right,k-i-1);
		else return x;
	} 
	
	public int rank(Key key) {
		return rank(root,key);
	}
	
	private int rank(Node x,Key key) {
		if(x==null) return 0;
		int cmp=key.compareTo(x.key);
		if(cmp<0) return rank(x.left,key);
		else if(cmp>0) return size(x.left)+1+rank(x.right,key);
		else return size(x.left);
	}
	
	private void moveflipColors(Node x) {
		x.color=!x.color;
		x.left.color=!x.left.color;
		x.right.color=!x.right.color;
	}
	
	private Node moveRedLeft(Node x) {
		moveflipColors(x);
		if(isRed(x.right.left)) {
			x.right=rotateRight(x.right);
			x=rotateLeft(x);
			moveflipColors(x);
		}
		return x;
	}
	
	public void deleteMin() {
		if(!isRed(root.left)&&!isRed(root.right))
		root.color=RED;
		root=deleteMin(root);
		root.color=BLACK;
	}
	
	private Node deleteMin(Node x) {
		if(x.left==null) return null;
		if(!isRed(x.left)&&!isRed(x.left.left))
			moveRedLeft(x);
		x.left=deleteMin(x.left);
		return balance(x);
	}
	
	private Node balance(Node x) {
		if(isRed(x.right)) x=rotateLeft(x);
		if(!isRed(x.left)&&isRed(x.right)) x=rotateLeft(x);
		if(isRed(x.left)&&isRed(x.left.left)) x=rotateRight(x);
		if(isRed(x.left)&&isRed(x.right)) flipColors(x);
		x.N=size(x.left)+size(x.right)+1;
		return x;
	}
	
	private Node moveRedRight(Node x) {
		moveflipColors(x);
		if(isRed(x.left.left)) {
			x=rotateRight(x);
			moveflipColors(x);
		}
		return x;
	}
	
	public void deleteMax() {
		if(!isRed(root.left)&&!isRed(root.right)) root.color=RED;
		root=deleteMax(root);
		root.color=BLACK;
	}
	
	private Node deleteMax(Node x) {
		if(isRed(x.left)) x=rotateRight(x);
		if(x.right==null) return null;
		if(!isRed(x.right)&&!isRed(x.right.left)) x=moveRedRight(x);
		x.right=deleteMax(x.right);
		return balance(x);
		
	}
	
	public void delete(Key key) {
		if(!isRed(root.left)&&!isRed(root.right)) root.color=RED;
		root=delete(root,key);
		root.color=BLACK;
	}
	
	private Node delete(Node x,Key key) {
		if(key.compareTo(x.key)<0) {
			if(!isRed(x.left)&&!isRed(x.left.left)) x=moveRedLeft(x);
			x.left=delete(x.left,key);
		}else {
			if(isRed(x.left)) x=rotateRight(x);
			if(key.compareTo(x.key)==0&&x.right==null) return null;
			if(!isRed(x.right)&&!isRed(x.right.left)) x=moveRedRight(x);
			if(key.compareTo(x.key)==0) {
				Node e=min(x.right);
				x.key=e.key;
				x.val=e.val;
				x.right=deleteMin(x.right);
			}else {
				x.right=delete(x.right,key);
			}
		}
		return balance(x);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
