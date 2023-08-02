package SocketForServers;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class IterativeServer {
    public static void main(String[] args) {
        int port = 3000;
        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                try (Socket connection = server.accept()) {
                    Writer out = new OutputStreamWriter(connection.getOutputStream());
                    Date now = new Date();
                    out.write(now.toString() + "\r\n");
                    out.flush();
                } catch (IOException ex) {
                    System.err.println("Error while processing client request: " + ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.err.println("Error occurred while creating the server: " + ex.getMessage());
        }
    }
}