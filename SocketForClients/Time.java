package SocketForClients;

import java.io.*;
import java.net.*;
import java.text.*;
import java.util.Date;

public class Time{

    public static Date getDateFromNetwork() throws IOException {
        // Create a socket to connect to the time server
        try (Socket socket = new Socket("time.nist.gov", 13)) {
            // Get the input stream from the socket
            InputStream raw = socket.getInputStream();

            // Read 4 bytes from the server response to get seconds since 1900
            int secondsSince1900 = 0;
            for (int i = 0; i < 4; i++) {
                secondsSince1900 = (secondsSince1900 << 8) | raw.read();
            }

            // Calculate seconds since 1970 (Unix epoch)
            long differenceBetweenEpochs = 2208988800L;
            long secondsSince1970 = secondsSince1900 - differenceBetweenEpochs;
            long msSince1970 = secondsSince1970 * 1000;

            // Create a Date object representing the time
            Date time = new Date(msSince1970);
            return time;
        }
    }

    public static void main(String[] args) {
        try {
            Date date = getDateFromNetwork();
            System.out.println("Current date and time: " + date);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}