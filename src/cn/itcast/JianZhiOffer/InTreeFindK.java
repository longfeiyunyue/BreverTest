package cn.itcast.JianZhiOffer;

import org.junit.Test;



public class InTreeFindK {//√Ê ‘Ã‚54
	static int count=0;
	public TreeNode find(TreeNode e,int k) {
		return findK(e,k);
	}
	
	private TreeNode findK(TreeNode e,int k) {
		if(e==null) return null;
		TreeNode left=findK(e.left,k);
		if(left!=null) return left;
		count++;
		if(count==k) return e;
		TreeNode right=findK(e.right,k);
		if(right!=null) return right;
		return null;
	}
	
	@Test
	public void test() {
		TreeNode t6=new TreeNode(6);
		TreeNode t8=new TreeNode(8);
		TreeNode t5=new TreeNode(5);
		TreeNode t7=new TreeNode(7);
		TreeNode t3=new TreeNode(3);
		TreeNode t2=new TreeNode(2);
		TreeNode t4=new TreeNode(4);
		t5.left=t3;
		t5.right=t7;
        t3.left=t2;
        t3.right=t4;
        t7.left=t6;
        t7.right=t8;
        TreeNode re=find(t5,3);
       // print(t5);
        System.out.println();
        System.out.println(re);
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
