import java.io.*;
import java.net.*;

public class MainThread {
	public static void main(String[] args){
		Thread t = new ServerThread();
		t.start();
		System.out.println("server is ready");
			while(true) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} 
	}
}