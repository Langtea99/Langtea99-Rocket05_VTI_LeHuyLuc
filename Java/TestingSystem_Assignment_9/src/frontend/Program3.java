package frontend;
import backend.Exercise3;

public class Program3 {

	public static void main(String[] args) {
		Exercise3 ex3 = new Exercise3();
		ex3.question1();
		ex3.question2();
	}
	
	//Question3:
	//+Output: Đây là inner class
	//+Output: Đây là inner class ( OuterClass.InnerClass innerClass = outerClass.new InnerClass();)
	//+Output: Ngày : 31/10/2017 
	//         Giờ  : 10/15/30    (NgayThangNam.GioPhutGiay time = date.new GioPhutGiay();)
}
