package InternetAddresses;
import java.net.*;

import static java.net.InetAddress.getByName;

public class AddressTests {
    public static int getVersion(InetAddress ia){
        byte[] address = ia.getAddress();
        if (address.length == 4) return 4;
        else if (address.length == 16) return 6;
        else return -1;
    }
    public static void main(String[] args){
        String website = "www.google.com";
        try {
            InetAddress address = getByName(website);
            System.out.println(getVersion(address));
        } catch (UnknownHostException e) {
        }
    }
}