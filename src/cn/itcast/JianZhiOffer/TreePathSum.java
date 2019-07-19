package cn.itcast.JianZhiOffer;

import java.util.Stack;

import org.junit.Test;



public class TreePathSum {//√Ê ‘Ã‚34
	
	public void sum(TreeNode x,int expect) {
		if(x==null) return;
		sum(x,expect,0,new Stack<Integer>());
	}
	
	private void sum(TreeNode x,int expect,int cur,Stack<Integer> st) {
		cur+=x.val;
		st.push(x.val);
		boolean isLeaf=(x.left==null)&&(x.right==null);
		if(cur==expect&&isLeaf) {
			for(int i:st) System.out.print(i+",");
			System.out.println();
		}
		else if(cur>expect) {
			st.pop();
			return;
		}
		if(x.left!=null) sum(x.left,expect,cur,st);
		if(x.right!=null) sum(x.right,expect,cur,st);
		st.pop();
	}
	
	@Test
	public void test() {
		TreeNode t10=new TreeNode(10);
		TreeNode t12=new TreeNode(12);
		TreeNode t4=new TreeNode(4);
		TreeNode t5=new TreeNode(5);
		TreeNode t7=new TreeNode(7);
		t10.left=t5;
		t10.right=t12;
		t5.left=t4;
		t5.right=t7;
		sum(t10,22);		
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
