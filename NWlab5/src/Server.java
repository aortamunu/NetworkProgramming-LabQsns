import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            ServerSocket server = new ServerSocket(1234);
            Socket client;
            System.out.println("Waiting for client");
            client = server.accept();
            while(true){
                String output = "hello";
//                System.out.println("Enter message: ");
//                String output = sc.nextLine();
                DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                dos.writeUTF(output);
                DataInputStream dis = new DataInputStream(client.getInputStream());
                String input = dis.readUTF();
                System.out.println(input);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
