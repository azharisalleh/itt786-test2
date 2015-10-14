package Q1;

/*
 * This program for Company B:
 * Enhancement Features of THREAD
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

//import ThreadIP.MyClass;


class MyClass implements Runnable{

	@Override
	public void run() {
		/*for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getId()+ " Value "+i);
		}*/


		InetAddress ip;
		try {
			
			System.out.println("Thread Features for Reading Local IP and MAC Address For Company B");
			//System.out.print("\n");
			
			ip = InetAddress.getLocalHost();
			System.out.println(Thread.currentThread().getId()+ " Current IP address : " + ip.getHostAddress());
			
			NetworkInterface network = NetworkInterface.getByInetAddress(ip);
				
			byte[] mac = network.getHardwareAddress();
				
			System.out.print(Thread.currentThread().getId()+ " Current MAC address : ");
			System.out.print("\n");
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++) {
				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
			}
			//System.out.print("\n");
			System.out.println(sb.toString());
			//System.out.print("\n");
			//System.out.print("Reading Complete");
			
				
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
			
		} catch (SocketException e){
				
			e.printStackTrace();
				
		}
		
		
	try {
		//Pause each thread by 100milisecond
		Thread.sleep(100);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
}
public class test2companyB {

	public static void main(String[] args) {
		Thread t1 = new Thread(new MyClass());
		Thread t2 = new Thread(new MyClass());
		Thread t3 = new Thread(new MyClass());
		
		t1.start();
		t2.start();
		t3.start();
	}

}
