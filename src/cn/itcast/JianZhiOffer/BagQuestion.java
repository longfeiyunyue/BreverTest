package cn.itcast.JianZhiOffer;

public class BagQuestion {
	
	public static int maxValue(int[] wb,int[] vb,int cap) {
		int[] w=new int[wb.length+1];
		int[] v=new int[vb.length+1];
		w[0]=0;
		v[0]=0;
		for(int i=1;i<w.length;i++) w[i]=wb[i-1];
		for(int i=1;i<v.length;i++) v[i]=vb[i-1];
		int row=w.length;
		int col=cap+1;
		int[][] price=new int[row][col];
		for(int i=0;i<row;i++) price[i][0]=0;
		for(int j=0;j<col;j++) price[0][j]=0;
		for(int k=1;k<row;k++) {
			for(int c=1;c<col;c++) {
				if(w[k]>c) price[k][c]=price[k-1][c];
				else {
					int val1=price[k-1][c-w[k]]+v[k];
					int val2=price[k-1][c];
					price[k][c]=Math.max(val1, val2);
				}
			}
		}
		return price[row-1][cap];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] w= {5, 4, 6, 3};
        int[] v= {10, 40, 30, 50};
        int p=maxValue(w,v,10);
        System.out.println(p);
	}

}
