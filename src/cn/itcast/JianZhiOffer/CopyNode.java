package cn.itcast.JianZhiOffer;

import org.junit.Test;



public class CopyNode {//√Ê ‘Ã‚35
	
	private void copyNode(Node head) {
		Node p=new Node();
		p=head;
		while(p!=null) {
			Node t=new Node();
			t.val=p.val;
			t.next=p.next;
			p.next=t;
			p=t.next;
		}
	}
	
	private void copySib(Node phead) {
		Node p=phead;
		while(p!=null) {
			Node cNode=p.next;
			if(p.sib!=null) cNode.sib=p.sib.next;
			p=cNode.next;
		}
	}
	
	private Node jieKai(Node phead) {
		Node pNode=phead;
		Node chead=null;
		Node cNode=null;
		if(pNode!=null) {
			chead=cNode=pNode.next;
			pNode.next=cNode.next;
			pNode=pNode.next;
		}
		while(pNode!=null) {
			cNode.next=pNode.next;
			cNode=cNode.next;
			pNode.next=cNode.next;
			pNode=pNode.next;
		}
		return chead;
	}
	
	public Node copy(Node head) {
		copyNode(head);
		copySib(head);
		Node copy=jieKai(head);
		return copy;
	}
	@Test
	public void test() {
		Node x5=new Node(5,null);
        Node x4=new Node(4,x5);
        Node x3=new Node(3,x4);
        Node x2=new Node(2,x3);
        Node x1=new Node(1,x2);
        x1.sib=x3;
        x2.sib=x5;
        x4.sib=x2;
        Node x=copy(x1);
        System.out.println(x1.next+"--"+x1.next.val);
        System.out.println(x.next+"--"+x.next.val);
        for(;x!=null;x=x.next)
        	System.out.print(x.val+"");
	}
	
	
	private class Node{
		int val;
		Node next;
		Node sib;
		public Node() {
			
		}
		
		public Node(int val,Node next) {
			this.val=val;
			this.next=next;
		}
	}

}
