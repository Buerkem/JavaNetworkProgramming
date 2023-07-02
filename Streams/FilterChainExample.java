package Streams;

import java.io.*;
import java.util.zip.GZIPOutputStream;

public class FilterChainExample {
    public static void main(String[] args) {
        String input = "Hello, World!";

        try {
            // Create a FileOutputStream to write to a file
            FileOutputStream fileOutputStream = new FileOutputStream("output.txt");

            // Create a BufferedOutputStream to improve write performance
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            // Create a GZIPOutputStream to compress the data
            GZIPOutputStream gzipOutputStream = new GZIPOutputStream(bufferedOutputStream);

            // Create a PrintWriter to write text data
            PrintWriter printWriter = new PrintWriter(gzipOutputStream);

            // Write the input string
            printWriter.write(input);

            // Flush and close the filters in reverse order
            printWriter.close();
            gzipOutputStream.close();
            bufferedOutputStream.close();
            fileOutputStream.close();

            System.out.println("Data has been written and compressed to 'output.txt.gz'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}