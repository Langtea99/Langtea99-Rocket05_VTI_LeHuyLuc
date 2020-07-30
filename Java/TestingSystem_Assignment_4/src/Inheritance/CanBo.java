package Inheritance;

import java.util.Scanner;

public class CanBo {
	private String hoTen;
	private byte tuoi;
	private GioiTinh gioiTinh;
	private String diaChi;
	
	public CanBo() 
	{
	}

	public CanBo(String hoTen, byte tuoi, GioiTinh gioiTinh, String diaChi) {
		super();
		this.hoTen = hoTen;
		this.tuoi = tuoi;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public byte getTuoi() {
		return tuoi;
	}

	public void setTuoi(byte tuoi) {
		this.tuoi = tuoi;
	}

	public GioiTinh getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(int gioiTinh) {
		if (gioiTinh == 0) {
			this.gioiTinh = GioiTinh.valueOf("MALE");
		} else if (gioiTinh == 1) {
			this.gioiTinh = GioiTinh.valueOf("FEMALE");
		} else {
			this.gioiTinh = GioiTinh.valueOf("UNKNOWN");
		}
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public void inputCanBo() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhập họ tên: ");
		String hoTen = scanner.nextLine();

		System.out.print("Nhập tuổi: ");
		byte tuoi = scanner.nextByte();

		System.out.print("Nhập giới tính (0:Nam, 1:Nữ, khác: Unknown): ");
		setGioiTinh(scanner.nextInt());

		System.out.print("Nhập địa chỉ: ");
		String diaChi = scanner.nextLine();
	}

	public void getInfor() {
		System.out.println("Họ tên      : " + hoTen);
		System.out.println("Tuổi        : " + tuoi);
		System.out.println("Giới tính   : " + gioiTinh);
		System.out.println("Địa chỉ     : " + diaChi);
	}

	@Override
	public String toString() {
		return "CanBo{" + " Hoten: " + hoTen + '\'' + ", Tuoi: " + tuoi + ", Gioi tinh: " + gioiTinh + ", Dia Chi='" + diaChi
				+ '\'' + '}';
	}
}
