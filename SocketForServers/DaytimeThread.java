package SocketForServers;

import java.net.*;
import java.io.*;
import java.util.Date;

public class DaytimeThread extends Thread{
    private Socket connection;

    DaytimeThread(Socket connection){
        this.connection = connection;
    }

    @Override
    public void run(){
        try{
            Writer out = new OutputStreamWriter(connection.getOutputStream());
            Date now = new Date();
            out.write(now.toString() +"\r\n");
            out.flush();
        } catch (IOException ex){
            System.err.println(ex);
        } finally{
            try{
                connection.close();
            } catch (IOException e){
            }
        }
    }
}