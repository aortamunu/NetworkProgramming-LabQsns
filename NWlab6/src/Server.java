import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(8000);
            Socket client;
            System.out.println("Waiting for client");
            client = server.accept();
            while(true){

                Scanner sc = new Scanner(System.in);
                String serverMsg = sc.nextLine();
                DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                dos.writeUTF(serverMsg);

                DataInputStream dis = new DataInputStream(client.getInputStream());
                String receivedMsg = dis.readUTF();
                System.out.println("Received message: " + receivedMsg);

            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
