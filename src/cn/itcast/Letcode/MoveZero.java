package cn.itcast.Letcode;

public class MoveZero {//把数组中的 0 移到末尾
	
	public static void move(int[] arr) {
		int i=-1;
		int j=arr.length;
		while(true) {
			while(arr[++i]!=0) if(i>=arr.length-1) break;
			while(arr[--j]==0) if(j<=0) break;
			if(i>=j) break;
			exch(arr,i,j);
		}
	}
	
	private static void exch(int[] arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr= {0, 1, 0, 3, 12};
        move(arr);
        for(int i=0;i<arr.length;i++) System.out.print(arr[i]+",");
	}

}
