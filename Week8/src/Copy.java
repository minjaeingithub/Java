import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

public class Copy {
	public static void main(String[] args) {
		//input
		String srcFile = args[0];
		String tgtFile = args[1];
		
		//check 2 parameters 
		if(srcFile == null) {
			System.out.println("Usage: java Copy sourceFile targetFile");
		}
		if(tgtFile == null) {
			System.out.println("Usage: java Copy sourceFile targetFile");
		}
		File f1 = new File(srcFile);
		if(f1.exists() == false) {
			System.out.println("source file image.jpg does not exists");
		}
		
		File f2 = new File(tgtFile);
		if(f2.exists()) {
			System.out.println("target file newimage.jpg already exists");
		}
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		
		try {
			fis = new FileInputStream(args[0]);
			bis = new BufferedInputStream(fis);
			fos = new FileOutputStream(args[1]);
			bos = new BufferedOutputStream(fos);
			int data = 0;
			if(data != -1){
				byte[] buffer = new byte[423000];
				data = bis.read(buffer);
				bos.write(buffer);
			}

		//after copy
		File f3 = new File("newimage.jpg");
		if(f3.exists()) {
			System.out.println(data + "bytes copied");
		}
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		 finally {
			try {
				fis.close();
				bis.close();
				bos.close();
				fos.close();
				} catch (IOException e) {
					e.printStackTrace();}
		}
	}
}