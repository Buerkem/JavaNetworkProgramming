package InternetAddresses;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static java.net.InetAddress.*;

public class PrintWebsiteAddress {

    public static void lookUp(String website){
        try{
            InetAddress address = getByName(website);
            System.out.println(address);
        } catch (UnknownHostException ex){
            System.out.println("Could not find "+ website);
        }

    }

    public static void reverseLookUp(String ipaddress) {
        InetAddress address = null;
        try {
            address = InetAddress.getByName(ipaddress);
            System.out.println(address.getHostName());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printLocalMachineAddress(){
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        System.out.println(address);
    }
    public static void main(String[] args){
        String googleIpAddress = "142.251.33.164";
        lookUp("www.google.com");
        reverseLookUp(googleIpAddress);
        printLocalMachineAddress();
    }
}
