import java.net.*;
import java.util.*;
public class HTTPExample {
    public static void main(String[] args) {
        try
        {
            CookieManager manager = new CookieManager();
            CookieStore cookieStore = manager.getCookieStore();
            HttpCookie cookieA = new HttpCookie("CP", "Seemana");
            HttpCookie cookieB = new HttpCookie("C2", "Karmacharya");

            URI uri1 = new URI("www.google.com");
            URI uri2 = new URI("www.youtube.com");
            cookieStore.add(uri1, cookieA);
            cookieStore.add(uri2, cookieB);

            List list = cookieStore.getCookies();
            System.out.println("Store cookies: " + list);

            cookieStore.remove(uri1, cookieA);
            System.out.println("Store cookies: " + list);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}


