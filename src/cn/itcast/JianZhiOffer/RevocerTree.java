package cn.itcast.JianZhiOffer;

import java.util.Arrays;

public class RevocerTree{//重建二叉树 面试题7
	
	public TreeNode recover(int[] pre,int[] in) {
		if(pre.length==0) return new TreeNode(pre[0]);
		TreeNode root=new TreeNode(pre[0]);
		for(int i=1;i<in.length;i++) {
			if(pre[0]==in[i]) {
				root.left=recover(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in, 0, i));
				root.right=recover(Arrays.copyOfRange(pre, i+1,pre.length),Arrays.copyOfRange(in, i+1,in.length));
			}
		}
		return root;
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
