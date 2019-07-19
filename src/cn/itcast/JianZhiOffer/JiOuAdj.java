package cn.itcast.JianZhiOffer;

public class JiOuAdj {//ÃæÊÔÌâ21
	
	public static void adj(int[] arr) {
		int i=-1;
		int j=arr.length;
		while(true) {
			while((arr[++i]&1)==1) if(i>=arr.length) break;;
			while((arr[--j]&1)==0) if(j<0) break;;
			if(i>=j) break;
			exch(arr,i,j);
		}
	}
	
	public static void exch(int[] arr,int i,int j) {
		int temo=arr[i];
		arr[i]=arr[j];
		arr[j]=temo;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arr= {1,2,3,4,5};
	        adj(arr);
	        for(int i=0;i<arr.length;i++)
	        System.out.print(arr[i]+",");
	}

}
