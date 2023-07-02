package Streams;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;

/*
The provided Java code demonstrates how to read data from an input stream into a byte array.
It initializes an input stream and a byte array with a fixed length.
The code then enters a loop where it reads bytes from the input stream and stores them in the byte array until either the byte array is full or the end of the stream is reached.
The input stream is properly closed after the loop finishes.
The code also includes exception handling to catch and handle any potential input/output errors.
The code provides a basic template for reading data from an input stream into a byte array in Java.
*/

public class SampleInputStreamExample {
    public static void main(String[] args) {
        byte[] data = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74 }; // Sample data

        InputStream in = null;

        try {
            in = new ByteArrayInputStream(data);

            byte[] input = new byte[10];
            for (int i = 0; i < input.length; i++) {
                int b = in.read();
                if (b == -1)
                    break;
                input[i] = (byte) b;
            }

            // Print the read data
            for (byte b : input) {
                System.out.println(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}