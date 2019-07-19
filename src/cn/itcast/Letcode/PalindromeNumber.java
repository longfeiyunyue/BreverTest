package cn.itcast.Letcode;

public class PalindromeNumber {
	
	public boolean isPalindrome(int x) {
		if(x==0) return true;
		if(x<0||x%10==0) return false;
		int right=0;
		while(x>right) {
			right=right*10+x%10;
			x=x/10;
		}
		return (x==right)||(x==right/10);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
