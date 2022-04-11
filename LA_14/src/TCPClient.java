import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPClient {
	
	public static void main(String[] args) throws Exception {
		String serverIP = "localhost";
		Socket soc = null;
		String filepath ="";
		
		BufferedOutputStream toServer = null;
		FileInputStream fis = null;
		DataOutputStream dos = null;
		Scanner scn = new Scanner(System.in);
		try {
			soc = new Socket(serverIP, 5000);
			filepath = scn.next();
			System.out.println("Request filename : " + filepath);
			toServer = new BufferedOutputStream(soc.getOutputStream());
			dos = new DataOutputStream(soc.getOutputStream());
			

			fis = new FileInputStream(filepath);
			byte[] b = new byte[4096];
			int numchar = 0;
			
			while((numchar = fis.read(b,0,b.length)) != -1) {
				dos.write(b,0,numchar);
			}
			
			fis.close();
			soc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}