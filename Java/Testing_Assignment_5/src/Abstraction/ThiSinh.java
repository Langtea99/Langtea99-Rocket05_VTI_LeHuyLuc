package Abstraction;

public class ThiSinh {
	private int soBaoDanh;
	private String hoTen;
	private String diaChi;
	private UuTien mucDoUuTien;
	public ThiSinh(int soBaoDanh, String hoTen, String diaChi, UuTien mucDoUuTien) {
		super();
		this.soBaoDanh = soBaoDanh;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.mucDoUuTien = mucDoUuTien;
	}
	public int getSoBaoDanh() {
		return soBaoDanh;
	}
	public void setSoBaoDanh(int soBaoDanh) {
		this.soBaoDanh = soBaoDanh;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public UuTien getMucDoUuTien() {
		return mucDoUuTien;
	}
	public void setMucDoUuTien(UuTien mucDoUuTien) {
		this.mucDoUuTien = mucDoUuTien;
	}
	public void inThongTin(){
		System.out.println(this.hoTen +" "+ this.soBaoDanh +" "+this.diaChi);
	}
}
