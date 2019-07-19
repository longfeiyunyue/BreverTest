package cn.itcast.Algorithms;

import java.util.Arrays;

public class Insertion {
	
	public static void sort(int[] a) {
		for(int i=1;i<a.length;i++) {
			for(int j=i;j>0&&a[j]<a[j-1];j--) {
				exch(a,j,j-1);
			}
		}
	}
	
	public static void sortX(int[] a) {
		for(int i=1;i<a.length;i++) {
			int temp=a[i];
			int j=i;
			for(;j>0&&temp<a[j-1];j--) {
				a[j]=a[j-1];
			}
			a[j]=temp;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {2,1,5,3,88,4,5,780,9};
        sortX(a);
        System.out.println(Arrays.toString(a));
	}
	public static void exch(int[] a,int i,int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
}
