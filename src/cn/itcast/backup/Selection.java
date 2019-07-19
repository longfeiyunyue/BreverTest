package cn.itcast.backup;

import java.util.Arrays;

public class Selection {
	public static void sort(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			int min=i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[min]>arr[j]) min=j;
			}
			exch(arr,min,i);
		}
	}
	
	private static void exch(int[] arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {2,1,5,3,88,4,5,780,9};
        sort(a);
        System.out.println(Arrays.toString(a));
	}
}
