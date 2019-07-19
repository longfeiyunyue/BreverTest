package cn.itcast.JianZhiOffer;

public class HuaDongWindowMax {
	
	public static int[] max(int[] arr,int size) {
		int[] res=new int[arr.length];
		for(int i=0;i<res.length;i++) res[i]=-1;
		for(int i=size-1;i<arr.length;i++)
			res[i]=Math.max(arr[i], Math.max(arr[i-1],arr[i-2]));
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={2,3,4,2,6,2,5,1};
        int[] res=max(arr,3);
        for(int i=2;i<res.length;i++) System.out.print(res[i]+",");
	}

}
