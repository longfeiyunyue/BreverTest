package cn.itcast.Letcode;

public class SetMismatch {//һ������Ԫ���� [1, n] ֮�䣬����һ�������滻Ϊ��һ�������ҳ��ظ������Ͷ�ʧ����
	
	public static int[] findErrorNums(int[] nums) {
		for(int i=0;i<nums.length;i++){
            while((nums[i]-1)!=i&& nums[nums[i] - 1] != nums[i]){
                exch(nums,i,nums[i]-1);
            }            
        }
        for (int i = 0; i < nums.length; i++) {
        if (nums[i] != i + 1) {
            return new int[]{nums[i], i + 1};
        }
    }
    return null;
	}
	
	private static void exch(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr= {1,2,2,4};
        int[] res=findErrorNums(arr);
        for(int i=0;i<res.length;i++) System.out.print(res[i]+",");
	}

}
