import java.net.*;
import java.io.*;
import java.util.*;

public class Client {

    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket();
            InetAddress address = InetAddress.getByName("localhost");
            int port = 1234;
            byte[]buffer = {12,34};
            byte[] buffer1 = new byte[2];
            DatagramPacket dp = new DatagramPacket(buffer, 2, address, port);
            DatagramPacket receive = new DatagramPacket(buffer1, 2);
            ds.connect(address, port);
            System.out.println("Bound" + ds.isBound());
            System.out.println("connected" + ds.isConnected());
            System.out.println("InetAddress" + ds.getInetAddress());
            System.out.println("port" + ds.getPort());
            System.out.println("Remote Socket" + ds.getRemoteSocketAddress());
            System.out.println("Local Socket" + ds.getLocalSocketAddress());
            ds.send(dp);
            System.out.println("data packet sent");
            ds.receive(receive);
            System.out.println("data is received" +Arrays.toString(receive.getData()));
            System.out.println("Local Port"+ ds.getLocalPort());
            ds.setSoTimeout(1000);

        }
        catch(Exception e){
            System.out.print(e);

        }

    }
}