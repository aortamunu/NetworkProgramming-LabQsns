import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiClientServer {
    private ServerSocket serverSocket;
    private boolean running;

    public MultiClientServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        running = true;
        while (running) {
            try {
                System.out.println("Waiting for clients to connect...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

                // Handle the client in a separate thread
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        running = false;
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int port = 8080; // Change this to your desired port number
        MultiClientServer server = new MultiClientServer(port);
        server.start();
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // Handle client communication here
            // You can use clientSocket.getInputStream() to read client messages
            // and clientSocket.getOutputStream() to send responses back to the client
            // You can define your own protocol for communication

            // Example: Echo server
            // Read input from client and echo it back
            byte[] buffer = new byte[1024];
            int bytesRead;
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();

            while ((bytesRead = input.read(buffer)) != -1) {
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Received from client: " + message);
                output.write(buffer, 0, bytesRead);
            }

            clientSocket.close();
            System.out.println("Client disconnected: " + clientSocket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
