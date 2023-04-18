import java.io.*;
import java.net.*;

public class URIDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com");
            URLConnection connection = url.openConnection();

            // Print all header fields
            System.out.println("Header Fields for "+ url.toString() +":");
            for (String header : connection.getHeaderFields().keySet()) {
                System.out.println(header + ": " + connection.getHeaderFields().get(header));
            }

            // Print specific header fields
            System.out.println("\nDate: " + connection.getDate());
            System.out.println("Content-Type: " + connection.getContentType());
            System.out.println("Last-Modified: " + connection.getLastModified());
            System.out.println("Expiration: " + connection.getExpiration());
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        }
    }
}
