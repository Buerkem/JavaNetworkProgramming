package URLConnection;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class URLPrinter {
    public static void main(String[] args) {
        try {
            URL u = new URL("https://codingbat.com/java");
            URLConnection uc = u.openConnection();
            uc.setAllowUserInteraction(true);
            InputStream in = uc.getInputStream();
            //System.out.println(uc.getURL());
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
