package cn.itcast.JianZhiOffer;

public class FindArrayMin {//ÃæÊÔÌâ11
	
	public static int findMin(int[] arr) {
		int left=0;
		int right=arr.length-1;
		int mid=left;
		while(arr[left]>arr[right]) {
			if(right-left==1) {
				mid=right;
				break;
			}
			mid=left+(right-left)/2;
			if(arr[mid]>=arr[left]) left=mid;
			else if(arr[mid]<=arr[right]) right=mid;
		}
		return arr[mid];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {3,4,5,1,2};
        System.out.println(findMin(arr));
	}

}
