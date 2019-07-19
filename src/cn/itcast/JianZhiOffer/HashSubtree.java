package cn.itcast.JianZhiOffer;

import org.junit.Test;



public class HashSubtree {//√Ê ‘Ã‚26
	
	public boolean isSub(TreeNode big,TreeNode small) {
		boolean flag=false;
		if(big==null||small==null) return false;
		if(big.val==small.val) flag=isSon(big,small);
		if(!flag) flag=isSub(big.left,small);
		if(!flag) flag=isSub(big.right,small);
		return flag;
	}
	
	private boolean isSon(TreeNode big,TreeNode small) {
		if(small==null) return true;
		if(big==null) return false;
		if(big.val!=small.val) return false;
		return isSon(big.left,small.left)&&isSon(big.right,small.right);
	}
	
	@Test
	public  void test() {
		TreeNode t8=new TreeNode(8);
		TreeNode t81=new TreeNode(8);
		TreeNode t7=new TreeNode(7);
		TreeNode t9=new TreeNode(9);
		TreeNode t2=new TreeNode(2);
		TreeNode t4=new TreeNode(4);
		TreeNode t71=new TreeNode(7);
		t8.left=t81;
		t8.right=t7;
		t81.left=t9;
		t81.right=t2;
		t2.left=t4;
		t2.right=t71;
		TreeNode tc8=new TreeNode(8);
		TreeNode tc9=new TreeNode(9);
		TreeNode tc2=new TreeNode(2);
		tc8.left=tc9;
		tc8.right=tc2;
		boolean f=isSub(t8,tc8);
		System.out.println(f);
	}

	private class TreeNode{
		int val;
		TreeNode left,right;
		public TreeNode(int val) {
			this.val=val;
			this.left=null;
			this.right=null;
		}
		public String toString() {
			return "this val is ["+val+"]";
		}
	}
}
