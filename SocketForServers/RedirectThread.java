package SocketForServers;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.*;
public class RedirectThread extends  Thread{
    private final Socket connection;
    private final String newSite;
    private final Logger logger;
    RedirectThread(Socket s, String newSite, Logger logger) {
        this.connection = s;
        this.newSite = newSite;
        this.logger = logger;
    }

    public void run() {
        try{
            Writer out = new BufferedWriter(new OutputStreamWriter(
                            connection.getOutputStream(), "US-ASCII"));
            Reader in = new InputStreamReader(new BufferedInputStream(
                            connection.getInputStream() ));
            StringBuilder request = new StringBuilder(80);
            while (true) {
                int c = in.read();
                if (c == '\r' || c == '\n' || c == -1) break;
                request.append((char) c);
            }
            String get = request.toString();
            String[] pieces = get.split("\\w*");
            String theFile = pieces[1];

            // If this is HTTP/1.0 or later send a MIME header
            if (get.indexOf("HTTP") != -1) {
                out.write("HTTP/1.0 302 FOUND\r\n");
                Date now = new Date();
                out.write("Date: " + now + "\r\n");
                out.write("Server: Redirector 1.1\r\n");
                out.write("Location: " + newSite + theFile + "\r\n");
                out.write("Content-type: text/html\r\n\r\n");
                out.flush();
            }
            // Not all browsers support redirection so we need to
            // produce HTML that says where the document has moved to.
            out.write("<HTML><HEAD><TITLE>Document moved</TITLE></HEAD>\r\n");
            out.write("<BODY><H1>Document moved</H1>\r\n");
            out.write("The document " + theFile
                    + " has moved to\r\n<A HREF=\"" + newSite + theFile + "\">"
                    + newSite + theFile
                    + "</A>.\r\n Please update your bookmarks<P>");
            out.write("</BODY></HTML>\r\n");
            out.flush();
            logger.log(Level.INFO,
                    "Redirected " + connection.getRemoteSocketAddress());
        } catch (IOException ex){
        }
    }
}
