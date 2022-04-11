import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ServerThread extends Thread {
	private String name = null;
	public ServerThread () {
		this.name = "ServerThread";
	}

	public void run () {
		Scanner scn = new Scanner(System.in);
		String filepath = scn.next();
		System.out.println("File Name: " + filepath);
		OutputStream out = null;
		ServerSocket ss = null;
		try {
			while(true) {
			ss = new ServerSocket(5000);
			Socket soc = ss.accept();
			out = soc.getOutputStream();
			DataOutputStream dos = new DataOutputStream (out);
				dos.writeUTF (scn.nextLine());
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
