package lesson7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Input_IOStream {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\Shadow\\Desktop\\Rocket05_VTI_LeHuyLuc\\Java\\Test\\IOStream-Rocket05");
		System.out.println(file.exists());
		FileInputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(file);
			os = new FileOutputStream (new File("Hello.txt"));
			int c;
			String data = "";
			try {
				while((c = is.read())!= -1){
//					System.out.print((char)c);
					data += (char)c;
					os.write(c);
				}
//				data += "\nKhoe chu";
//				os.write(data.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} finally{
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
