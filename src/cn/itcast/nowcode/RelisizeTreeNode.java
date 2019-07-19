package cn.itcast.nowcode;

import org.junit.Test;

public class RelisizeTreeNode {
	
	private class Node{
		Integer val;
		Node left;
		Node right;
		
		public Node(Node left,Node right,Integer val) {
			this.left=left;
			this.right=right;
			this.val=val;
		}		
		
		public Node(String s) {
			this.val=Integer.parseInt(s);
		}
		
	}
	@Test
	public void test() {
		Node n3=new Node(null,null,3);
		Node n12=new Node(n3,null,12);
		System.out.println(relisize(n12,""));
	}

	public String relisize(Node x,String s) {
		s=s+re(x);
		if(x!=null) s=relisize(x.left,s);
		if(x!=null) s=relisize(x.right,s);
		return s;
	}
	
	private String re(Node x) {
		if(x!=null) return x.val+"!";
		else return "#!";
	}
	@Test
	public void test2() {
		String s="12!3!#!#!#!";
		String[] vals=s.split("!");
		Node n=fanxuliehua(vals);
		System.out.println(relisize(n,"")+"----");
	}
	
	static int index = 0;
	//反序列化
	public  Node fanxuliehua(String[] str){
		if("#".equals(str[index])){
			++index;
			return null;
		} else {
			Node root = new Node(str[index]);
			++index;
			//递归左右子节点
			root.left=fanxuliehua(str);
			root.right=fanxuliehua(str);
			return root;
		}
	}

	
	/*public Node unRelisize(String s) {
		String[] vals=s.split("!");
		Node e=null;
		if(vals[0].equals("#")) {
			return null;
		}else {
			e=new Node(null,null,Integer.parseInt(vals[0]));
			for(int i=1;i<vals.length;i++) {
				
			}
		}
	}
	
	private Node unReli(Node e,String s) {
		if(s!="#") {
			Node x=e;
			for(;e.left!=null;e=e.left);
			e.left=new Node(null,null,Integer.parseInt(s));
			return x;
		}else {
			
		}
	}*/
}
