package cn.itcast.Letcode;

import java.util.Arrays;

import org.junit.Test;





public class CutChongdieQujian {//���ص����䣺����һ������ļ��ϣ��ҵ���Ҫ�Ƴ��������С������ʹʣ�����以���ص�
	
	public int eraseOverlapIntervals(Interval[] intervals) {
		if(intervals.length<=1) return 0;
		int count=1;
		int len=intervals.length;
		Arrays.sort(intervals);
		int end=intervals[0].end;
		for(int i=1;i<intervals.length;i++) {
			int start=intervals[i].start;
			if(start<end) continue;
			count++;
			end=intervals[i].end;
		}
		return len-count;
	}

	@Test
	public void test() {
		Interval[] in=new Interval[4];
		in[0]=new Interval(2,3);
		in[1]=new Interval(1,2);
		in[2]=new Interval(3,4);
		in[3]=new Interval(1,3);
		System.out.println(eraseOverlapIntervals(in));
	}
	public class Interval implements Comparable<Interval>{
		int start;
		int end;
		int cha;
		public Interval(int s,int e) {
			start=s;
			end=e;
			cha=e-s;
		}
		@Override
		public String toString() {
			return "start:"+start+", end:"+end;
		}
		
		public int compareTo(Interval o) {
			return this.end-o.end;
		}
		
	}
}
