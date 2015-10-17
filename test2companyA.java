package Q1;

/*
 * This program for Company A:
 * Enhancement  features to get information about IPV6 
 * Information : IPV6 and MAC Address
*/

/*
 * author : Azhari Hj Salleh
 * matrix no : 201461166
 * email : azhari.salleh@gmail.com
 * github acct : https://github.com/azharisalleh
 * 
 */

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.*;
import java.net.*;
import java.util.*;
import static java.lang.System.out;


public class test2companyA{
	
    public static void main(String args[]) throws SocketException {
        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        for (NetworkInterface netint : Collections.list(nets))
            displayInterfaceInformation(netint);
    }

    static void displayInterfaceInformation(NetworkInterface netint) throws SocketException {
       
        out.printf("\n");
        System.out.println("Initial Program to Access of IPv6 of Subinterface");
    	out.printf("Display name: %s\n", netint.getDisplayName());
        out.printf("Name: %s\n", netint.getName());
        Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
        
        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
            out.printf("InetAddress: %s\n", inetAddress);
        }
       

        out.printf("Hardware address: %s\n",
                    Arrays.toString(netint.getHardwareAddress()));
        
        out.printf("\n");
        System.out.println("End Info for Subinterface");
     
	    
   }

}