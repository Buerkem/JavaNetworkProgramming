package SocketForServers;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class PooledDaytimeServer {
    public final static int PORT = 3000;

    public static void main(String[] args){
        ExecutorService pool = Executors.newFixedThreadPool(50);

        try(ServerSocket server = new ServerSocket(PORT)){
            while (true){
                try{
                    Socket connection = server.accept();
                    Callable<Void> task = new DaytimeTask(connection);
                    pool.submit(task);
                } catch (IOException ex){}

            }
            }catch (IOException ex){
            System.err.println("Couldn't start server");
        }
    }
}