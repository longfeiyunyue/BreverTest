package cn.itcast.Letcode;

public class ZeroOneTwo {//·ÖÀàÑÕÉ«
	public static void sort(int[] nums) {
		if(nums.length<=1) return;
		int zero=-1;
		int one=1;
		int two=nums.length;
		while(one<two) {
			if(nums[one]==0) exch(nums,++zero,one++);
			else if(nums[one]==2) exch(nums,--two,one);
			else one++;
		}
	}
	public static void exch(int [] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
