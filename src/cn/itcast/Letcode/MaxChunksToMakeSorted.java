package cn.itcast.Letcode;

public class MaxChunksToMakeSorted {//�ָ����飬ʹ�ö�ÿ��������������Ϊ����
	//����Ԫ����0~n-1֮�䣬�����ܶ�طָÿ���������ֵһ�����ᳬ�������������
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
