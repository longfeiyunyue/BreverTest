package cn.itcast.Algorithms;

import java.util.Arrays;

public class Selection {
	
	public static void sort(int[] a) {
		for(int i=0;i<a.length-1;i++) {
			int min=i;
			for(int j=i+1;j<a.length;j++) {
				if(a[j]<a[min]) min=j;
			}
			exch(a,i,min);
		}
		
	}
	
	public static void exch(int[] a,int i,int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {2,1,5,3,88,4,5,780,9};
        sort(a);
        System.out.println(Arrays.toString(a));
	}

}
