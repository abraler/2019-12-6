package echo;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) throws IOException {
        //1:建立一个DatagramSocket;
        DatagramSocket udpServerSocket=new DatagramSocket(9898);
        byte[]receiveBuffer=new byte[1024];
        DatagramPacket receivpacket=new DatagramPacket(receiveBuffer,receiveBuffer.length);
        //2:等待客户端连接
        udpServerSocket.receive(receivpacket);
        InetAddress clientAddress=receivpacket.getAddress();
        System.out.println(clientAddress.getHostAddress()+receivpacket.getPort());
        String message=new String(receivpacket.getData(),0,receivpacket.getLength());
        System.out.println(message);

    }
}
