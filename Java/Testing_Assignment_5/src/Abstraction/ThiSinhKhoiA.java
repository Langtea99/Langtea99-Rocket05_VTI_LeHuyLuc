package Abstraction;

public class ThiSinhKhoiA extends ThiSinh{

	public ThiSinhKhoiA(int soBaoDanh, String hoTen, String diaChi, UuTien mucDoUuTien) {
		super(soBaoDanh, hoTen, diaChi, mucDoUuTien);
		
	}
	public void inThongTin(){
		super.inThongTin();
		System.out.println("Khoi A");
	}
}
