package cn.itcast.Letcode;

public class LongestPalindrome {//����һ���ַ����Ͽ�����ɵĻ����ַ�������󳤶�
	public int longestPalindrome(String s) {
		int[] cnts=new int[256];
		for(char c:s.toCharArray()) cnts[c]++;
		int cot=0;
		for(int cnt:cnts) {
			cot+=(cnt/2)*2;
		}
		if(cot<s.length()) cot++;
		return cot;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
