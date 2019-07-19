package cn.itcast.JianZhiOffer;

import java.util.ArrayDeque;

import org.junit.Test;


public class RowPrintTree {//√Ê ‘Ã‚32
	
	public void print(TreeNode root) {
		ArrayDeque<TreeNode> ad=new ArrayDeque<TreeNode>();
		ad.add(root);
		while(!ad.isEmpty()) {
			TreeNode n=ad.poll();
			if(n.left!=null) ad.add(n.left);
			if(n.right!=null) ad.add(n.right);
			System.out.print(n.val+",");
		}
	}
	
	@Test
	public void test() {
		TreeNode t10=new TreeNode(10);
		TreeNode t6=new TreeNode(6);
		TreeNode t8=new TreeNode(8);
		TreeNode t5=new TreeNode(5);
		TreeNode t7=new TreeNode(7);
		TreeNode t9=new TreeNode(9);
		TreeNode t1=new TreeNode(11);
		t8.left=t6;
		t8.right=t10;
		t6.left=t5;
		t6.right=t7;
		t10.left=t9;
		t10.right=t1;
		print(t8);
	}
	
	private class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val=val;
			this.left=null;
			this.right=null;
		}
		public String toString() {
			return "this.val is"+"["+val+"]";
		}
	}
}
