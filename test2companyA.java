package Q1;

import java.io.*;
import java.net.*;
import java.util.*;
import static java.lang.System.out;

/*
 * This program for Company A:
 * New Enhancement  features to get information about IPV6 and Thread 
 * Information : IPV6, MAC Address and Thread.
*/
/*
 * author : Azhari Hj Salleh
 * matrix no : 201461166
 * email : azhari.salleh@gmail.com
 * github acct : https://github.com/azharisalleh
 * 
 */

class MyClasss implements Runnable{

	@Override
	public void run() {
		
		Enumeration<NetworkInterface> nets = null;
		try {
			nets = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        for (NetworkInterface netint : Collections.list(nets))
            displayInterfaceInformation(netint);
		
	try {
		//Pause each thread by 100milisecond
		Thread.sleep(100);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	private void displayInterfaceInformation(NetworkInterface netint) {
		// TODO Auto-generated method stub
        out.printf("\n");
        System.out.println("Initial Program to Access of IPv6 of Subinterface");
    	out.printf(Thread.currentThread().getId()+ " Display name: %s\n", netint.getDisplayName());
        out.printf(Thread.currentThread().getId()+ " Name: %s\n", netint.getName());
        Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
        
        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
            out.printf(Thread.currentThread().getId()+ " InetAddress: %s\n", inetAddress);
        }
       

        try {
			out.printf(Thread.currentThread().getId()+ " Hardware address: %s\n",
			            Arrays.toString(netint.getHardwareAddress()));
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        out.printf("\n");
        System.out.println("End Info for Subinterface");
	}
	
}
public class test2companyA {

	public static void main(String[] args) throws SocketException {
		
		
		Thread t1 = new Thread(new MyClasss());
		Thread t2 = new Thread(new MyClasss());
		Thread t3 = new Thread(new MyClasss());
		t1.start();
		t2.start();
		t3.start();
	}

}

