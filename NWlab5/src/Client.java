import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try{
            Socket client = new Socket("localhost", 1234);
            String input;
            String output = "Hello Server";
                    DataInputStream dis = new DataInputStream(client.getInputStream());
                    input = dis.readUTF();
                    System.out.println("Data From Server: " + input);

                    DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                    dos.writeUTF(output);


        }catch(Exception e){
            System.out.println(e);
        }
    }
}
