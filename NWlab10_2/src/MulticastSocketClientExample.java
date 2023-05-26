import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSocketClientExample {

    public static void main(String[] args) {
        String multicastGroup = "224.0.0.1";
        int port = 8000;

        try {
            // Create a multicast socket and join the multicast group
            InetAddress group = InetAddress.getByName(multicastGroup);
            MulticastSocket multicastSocket = new MulticastSocket(port);
            multicastSocket.joinGroup(group);

            // Joining multicast group
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            try {
                while (true) {
                    multicastSocket.receive(packet);
                    String message = new String(packet.getData(), 0, packet.getLength());
                    System.out.println("Message from server: " + message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Leave the multicast group and close the socket
            multicastSocket.leaveGroup(group);
            multicastSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}