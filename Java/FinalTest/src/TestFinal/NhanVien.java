package TestFinal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;
import java.util.Scanner;

public class NhanVien {
	private int id;
	private int employeeId;
	private String fullName;
	private String userName;
	private String email;
	private String ngayBatDau;
	private String namCanTinh;
	private Gender gender;
	private int phone;
	private int tham_nien;
	protected int soNgayNghi;
	private int nghiThaiSan;
	private final int nghiCuoi = 7;
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(int gender) {
		if (gender == 0) {
			this.gender = Gender.valueOf("Male");
		} else 
			this.gender = Gender.valueOf("Female");
	}
	
	public void setNghiThaiSan(int nghiThaiSan) {
		if (nghiThaiSan == 0) {
		this.nghiThaiSan = 7;
		}else{
		this.nghiThaiSan = 180;	
		}
	}

	public void setSoNgayNghi(int soNgayNghi) {
		this.soNgayNghi = soNgayNghi;
	}
	
	public void input(){
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhập employeeId : ");
		employeeId = scanner.nextInt();
		
		System.out.print("Nhập full name : ");
		fullName = scanner.next();
		
		System.out.print("Nhập user name : ");
		userName = scanner.next();
		
		System.out.print("Nhập email : ");
		email = scanner.next();

		System.out.print("Nhập giới tính (0:Nam, 1:Nữ): ");
		int gt = scanner.nextInt();
		setGender(gt);
		setNghiThaiSan(gt);
		
		System.out.print("Nhập phone: ");
		phone = scanner.nextInt();
		
		System.out.print("Nhập ngay bat dau lam viec : ");
		ngayBatDau = scanner.next();
		
		System.out.print("Nhập vao nam : ");
		namCanTinh = scanner.next();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        // Định nghĩa 2 mốc thời gian ban đầu
        Date date1 = Date.valueOf(ngayBatDau);
        Date date2 = Date.valueOf(namCanTinh);
        c1.setTime(date1);
        c2.setTime(date2);

        // Công thức tính số ngày giữa 2 mốc thời gian:
        int noDay = (int) ((c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000));
        int dayOfNam = 365;
        int nam = noDay/dayOfNam;
        if(nam < 10){
        	tham_nien = 12;
        }else{
        	tham_nien = 2 + nam;
        }
        soNgayNghi = tham_nien  + nghiThaiSan +  nghiCuoi;
        System.out.println(soNgayNghi);
        
	}
	public int getSoNgayNghi() {
		return soNgayNghi;
	}

	public void getInfor() {
		
		System.out.println("EmployeeId      : " + employeeId);
		System.out.println("Fullname        : " + fullName);
		System.out.println("Email           : " + email);
	}
}
