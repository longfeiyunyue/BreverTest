package cn.itcast.JianZhiOffer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class QianKCot {//√Ê ‘Ã‚40
	
	public static Iterable<Integer> findK(int[] arr,int k){
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
			
		});
		
		for(int i=0;i<arr.length;i++) {
			if(i<k) {
				pq.add(arr[i]);
				continue;
			}
			if(arr[i]<pq.peek()) {
				pq.poll();
				pq.add(arr[i]);
			}
		}
		return pq;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,2,3,2,0,7,5,4,2};
		System.out.println(findK(a,5));
	}

}
