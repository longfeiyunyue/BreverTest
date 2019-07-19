package cn.itcast.Letcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthElementInMatrix {
	
	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
			
		});
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if(pq.size()<k) pq.add(matrix[i][j]);
				else {
					if(matrix[i][j]<pq.peek()) {
						pq.poll();
						pq.add(matrix[i][j]);
					}
					
				}
			}
		}
		return pq.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
