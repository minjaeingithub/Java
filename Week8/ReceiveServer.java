package socket.file;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
 
public class ReceiveServer {
	
    public static void main(String[] args) {
    	
        ServerSocket serverSocket = null;
        Socket socket = null;
        
        try {
			
        	serverSocket = new ServerSocket(7777);
			System.out.println("������ ���۵Ǿ����ϴ�.");

			//Ŭ���̾�Ʈ���� ���� ��� ����
			while( true ){
			
				System.out.println("���ο� Client�� �����û�� ��ٸ��ϴ�.");

				// ����Ǹ� ��ſ� ���� ����
				socket = serverSocket.accept();
				System.out.println("Ŭ���̾�Ʈ�� ����Ǿ����ϴ�.");
 
				// ���� ���� �۾� ����
				Receiver receiver = new Receiver(socket);
				receiver.start();
			}
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
 
class Receiver extends Thread {
	
    Socket socket;
    DataInputStream dis = null;
    FileOutputStream fos = null;
    BufferedOutputStream bos = null;
 
    public Receiver(Socket socket) {
        this.socket = socket;
    }
 
    //@Override
    public void run() {
    	
    	try {
			
    		dis = new DataInputStream(socket.getInputStream());
    		String type = dis.readUTF();
    		
    		/*type��('file'�Ǵ� 'msg')�� �������� ������ ���۵ƴ��� ���ڿ��� ���۵ƴ��� �����Ѵ�.*/
    		if(type.equals("file")){
    			
        		//���۵� ���� ����!
    			String result = fileWrite(dis);
    	    	System.out.println("result : " + result);
    			
    		}else if(type.equals("msg")){
    			
    			//���ŵ� �޼��� ����
    			String result = getMsg(dis);
    			System.out.println("result : " + result);
    		}
    		
	    	//Ŭ���̾�Ʈ�� ��� ���� - �����̵ȴ�.
	    	//DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            //dos.writeUTF(result);
	    	
		} catch (IOException e) {
	    	System.out.println("run() Fail!");
			e.printStackTrace();
		}
    }
    
    private String fileWrite(DataInputStream dis){
    	
    	String result;
    	String filePath = "C:/egov_dev/testdata/receiver";
    	 
        try {
            System.out.println("���� ���� �۾��� �����մϴ�.");
 
            // ���ϸ��� ���� �ް� ���ϸ� ����
            String fileNm = dis.readUTF();
            System.out.println("���ϸ� " + fileNm + "�� ���۹޾ҽ��ϴ�.");
 
            // ������ �����ϰ� ���Ͽ� ���� ��� ��Ʈ�� ����
            File file = new File(filePath + "/" + fileNm);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            System.out.println(fileNm + "������ �����Ͽ����ϴ�.");
 
            // ����Ʈ �����͸� ���۹����鼭 ���
            int len;
            int size = 4096;
            byte[] data = new byte[size];
            while ((len = dis.read(data)) != -1) {
                bos.write(data, 0, len);
            }
            
            //bos.flush();
            result = "SUCCESS";
            
            System.out.println("���� ���� �۾��� �Ϸ��Ͽ����ϴ�.");
            System.out.println("���� ������ ������ : " + file.length());
        } catch (IOException e) {
            e.printStackTrace();
            result = "ERROR";
        }finally{
            try { bos.close(); } catch (IOException e) { e.printStackTrace(); }
            try { fos.close(); } catch (IOException e) { e.printStackTrace(); }
            try { dis.close(); } catch (IOException e) { e.printStackTrace(); }
        }
    	
        return result;
    }
    
    private String getMsg(DataInputStream dis){
    	
    	String result;
    	 
        try {
            System.out.println("���� ���� �۾��� �����մϴ�.");
 
            // ���ϸ��� ���� �ް� ���ϸ� ����
            String msg = dis.readUTF();
            System.out.println("msg : " + msg);
 
            result = "SUCCESS";
            
            System.out.println("�޼��� ���� �۾��� �Ϸ��Ͽ����ϴ�.");
        } catch (IOException e) {
            e.printStackTrace();
            result = "ERROR";
        }finally{
            try { dis.close(); } catch (IOException e) { e.printStackTrace(); }
        }
    	
        return result;
    }
}
