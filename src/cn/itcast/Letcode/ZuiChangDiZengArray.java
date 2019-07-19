package cn.itcast.Letcode;

public class ZuiChangDiZengArray {//最长递增子序列
	
	public static int sum(int[] arr) {
		if(arr==null||arr.length==0) return 0;
		if(arr.length==1) return 1;
		int[] opt=new int[arr.length];
		int maxL=0;
		opt[0]=1;
		for(int i=1;i<opt.length;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]) opt[i]=Math.max(opt[i],opt[j]+1);
				else opt[i]=Math.max(opt[i],1);
			}
			maxL=Math.max(maxL,opt[i]);
		}
		return maxL;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
