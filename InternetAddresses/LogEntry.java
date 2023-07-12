package InternetAddresses;

import java.util.concurrent.Future;

public class LogEntry {
    String original;
    Future <String> future;

    LogEntry(String original, Future<String> future){
        this.original = original;
        this.future = future;
    }
}
