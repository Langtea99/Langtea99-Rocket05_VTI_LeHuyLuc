
public class Main {

	public static void main(String[] args) {
		NgayThangNam date = new NgayThangNam();
		date.ngay = 31;
		date.thang = 10;
		date.nam = 2017;
		
		NgayThangNam.GioPhutGiay time = date.new GioPhutGiay();
		time.gio = 10;
		time.phut = 15;
		time.giay = 45;
		
		time.xuatThongTin();
	}

}
