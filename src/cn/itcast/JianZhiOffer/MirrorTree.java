package cn.itcast.JianZhiOffer;

import org.junit.Test;


public class MirrorTree {//√Ê ‘Ã‚27
	
	public void mirror(TreeNode root) {
		if(root==null) return;
		if(root.left==null&&root.right==null) return;
		TreeNode temp=root.left;
		root.left=root.right;
		root.right=temp;
		if(root.left!=null) mirror(root.left);
		if(root.right!=null) mirror(root.right);
	}
	
	@Test
	public void test() {
		TreeNode t8=new TreeNode(8);
		TreeNode t6=new TreeNode(6);
		TreeNode t10=new TreeNode(10);
		TreeNode t5=new TreeNode(5);
		TreeNode t7=new TreeNode(7);
		TreeNode t9=new TreeNode(9);
		TreeNode t11=new TreeNode(11);
		t8.left=t6;
		t8.right=t10;
		t6.left=t5;
		t6.right=t7;
		t10.left=t9;
		t10.right=t11;
		mirror(t8);
		System.out.println(t8.left.left.val);
	}

	private class TreeNode{
		int val;
		TreeNode left,right;
		public TreeNode(int val) {
			this.val=val;
			this.left=null;
			this.right=null;
		}
	}
}
