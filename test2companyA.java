package Q1;

/*
 * This program for Company A:
 * Reading information from Network Interface Card (NIC)
 * Information : IP and MAC Address
*/

/*
 * author : Azhari Hj Salleh
 * matrix no : 201461166
 * email : azhari.salleh@gmail.com
 * github acct : https://github.com/azharisalleh
 * 
 */

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;


public class test2companyA{
	
   public static void main(String[] args){
		
	InetAddress ip;
	try {
		
		System.out.println("Reading Local IP and MAC Address For Company A");
		System.out.print("\n");
		
		ip = InetAddress.getLocalHost();
		System.out.println("Current IP address : " + ip.getHostAddress());
		
		NetworkInterface network = NetworkInterface.getByInetAddress(ip);
			
		byte[] mac = network.getHardwareAddress();
			
		System.out.print("Current MAC address : ");
		
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
		}
		System.out.println(sb.toString());
		
		System.out.print("\n");
		System.out.print("Reading Complete");
		
	} catch (UnknownHostException e) {
		
		e.printStackTrace();
		
	} catch (SocketException e){
			
		e.printStackTrace();
			
	}
	    
   }

}