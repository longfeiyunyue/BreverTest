package cn.itcast.backup;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpSendDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        DatagramSocket ds=null;
        try {
			ds=new DatagramSocket();
			byte[] data="hello!".getBytes();
			InetAddress host=InetAddress.getByName("192.168.0.105");
			DatagramPacket dp=new DatagramPacket(data,data.length,host,8888);
			ds.send(dp);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
