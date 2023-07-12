package InternetAddresses;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static java.net.InetAddress.getByName;

public class GetterMethods {
    public static void main(String[] args){
        InetAddress ia = null;
        try {
            ia = getByName("208.201.239.100");
            System.out.println(ia.getCanonicalHostName());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

        try {
            InetAddress me = InetAddress.getLocalHost();
            String dottedQuad = me.getHostAddress();
            System.out.println("My address is " + dottedQuad);
        } catch (UnknownHostException ex) {
            System.out.println("I'm sorry. I don't know my own address.");
        }
    }
}
