package cn.itcast.Letcode;

public class PalindromicSubstrings {//»ØÎÄ×Ó×Ö·û´®
	private int cnt=0;
	
	public int countSubstrings(String s) {
		for(int i=0;i<s.length();i++) {
			extendsString(s,i,i);
			extendsString(s,i,i+1);
		}
		return cnt;
	}
	
	
	private void extendsString(String s,int start,int end) {
		while(start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)) {
			cnt++;
			start--;
			end++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
