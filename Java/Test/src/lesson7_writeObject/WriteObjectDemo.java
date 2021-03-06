package lesson7_writeObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class WriteObjectDemo {

	public static void main(String[] args) {
		Person p = new Person ("Luc");
//		InputStream is = new ObjectInputStream(in);
		OutputStream osz = null;
		ObjectOutputStream os = null;
		try {
			osz = new FileOutputStream(new File("luc.bin"));
			os = new ObjectOutputStream(osz);
			os.writeObject(p);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				os.close();
				osz.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			try {
				ObjectInputStream is = new ObjectInputStream(new FileInputStream(new File("luc.bin")));
					Person q = (Person)is.readObject();
					q.toString();
				} catch (IOException e) {
					e.printStackTrace();
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
	}
	}
}
