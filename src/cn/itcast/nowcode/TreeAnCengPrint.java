package cn.itcast.nowcode;

import java.util.ArrayDeque;

import org.junit.Test;

public class TreeAnCengPrint {
	
	private class Node{
		Integer val;
		Node left;
		Node right;
		
		public Node(Node left,Node right,Integer val) {
			this.left=left;
			this.right=right;
			this.val=val;
		}		
		
	}
	
	public void print(Node e) {
		ArrayDeque<Node> q=new ArrayDeque<Node>();
		q.add(e);
		Node last=e;
		Node nlast=e;
		Node x=null;
		int i=0;
		while((x=q.poll())!=null) {
			System.out.println(x.val);			
			if(x.left!=null) {
				q.add(x.left);
				nlast=x.left;
			}
			
			if(x.right!=null) {
				q.add(x.right);
				nlast=x.right;
			}
			
			if(x.val==last.val) {
				System.out.println("µÚ"+(++i)+"²ã´òÓ¡Íê±Ï");
				last=nlast;
			}
		}
	}
	@Test
	public void test() {
		Node n7=new Node(null,null,7);
		Node n8=new Node(null,null,8);
		Node n5=new Node(n7,n8,5);
		Node n6=new Node(null,null,6);
		Node n3=new Node(n5,n6,3);
		Node n4=new Node(null,null,4);
		Node n2=new Node(n4,null,2);
		Node n1=new Node(n2,n3,1);
		print(n1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
