package cn.itcast.Letcode;

public class DuplicateNum {//�ҳ��������ظ�����������ֵ�� [1, n] ֮��
	//Ҫ�����޸����飬Ҳ����ʹ�ö���Ŀռ�
	
	public int duplicate(int[] nums) {
		int left=1;
		int right=nums.length;
		while(left<=right) {
			int mid=left+(right-left)/2;
			int cot=0;
			for(int i=0;i<nums.length;i++) {
				if(nums[i]<=mid) cot++;
			}
			if(cot>mid) right=mid-1;
			else left=mid+1;
		}
		return nums[left];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
