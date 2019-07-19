package cn.itcast.Letcode;

public class MaxOnes {//找出数组中最长的连续 1
	
	public static int findMaxConsecutiveOnes(int[] nums) {
		int count=0;
		int res=0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==1) count++;
			else count=0;
			res=Math.max(res,count);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,1,0,1,1,1};
       System.out.println(findMaxConsecutiveOnes(arr));
	}

}
