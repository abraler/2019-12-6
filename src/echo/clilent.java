/*\
UDP 是不可靠的
TCP 可靠的
    1：通过多线程处理
    2：短连接方式不常用
 */



package echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class clilent {
    public static void main(String[] args) throws IOException {
        DatagramSocket udpClilent=new DatagramSocket();
        String messge="黄文哲";
        byte[]sendBuffer=messge.getBytes("UTF-8");
        byte[]serverIP=new byte[4];
        serverIP[0]=(byte)192;
        serverIP[1]=(byte)168;
        serverIP[2]=1;
        serverIP[3]=(byte)107;

            InetAddress serverAddress=InetAddress.getByAddress(serverIP);
            DatagramPacket sendpacket=new DatagramPacket(
                    sendBuffer,sendBuffer.length,serverAddress,9898
            );
            udpClilent.send(sendpacket);
            udpClilent.close();
    }
}
