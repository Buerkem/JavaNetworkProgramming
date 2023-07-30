package URLConnection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class CacheControlInspector {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.oreilly.com/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Inspect the Cache-Control header
            String cacheControl = connection.getHeaderField("Cache-Control");
            System.out.println("Cache-Control header: " + cacheControl);

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}