package Abstraction;

import java.util.Scanner;

public class ThiSinh {
	public int getSoBaoDanh() {
		return soBaoDanh;
	}

	public void setSoBaoDanh(int soBaoDanh) {
		this.soBaoDanh = soBaoDanh;
	}

	private int soBaoDanh;
	private String hoTen;
	private String diaChi;
	private int doUuTien;
	private Khoi khoi;
	
	public void nhap() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhập số báo danh: ");
		soBaoDanh = scanner.nextInt();

		System.out.print("Nhập họ tên: ");
		hoTen = scanner.next();

		System.out.print("Nhập địa chỉ: ");
		diaChi = scanner.next();

		System.out.print("Nhập mức ưu tiên: ");
		doUuTien = scanner.nextByte();

		System.out.print("Nhập khối (A/B/C) :");
		khoi = new Khoi();
		khoi.setTen(scanner.next());
	}

	@Override
	public String toString() {
		return "Thi Sinh{" + "So bao danh :" + soBaoDanh + ", Ho ten :" + hoTen +  ", Dia Chi :" + diaChi + ", Do uu tien :" + doUuTien + ", Khoi :" + khoi.getMonThi() + "}";
	}
}
