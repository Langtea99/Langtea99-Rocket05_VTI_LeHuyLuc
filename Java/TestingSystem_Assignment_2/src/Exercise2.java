import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
public class Exercise2 {

	public static void main(String[] args) {
	//Question 1: Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số nguyên đó
		int a = 5;
		System.out.printf("%d%n", a);
	//Question 2: Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in ra số nguyên đó thành định dạng như sau: 100,000,000
		int b = 100000000;
		System.out.printf(Locale.US, "%,d%n", b);
	//Question 3: Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số thực đó chỉ bao gồm 4 số đằng sau
		float c = 5.567098f;
		System.out.printf("%5.4f%n", c);
	//Question 4: Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định dạng như sau:
			//Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau:
			//Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.
		String chuoi = "Nguyen Van A";
		System.out.printf("Tên tôi là \"" + chuoi + "\" và tôi đang độc thân \n");
	//Question 5: Lấy thời gian bây giờ và in ra theo định dạng sau: 24/04/2020 11h:16p:20s 
		String t = "dd/MM/yyyy HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(t);
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
	}
}
