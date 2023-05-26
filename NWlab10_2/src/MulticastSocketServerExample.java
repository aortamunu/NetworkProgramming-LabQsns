import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSocketServerExample {

    public static void main(String[] args) {
        String multicastGroup = "224.0.0.1";
        int port = 8000, broadcastCount = 0;

        try {
            // Create a multicast socket and join the multicast group
            InetAddress group = InetAddress.getByName(multicastGroup);
            MulticastSocket multicastSocket = new MulticastSocket(port);
            multicastSocket.joinGroup(group);

            // Broadcasting on multicast group
            try {
                while (true) {
                    broadcastCount++;
                    String message = "Hello from Server multicasting on " + multicastGroup
                            + "\n Broadcast Count: " + broadcastCount;
                    byte[] buffer = message.getBytes();

                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);
                    multicastSocket.send(packet);

                    System.out.println("Message multicast count: " + broadcastCount);

                    Thread.sleep(1000); // Wait for 2 seconds before sending the next message
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