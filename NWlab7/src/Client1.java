import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (Socket client = new Socket("localhost", 1234)) {
            String input;
            System.out.println("Connected to Server");

            while (true) {
                // Print msg from Server
                DataInputStream dis = new DataInputStream(client.getInputStream());
                input = dis.readUTF();
                System.out.println("Message from Server: " + input);

                // Send msg to Server
                System.out.println("Write your message:");
                String output = sc.nextLine();
                DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                dos.writeUTF(output);
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Connection Closed");
        }
        sc.close();
    }
}