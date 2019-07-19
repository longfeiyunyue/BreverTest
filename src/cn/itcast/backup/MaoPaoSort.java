package cn.itcast.backup;

import java.util.Arrays;

public class MaoPaoSort {
	
	public static void sort(int[] arr) {
		for(int i=arr.length-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(arr[j]>arr[j+1]) exch(arr,j,j+1);
			}
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
