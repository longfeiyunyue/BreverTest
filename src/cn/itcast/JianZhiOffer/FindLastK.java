package cn.itcast.JianZhiOffer;

import org.junit.Test;

public class FindLastK {//ÃæÊÔÌâ22
	
	public static int findK(Node e,int k) {
		Node first=e;
		Node sec=e;
		int s=0;
		for(;first.next!=null;first=first.next) {
			s++;
			if(s>k-1) sec=sec.next;
		}
		return sec.val;
	}
	@Test
	public void test() {
		Node x6=new Node(6,null);
        Node x5=new Node(5,x6);
        Node x4=new Node(4,x5);
        Node x3=new Node(3,x4);
        Node x2=new Node(2,x3);
        Node x1=new Node(1,x2);
        System.out.println(findK(x1,8));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
