package cn.itcast.JianZhiOffer;

import java.util.Stack;

public class StacktoQue {//√Ê ‘Ã‚9
	private Stack<String> st1;
	private Stack<String> st2;
	
	public StacktoQue() {
		st1=new Stack<String>();
		st2=new Stack<String>();
	}
	
	public void appendTail(String s) {
		st1.push(s);
	}
	
	public String deleteHead() {
		String s=null;
		if(!st2.isEmpty()) s=st2.pop();
		else {
			while(!st1.isEmpty()) {
				String temp=st1.pop();
				st2.push(temp);
			}
			try {
				s=st2.pop();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return s;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StacktoQue q=new StacktoQue();
		q.appendTail("a");
		q.appendTail("b");
		q.appendTail("c");
		for(int i=0;i<3;i++)
			System.out.print(q.deleteHead()+",");
		q.deleteHead();
	}

}
