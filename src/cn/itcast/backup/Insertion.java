package cn.itcast.backup;

public class Insertion {
	
	public static void sort(int[] arr) {
		for(int i=1;i<arr.length;i++) {
			int j=i;
			for(;j>0&&arr[j]<arr[j-1];j--) {
				exch(arr,j,j-1);
			}
		}
	}
	
	public static void sortX(int[] arr) {
		for(int i=1;i<arr.length;i++) {
			int temp=arr[i];
			int j=i;
			for(;j>0&&temp<arr[j-1];j--) arr[j]=arr[j-1];
			arr[j]=temp;
		}
	}
	
	private static void exch(int[] arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
