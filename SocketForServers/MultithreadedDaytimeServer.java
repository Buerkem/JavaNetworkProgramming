package SocketForServers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultithreadedDaytimeServer {
    public final static int PORT = 3000;

    public static void main(String[] args){
        try(ServerSocket server = new ServerSocket(PORT)){
            while (true){
                try{
                    Socket connection = server.accept();
                    Thread task = new DaytimeThread(connection);
                    task.start();
                } catch (IOException ex){
            }
        }
    } catch (IOException ex){
            System.err.println("Couldn't start server");
        }
    }
}