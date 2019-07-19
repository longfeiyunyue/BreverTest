package cn.itcast.JianZhiOffer;

import java.util.Stack;

import org.junit.Test;



public class TreeToLinked {//√Ê ‘Ã‚36
	
	private TreeNode convert(TreeNode root) {
		if(root==null) return null;
		TreeNode p=root;
		TreeNode pre=null;
		boolean isFirst=true;
		Stack<TreeNode> st=new Stack<TreeNode>();
		while(p!=null||!st.isEmpty()) {
			while(p!=null) {
				st.push(p);
				p=p.left;
			}
			p=st.pop();
			if(isFirst) {
				root=p;
				isFirst=false;
				pre=p;
			}else {
				pre.right=p;
				p.left=pre;
				pre=p;
			}
			p=p.right;
		}
		return root;
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
		TreeNode root=convert(t10);
		for(;root!=null;root=root.right)
			System.out.print(root.val+",");
	}
	
	private class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val=val;
		}
	}
}
