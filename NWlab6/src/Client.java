import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try{
            Socket client = new Socket("127.0.0.1", 8000);
//            String input;
            while(true) {

                DataInputStream dis = new DataInputStream(client.getInputStream());
                String receivedMsg = dis.readUTF();
                System.out.println("Received message: " + receivedMsg);

                Scanner sc = new Scanner(System.in);
                String userMsg = sc.nextLine();
                DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                dos.writeUTF(userMsg);

            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

