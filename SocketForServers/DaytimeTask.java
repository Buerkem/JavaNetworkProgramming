package SocketForServers;

import SocketForClients.Daytime;

import java.util.Date;
import java.util.concurrent.Callable;
import java.io.*;
import java.net.*;
public class DaytimeTask implements Callable<Void> {
    private Socket connection;

    DaytimeTask(Socket connection){
        this.connection = connection;
    }

    @Override
    public Void call(){
        try{
            Writer out = new OutputStreamWriter(connection.getOutputStream());
            Date now = new Date();
            out.write(now.toString() + "\r\n");
            out.flush();
        } catch (IOException ex){
            System.err.println(ex);
        } finally {
            try{
                connection.close();
            } catch (IOException e){

            }
            return null;
        }
    }
}
