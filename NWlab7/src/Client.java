import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private String serverAddress;
    private int serverPort;
    private Socket socket;
    private InputStream input;
    private OutputStream output;

    public Client(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    public void start() {
        try {
            socket = new Socket(serverAddress, serverPort);
            System.out.println("Connected to server: " + serverAddress + ":" + serverPort);

            input = socket.getInputStream();
            output = socket.getOutputStream();

            // Start a separate thread to listen for server responses
            Thread responseThread = new Thread(this::handleServerResponses);
            responseThread.start();

            // Send user input to the server
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String message = scanner.nextLine();
                output.write(message.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleServerResponses() {
        try {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1) {
                String response = new String(buffer, 0, bytesRead);
                System.out.println("Response from server: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String serverAddress = "localhost"; // Change this to the server address
        int serverPort = 8080; // Change this to the server port number

        Client client = new Client(serverAddress, serverPort);
        client.start();
    }
}
