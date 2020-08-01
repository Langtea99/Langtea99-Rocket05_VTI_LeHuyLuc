package Inheritance;

import java.util.Scanner;

public class Bao extends TaiLieu {

	private String ngayPhatHanh;
public Bao(){
		
	}

	@Override
	public void input() {
		super.input();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập ngày phát hành: ");
		ngayPhatHanh = scanner.nextLine();
	}
	
	public Bao(String ngayPhatHanh) {
		super();
		this.ngayPhatHanh = ngayPhatHanh;
	}

	public void setNgayPhatHanh(String ngayPhatHanh) {
		this.ngayPhatHanh = ngayPhatHanh;
	}

	@Override
	public void getInfor() {
		super.getInfor();
		System.out.println("Ngày phát hành: " + getNgayPhatHanh());
	}

	public String getNgayPhatHanh() {
		return ngayPhatHanh;
	}

}
