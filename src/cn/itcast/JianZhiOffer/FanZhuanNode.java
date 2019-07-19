package cn.itcast.JianZhiOffer;



public class FanZhuanNode {//√Ê ‘Ã‚24
	
	public static Node reverse(Node n) {
		if(n==null||n.next==null) return n;
		Node last=null;
		Node next=null;
		Node pre=n;
		while(pre!=null) {
			next=pre.next;
			pre.next=last;
			last=pre;
			pre=next;
		}
		return last;
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
