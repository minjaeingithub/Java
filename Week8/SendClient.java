package socket.file;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
 
public class SendClient {
    public static void main(String[] args) {
    	
    	String serverIp = "127.0.0.1";
        Socket socket = null;
         
        try {
            // ���� ����
            socket = new Socket(serverIp, 7777);
            System.out.println("������ ����Ǿ����ϴ�.");
 
            //��������
        	
            String filePath = "C:/egov_dev/testdata/sender";
        	String fileNm = "DSC01129.jpg";
        	//String fileNm = "������ȣ���.hwp";
            FileSender fs = new FileSender(socket, filePath, fileNm);
            fs.start();
            
            
            //�޼��� ����
            /*
            String msg = "�̾��� ȭ����! �����";
            MsgSender ms = new MsgSender(socket, msg);
            ms.start();
            */
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//���� ���ۿ� Ŭ����
class FileSender extends Thread {
	
	String filePath;
	String fileNm;
    Socket socket;
    DataOutputStream dos;
    FileInputStream fis;
    BufferedInputStream bis;
 
    public FileSender(Socket socket, String filePath, String fileNm) {
    	
        this.socket = socket;
        this.fileNm = fileNm;
        this.filePath = filePath;
        
        try {
            // ������ ���ۿ� ��Ʈ�� ����
            dos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // @Override
    public void run() {
    	
    	try {
    		
    		//���������� ������ �˸���.('file' ������ ����)
			dos.writeUTF("file");
			dos.flush();
			
			//������ ������ �о Socket Server�� ����
			String result = fileRead(dos);
	    	System.out.println("result : " + result);
	    	
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
            try { dos.close(); } catch (IOException e) { e.printStackTrace(); }
            try { bis.close(); } catch (IOException e) { e.printStackTrace(); }
        }

    }
    
    
    private String fileRead(DataOutputStream dos){
    	
        String result;
    	
    	try {
            System.out.println("���� ���� �۾��� �����մϴ�.");
 
            dos.writeUTF(fileNm);
            System.out.println("���� �̸�(" + fileNm + ")�� �����Ͽ����ϴ�.");
 
            // ������ �о ������ ����
            File file = new File(filePath + "/" + fileNm);
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            
            int len;
            int size = 4096;
            byte[] data = new byte[size];
            while ((len = bis.read(data)) != -1) {
                dos.write(data, 0, len);
            }
            
            //������ ����
            dos.flush();
            
            /* -- ����ȴ�.
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            result = dis.readUTF();
            if( result.equals("SUCCESS") ){
            	System.out.println("���� ���� �۾��� �Ϸ��Ͽ����ϴ�.");
            	System.out.println("���� ������ ������ : " + file.length());
            }else{
            	System.out.println("���� ���� ����!.");
            }
            */
            
            result = "SUCCESS";
        } catch (IOException e) {
            e.printStackTrace();
            result = "ERROR";
        }finally{
            try { fis.close(); } catch (IOException e) { e.printStackTrace(); }
        }
        
        return result;
    }
}

//�޼��� ���ۿ� Ŭ����
class MsgSender extends Thread {
	
    Socket socket;
    String msg;
    DataOutputStream dos;
    FileInputStream fis;
    BufferedInputStream bis;
 
    public MsgSender(Socket socket, String msg) {
    	
        this.socket = socket;
        this.msg = msg;
        
        try {
            // ������ ���ۿ� ��Ʈ�� ����
            dos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
 
    //@Override
    public void run() {
    	
    	try {
    		//�������� ������ ����('msg' ����)
			dos.writeUTF("msg");
			dos.flush();
    		
			dos.writeUTF( msg );
			dos.flush();
			
	    	System.out.println("[" + msg + "] ����");
	    	
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
            try { dos.close(); } catch (IOException e) { e.printStackTrace(); }
        }
    }
}