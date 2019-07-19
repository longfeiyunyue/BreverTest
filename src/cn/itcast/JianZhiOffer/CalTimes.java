package cn.itcast.JianZhiOffer;

public class CalTimes {//ÃæÊÔÌâ53
	
	public static int getFirstK(int[] arr,int key,int start,int end) {
		if(start>end) return -1;
		int midInd=start+(end-start)/2;
		int mid=arr[midInd];
		if(key==mid) {
			if((midInd>0&&arr[midInd-1]!=key)||midInd==0) return midInd;
			else end=midInd-1;
		}
		else if(key>mid) start=midInd+1;
		else end=midInd-1;
		return getFirstK(arr,key,start,end);
	}
	
	public static int getLastK(int[] arr,int key,int start,int end) {
		if(start>end) return -1;
		int midInd=start+(end-start)/2;
		int mid=arr[midInd];
		if(key==mid) {
			if((midInd<arr.length-1&&arr[midInd+1]!=key)||midInd==arr.length-1) return midInd;
			else start=midInd+1;
		}
		else if(key>mid) start=midInd+1;
		else end=midInd-1;
		return getLastK(arr,key,start,end);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,2,3,3,3,3,4,5};
		int fk=getFirstK(a,3,0,a.length-1);
		int lk=getLastK(a,3,0,a.length-1);
		System.out.println(fk+"--"+lk);
		System.out.println(lk-fk+1);
	}

}
