package TestFinal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TruongPhong extends NhanVien {
	
	@Override
	public void input(){
		super.input();
	}
	
	@Override
	public void getInfor() {
		super.getInfor();
		System.out.println("So ngay nghi    : " + (soNgayNghi + 2));
}
}