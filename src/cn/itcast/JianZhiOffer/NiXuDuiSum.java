package cn.itcast.JianZhiOffer;

public class NiXuDuiSum {//√Ê ‘Ã‚51
	private static int aux[];
	
	private static int merge(int[] a,int lo,int mid,int hi) {
		int i=mid;
		int j=hi;
		int count=0;
		for(int k=lo;k<=hi;k++) aux[k]=a[k];
		for(int k=hi;k>=lo;k--) {
			if(i<lo) a[k]=aux[j--];
			else if(j<=mid) a[k]=aux[i--];
			else if(aux[i]>aux[j]) {
				a[k]=aux[i--];
				count+=(j-mid);
			}
			else a[k]=aux[j--];
		}
		return count;
	}
	
	private static int sort(int[] a,int lo,int hi) {
		if(hi<=lo) return 0;
		int mid=lo+(hi-lo)/2;
		int left=sort(a,lo,mid);
		int right=sort(a,mid+1,hi);
		int he=left+right+merge(a,lo,mid,hi);
		return he;
	}
	
	public static int sort(int[] a) {
		aux=new int[a.length];
		return sort(a,0,a.length-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x= {7,5,6,4};
        System.out.println(sort(x));
        for(int i=0;i<x.length;i++)
        	System.out.print(x[i]+",");
	}

}
