import java.io.*;
import java.net.URL;

public class WebpageReader {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.google.com");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            BufferedWriter writer = new BufferedWriter(new FileWriter("example.html"));
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            reader.close();
            writer.close();
            System.out.println("Webpage saved to file.");
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }
}
