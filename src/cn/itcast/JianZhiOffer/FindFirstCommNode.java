package cn.itcast.JianZhiOffer;

import org.junit.Test;



public class FindFirstCommNode {//√Ê ‘Ã‚52
	
	private int length(Node root) {
		Node e=root;
		int len=0;
		for(;e!=null;e=e.next) len++;
		return len;
	}
	
	public Node findComm(Node x1,Node x2) {
		int len1=length(x1);
		int len2=length(x2);
		int cha=len1-len2;
		Node longNode=x1;
		Node shortNode=x2;
		if(cha<0) {
			longNode=x2;
			shortNode=x1;
			cha=len2-len1;
		}
		for(int i=0;i<cha;i++) longNode=longNode.next;
		while(longNode!=null&&shortNode!=null&&longNode!=shortNode) {
			longNode=longNode.next;
			shortNode=shortNode.next;
		}
		return longNode;
	}
	
	@Test
	public void test() {
		Node x7=new Node(7,null);
		Node x6=new Node(6,x7);
        Node x5=new Node(5,x6);
        Node x4=new Node(4,x5);      
        Node x3=new Node(3,x6);
        Node x2=new Node(2,x3);
        Node x1=new Node(1,x2);
        Node equ=findComm(x1,x4);
        System.out.println(equ.val);
	}

	private class Node{
		int val;
		Node next;
		public Node(int val,Node next) {
			this.val=val;
			this.next=next;
		}
	}
}
