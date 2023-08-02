package SocketForServers;
import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.concurrent.*;
import java.util.logging.*;

public class LoggingDaytimeServer {
    public final static int PORT = 3000;
    private final static Logger auditLogger = Logger.getLogger("requests");
    private final static Logger errorLogger = Logger.getLogger("errors");

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(50);
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try {
                    Socket connection = server.accept();
                    Callable<Void> task = new DaytimeTaskLogging(connection, auditLogger);
                    pool.submit(task);
                } catch (IOException ex) {
                    errorLogger.log(Level.SEVERE, "accept error", ex);
                } catch (RuntimeException ex) {
                    errorLogger.log(Level.SEVERE, "unexpected error " + ex.getMessage(), ex);
            }
        }
    } catch (IOException ex) {
            errorLogger.log(Level.SEVERE, "Couldn't start server", ex);
        } catch (RuntimeException ex) {
            errorLogger.log(Level.SEVERE, "Couldn't start server: " + ex.getMessage(), ex);
        }
    }
}
