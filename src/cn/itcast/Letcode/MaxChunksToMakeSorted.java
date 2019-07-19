package cn.itcast.Letcode;

public class MaxChunksToMakeSorted {//分隔数组，使得对每部分排序后数组就为有序
	//数组元素在0~n-1之间，尽可能多地分割，每个部分最大值一定不会超过此区间的索引
	public int maxChunksToSorted(int[] arr) {
		if(arr==null) return 0;
		int cot=0;
		int max=arr[0];
		for(int i=0;i<arr.length;i++) {
			max=Math.max(max, arr[i]);
			if(max==i) cot++;
		}
		return cot;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
