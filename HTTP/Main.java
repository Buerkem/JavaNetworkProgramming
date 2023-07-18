package HTTP;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CookieManager manager = new CookieManager();
        manager.setCookiePolicy(new NoGovernmentCookies());

        // Create and add cookies for the first URI
        HttpCookie c1 = new HttpCookie("user1", "1");
        URI uri1 = URI.create("http://spm.gov");
        try {
            manager.put(uri1, Collections.singletonMap("Set-Cookie", Collections.singletonList(c1.toString())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Create and add cookies for the second URI
        HttpCookie c2 = new HttpCookie("user2", "2");
        URI uri2 = URI.create("http://example.com");
        try {
            manager.put(uri2, Collections.singletonMap("Set-Cookie", Collections.singletonList(c2.toString())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Create and add cookies for the third URI
        HttpCookie c3 = new HttpCookie("user3", "3");
        URI uri3 = URI.create("http://govsite.gov");
        try {
            manager.put(uri3, Collections.singletonMap("Set-Cookie", Collections.singletonList(c3.toString())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Print out stored cookies
        List<HttpCookie> storedCookies = manager.getCookieStore().getCookies();
        for (HttpCookie cookie : storedCookies) {
            System.out.println("Name: " + cookie.getName() + ", Value: " + cookie.getValue());
        }
    }
}