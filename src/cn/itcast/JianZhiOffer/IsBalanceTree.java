package cn.itcast.JianZhiOffer;

import org.junit.Test;



public class IsBalanceTree {//面试题55 是否是平衡二叉树
	
	public boolean isBalance(TreeNode e) {
		if(e==null) return true;
		if(e.left==null&&e.right==null) {
			e.high=0;
			return true;
		}
		int left;
		int right;
		if(isBalance(e.left)&&isBalance(e.right)) {
			left=height(e.left);
			right=height(e.right);
			int cha=left-right;
			if(cha>=-1&&cha<=1) {
				e.high=(left>right?left:right)+1;
				return true;
			}
		}
		return false;
	}
	
	private int height(TreeNode e) {
		if(e!=null) return e.high;
		return 0;
	}
	
	@Test
	public void test() {
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t4=new TreeNode(4);
		TreeNode t5=new TreeNode(5);
		TreeNode t7=new TreeNode(7);
		TreeNode t3=new TreeNode(3);
		TreeNode t6=new TreeNode(6);
		t1.left=t2;
		t2.left=t4;
		t2.right=t5;
		t5.left=t7;
		t1.right=t3;
		t3.right=t6;
		System.out.println(isBalance(t1));		
	}

	private class TreeNode{
		int val;
		TreeNode left,right;
		int high;
		public TreeNode(int val) {
			this.val=val;
		}
	}
}
