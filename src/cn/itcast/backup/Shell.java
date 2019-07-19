package cn.itcast.backup;

public class Shell {
	
	public static void sort(int[] a) {
		int N=a.length;
		int h=1;
		while(h<h/3) h=3*h+1;
		while(h>=1) {
			for(int i=h;i<N;i++) {
				for(int j=i;j>=h&&a[j]<a[j-h];j-=h) exch(a,j,j-h);
			}
			h=h/3;
		}
	}
	public static void exch(int[] a,int i,int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
