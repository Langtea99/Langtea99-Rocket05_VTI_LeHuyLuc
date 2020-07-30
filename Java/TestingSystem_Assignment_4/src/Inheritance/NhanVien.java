package Inheritance;

import java.util.Scanner;

public class NhanVien extends CanBo{
	private String congViec;
	
	public NhanVien(){
		
	}

	public NhanVien(String congViec) {
		super();
		this.congViec = congViec;
	}

	public String getCongViec() {
		return congViec;
	}

	public void setCongViec(String congViec) {
		this.congViec = congViec;
	}
	@Override
	public void inputCanBo() {
		super.inputCanBo();

		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập công việc: ");
		congViec = scanner.nextLine();
	}

	@Override
	public void getInfor() {
		super.getInfor();
		System.out.println("Công việc  : " + getCongViec());
	}
}
