package lesson7;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class DownloadFileDemo {

	public static void main(String[] args) {
	String imagePath = "https://img.thuthuattinhoc.vn/uploads/2019/08/24/anh-anime-boy-buon_022404056.jpg";
	InputStream is = null;
	BufferedInputStream in = null;
	String localImagePath = "Lang.jpg";
	OutputStream os = null;
	try {
		os = new FileOutputStream(new File(localImagePath));
		is = new URL(imagePath).openStream();
		in = new BufferedInputStream(is);
		byte[] b = new byte[1024];
		int numberOfByte = 0;
		while((numberOfByte = in.read(b))!= -1){
			os.write(b,0,numberOfByte);
		}
		in.read(b);
	} catch (IOException e) {
		e.printStackTrace();
	}finally{
	try {
		os.close();
		is.close();
		in.close();
	} catch (IOException e) {
		e.printStackTrace();
	}	
	}
	}
}
