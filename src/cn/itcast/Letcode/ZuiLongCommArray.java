package cn.itcast.Letcode;

public class ZuiLongCommArray {
	
	public static int comm(int[] num1,int[] num2) {
		if(num1==null||num1.length==0||num1==null||num2.length==0) return 0;
		int[][] opt=new int[num1.length+1][num2.length+1];
		for(int i=0;i<opt.length;i++) opt[i][0]=0;
		for(int j=0;j<opt[0].length;j++) opt[0][j]=0;
		for(int i=1;i<opt.length;i++) {
			for(int j=1;j<opt[i].length;j++) {
				if(num1[i-1]==num2[j-1]) opt[i][j]=opt[i-1][j-1]+1;
				else opt[i][j]=Math.max(opt[i-1][j],opt[i][j-1]);
			}
		}
		return opt[num1.length][num2.length];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num1= {0,1,2,3};
        int[] num2= {1,4,3};
        System.out.println(comm(num1,num2));
	}

}
