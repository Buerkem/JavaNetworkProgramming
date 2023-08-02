package SocketForServers;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.logging.Logger;

public class DaytimeTaskLogging implements Callable<Void> {
    private Socket connection;
    private Logger auditLogger;
    DaytimeTaskLogging(Socket connection, Logger auditLogger ) {
        this.connection = connection;
        this.auditLogger = auditLogger;
    }

    @Override
    public Void call(){
        try{
            Date now = new Date();
// write the log entry first in case the client disconnects
            auditLogger.info(now + " " + connection.getRemoteSocketAddress());
            Writer out = new OutputStreamWriter(connection.getOutputStream());
            out.write(now.toString() +"\r\n");
            out.flush();
        }catch (IOException ex) {
// client disconnected; ignore;
        }
        return null;
    }
}