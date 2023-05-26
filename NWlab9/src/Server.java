import java.net.*;
public class Server {
    public static void main(String []args){
        try{
            DatagramSocket ds = new DatagramSocket(1234);
            byte[] buffer;
            byte[] send = { 13,18};
            buffer= new byte[2];

            DatagramPacket dp= new DatagramPacket(buffer,2);
            ds.receive(dp);
            DatagramPacket senddp= new DatagramPacket(send,2,dp.getAddress(),dp.getPort());
            ds.send(senddp);
            System.out.println("Datagram received  ");

        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}