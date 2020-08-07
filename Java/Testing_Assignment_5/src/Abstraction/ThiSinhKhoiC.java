package Abstraction;

public class ThiSinhKhoiC extends ThiSinh{

	public ThiSinhKhoiC(int soBaoDanh, String hoTen, String diaChi, UuTien mucDoUuTien) {
		super(soBaoDanh, hoTen, diaChi, mucDoUuTien);
		
	}
	public void inThongTin(){
		super.inThongTin();
		System.out.println("Khoi C");
	}
}
