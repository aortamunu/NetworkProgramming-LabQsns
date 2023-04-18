
import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.net.URL;

public class URLReader {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
