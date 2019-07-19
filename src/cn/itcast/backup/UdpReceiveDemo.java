package cn.itcast.backup;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpReceiveDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        DatagramSocket ds=null;
        try {
			ds=new DatagramSocket(8888);
			byte[] bs=new byte[1024];
			DatagramPacket dp=new DatagramPacket(bs,bs.length);
			ds.receive(dp);
			byte[] res=dp.getData();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
