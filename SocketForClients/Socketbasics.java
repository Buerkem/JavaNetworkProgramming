package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Socketbasics {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("time.nist.gov", 13);
            socket.setSoTimeout(15000);

            // Get the input stream from the socket
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Read the response from the server
            String response;
            while ((response = reader.readLine()) != null) {
                System.out.println(response);
            }

            // Close the socket after reading
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
