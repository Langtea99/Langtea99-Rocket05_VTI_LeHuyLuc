package Abstraction;

public class ThiSinhKhoiB extends ThiSinh{
	public ThiSinhKhoiB(int soBaoDanh, String hoTen, String diaChi, UuTien mucDoUuTien) {
		super(soBaoDanh, hoTen, diaChi, mucDoUuTien);
		
	}
	
	public void inThongTin(){
		super.inThongTin();
		System.out.println("Khoi B");
	}
}