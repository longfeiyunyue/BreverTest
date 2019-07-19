package cn.itcast.JianZhiOffer;

import org.junit.Test;



public class TreeDepth {//ÃæÊÔÌâ55
	
	public int depth(TreeNode x) {
		if(x==null||(x.left==null&&x.right==null)) return 0;
		else {
			int dl=depth(x.left);
			int dr=depth(x.right);
			return dl>dr?(dl+1):(dr+1);
		}
	}
	
	@Test
	public void test() {
		TreeNode t10=new TreeNode(10);
		TreeNode t6=new TreeNode(6);
		TreeNode t4=new TreeNode(4);
		TreeNode t8=new TreeNode(8);
		TreeNode t14=new TreeNode(14);
		TreeNode t12=new TreeNode(12);
		TreeNode t16=new TreeNode(16);
		t10.left=t6;
		t6.left=t4;
		t6.right=t8;
		t10.right=t14;
		t14.left=t12;
		t14.right=t16;
		System.out.println(depth(t10));
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
