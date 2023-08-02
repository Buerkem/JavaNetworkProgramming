package SocketForServers;

import java.io.*;
import java.net.*;
import java.util.logging.*;

public class Redirector {
    private static final Logger logger = Logger.getLogger("Redirector");
    private final int port;
    private final String newSite;

    public Redirector(String newSite, int port){
        this.port = port;
        this.newSite = newSite;
    }

    public void start(){
        try(ServerSocket server = new ServerSocket(port)){
            logger.info("Redirecting connections on port " + server.getLocalPort() + " to " + newSite);
            while (true){
                try{
                    Socket s = server.accept();
                    Thread t = new RedirectThread(s, newSite, logger);
                    t.start();
                } catch (IOException ex) {
                    logger.warning("Exception accepting connection");
                } catch (RuntimeException ex) {
                    logger.log(Level.SEVERE, "Unexpected error", ex);
                }
            }
        } catch (BindException ex) {
            logger.log(Level.SEVERE, "Could not start server.", ex);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Error opening server socket", ex);
        }
    }

    public static void main(String[] args){
        int thePort;
        String theSite;

        try {
            theSite = args[0];
// trim trailing slash
            if (theSite.endsWith("/")) {
                theSite = theSite.substring(0, theSite.length() - 1);
            }
        } catch (RuntimeException ex) {
            System.out.println(
                    "Usage: java Redirector http://www.newsite.com/ port");
            return;
        }
        try {
            thePort = Integer.parseInt(args[1]);
        } catch (RuntimeException ex) {
            thePort = 3000;
        }
        Redirector redirector = new Redirector(theSite, thePort);
        redirector.start();
    }
}