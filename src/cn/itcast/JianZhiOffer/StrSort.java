package cn.itcast.JianZhiOffer;

public class StrSort {//√Ê ‘Ã‚38
	
	public static void permutation(char[] ch) {
		permutation(ch,0);
	}
	
	private static void permutation(char[] ch,int cur) {
		if(cur==ch.length-1) System.out.println(new String(ch));
		else {
			for(int i=cur;i<ch.length;i++) {
				exch(ch,cur,i);
				permutation(ch,cur+1);
				exch(ch,cur,i);
			}
		}
	}
	
	
	private static void exch(char[] ch,int lo,int hi) {
		char temp=ch[lo];
		ch[lo]=ch[hi];
		ch[hi]=temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String s="abc";
		 char[] c=s.toCharArray();
		 permutation(c);
	}

}
