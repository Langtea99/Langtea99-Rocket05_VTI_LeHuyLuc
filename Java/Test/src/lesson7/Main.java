package lesson7;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		File file = new File("IOStream-Rocket05");
		File file2 = new File("C:\\Users\\Shadow\\Desktop\\Rocket05_VTI_LeHuyLuc\\Java\\Test");
		
		System.out.println(file.exists());
		for (String sub : file2.list()){
		System.out.println(sub);
		}
	}

}
