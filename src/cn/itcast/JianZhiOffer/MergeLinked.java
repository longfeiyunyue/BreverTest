package cn.itcast.JianZhiOffer;

import org.junit.Test;



public class MergeLinked {//ÃæÊÔÌâ25
	
	public Node merge(Node x1,Node x2) {
		Node n=new Node(-1,null);
		Node head=n;
		while(x1!=null||x2!=null) {
			if(x1==null) {
				n.next=x2;
				n=n.next;
				x2=x2.next;
			}
			else if(x2==null) {
				n.next=x1;
				n=n.next;
				x1=x1.next;
			}
			else if(x1.val>x2.val) {
				n.next=x2;
				n=n.next;
				x2=x2.next;
			}
			else {
				n.next=x1;
				n=n.next;
				x1=x1.next;
			}
		}
		return head.next;
	}
	
	@Test
	public void test() {
		Node x7=new Node(7,null);
        Node x5=new Node(5,x7);
        Node x3=new Node(3,x5);
        Node x1=new Node(1,x3);
        Node x8=new Node(8,null);
        Node x6=new Node(6,x8);
        Node x4=new Node(4,x6);
        Node x2=new Node(2,x4);
        Node x=merge(x1,x2);
        System.out.println(x);
        for(;x!=null;x=x.next)
        	System.out.print(x.val+",");
	}
	
	public class Node{
		int val;
		Node next;
		public Node(int val,Node next) {
			this.val=val;
			this.next=next;
		}
		
	}
}
