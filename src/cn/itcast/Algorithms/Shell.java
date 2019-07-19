package cn.itcast.Algorithms;

import java.util.Arrays;

public class Shell {
	
	public static void sort(int[] a) {
		int N=a.length;
		int h=1;
		while(h<N/3) h=h*3+1;
		while(h>=1) {
			for(int i=h;i<N;i++) {
				for(int j=i;j>=h&&a[j]<a[j-h];j-=h) {
					exch(a,j,j-h);
				}
			}
			h=h/3;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {2,1,5,3,88,4,5,780,9};
        sort(a);
        System.out.println(Arrays.toString(a));
	}
	public static void exch(int[] a,int i,int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
}
