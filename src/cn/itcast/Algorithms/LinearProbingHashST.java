package cn.itcast.Algorithms;

public class LinearProbingHashST<Key,Value> {

	private int n;
	private int m;
	private static final int minCap=4;
	private Key[] keys;
	private Value[] vals;
	
	public LinearProbingHashST() {
		this(minCap);
	}
	
	public LinearProbingHashST(int cap) {
		this.n=0;
		this.m=cap;
		keys=(Key[])new Object[cap];
		vals=(Value[])new Object[cap];
	}
	
	private int hash(Key key) {
		return (key.hashCode()&0x7fffffff)%m;
	}
	
	public void put(Key key,Value val) {
		if(val==null) {
			delete(key);
			return;
		}
		if(n>m/2) resize(2*m);
		int i=hash(key);
		for(;keys[i]!=null;i=(i+1)%m) {
			if(key.equals(keys[i])) {
				vals[i]=val;
				return;
			}
		}
		keys[i]=key;
		vals[i]=val;
		n++;
		
	}
	
	public Value get(Key key) {
		for(int i=hash(key);keys[i]!=null;i=(i+1)%m) {
			if(key.equals(keys[i])) return vals[i];
		}
		return null;
	}
	
	public boolean contains(Key key) {
		return get(key)!=null;
	}
	
	public void delete(Key key) {
		if(!contains(key)) return;
		int hash=hash(key);
		while(!key.equals(keys[hash])) hash=(hash+1)%m;
		keys[hash]=null;
		vals[hash]=null;
		hash=(hash+1)%m;
		while(keys[hash]!=null) {
			Key tk=keys[hash];
			Value vk=vals[hash];
			keys[hash]=null;
			vals[hash]=null;
			n--;
			put(tk,vk);
			hash=(hash+1)%m;
		}
		n--;
		if(n>0&&n<=minCap/8) resize(m/2);
	}
	
	private void resize(int newCap) {
		LinearProbingHashST<Key,Value> temp=new LinearProbingHashST<Key,Value>(newCap);
		for(int i=0;i<m;i++) {
			if(keys[i]!=null) temp.put(keys[i], vals[i]);
		}
		this.m=temp.m;
		this.keys=temp.keys;
		this.vals=temp.vals;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
