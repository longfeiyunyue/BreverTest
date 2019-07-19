package cn.itcast.JianZhiOffer;

public class ChongFuShuZi {//√Ê ‘Ã‚3
	
	public static int duplicate(int[] arr) {
		int dup=-1;
		for(int i=0;i<arr.length;i++) {
			while(arr[i]!=i) {
				if(arr[i]==arr[arr[i]]) {
					dup=arr[i];
					return dup;
				}
				exch(arr,i,arr[i]);
			}
		}
		return -1;
	}
	private static void exch(int[] arr,int lo,int hi) {
		int temp=arr[lo];
		arr[lo]=arr[hi];
		arr[hi]=temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {3,2,1,0,2,5,3};
        System.out.println(duplicate(a));
	}

}
