import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NhanVien {
	private String EmployeeID;
	private String FullName;
	private String UserName;
	private String Email;
	private Date Day_begin;
	private Gender Gender;
	private String Phone;
	private int So_ngay_nghỉ = 12;
	int Tham_nien;
	Chuc_vu chuc_vu;
	
	private Boolean Nghi_thai_san;
	private Boolean Nghi_cuoi;
	
	public static List<NhanVien> Nhan_vien = new ArrayList();


	public String getEmployeeID() {
		return EmployeeID;
	}


	public void setEmployeeID(String employeeID) {
		EmployeeID = employeeID;
	}


	public String getFullName() {
		return FullName;
	}


	public void setFullName(String fullName) {
		FullName = fullName;
	}


	public String getUserName() {
		return UserName;
	}


	public void setUserName(String userName) {
		UserName = userName;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public Date getDay_begin() {
		return Day_begin;
	}


	public void setDay_begin(Date day_begin) {
		Day_begin = day_begin;
	}


	public Gender getGender() {
		return Gender;
	}


	public void setGender(Gender gender) {
		Gender = gender;
	}


	public String getPhone() {
		return Phone;
	}


	public void setPhone(String phone) {
		Phone = phone;
	}


	public int getSo_ngay_nghỉ() {
		return So_ngay_nghỉ;
	}


	public void setSo_ngay_nghỉ(int so_ngay_nghỉ) {
		So_ngay_nghỉ = so_ngay_nghỉ;
	}


	public int getTham_nien() {
		return Tham_nien;
	}


	public void setTham_nien(int tham_nien) {
		Tham_nien = tham_nien;
	}


	public Boolean getNghi_thai_san() {
		return Nghi_thai_san;
	}


	public void setNghi_thai_san(Boolean nghi_thai_san) {
		Nghi_thai_san = nghi_thai_san;
	}


	public Boolean getNghi_cuoi() {
		return Nghi_cuoi;
	}


	public void setNghi_cuoi(Boolean nghi_cuoi) {
		Nghi_cuoi = nghi_cuoi;
	}


	public Chuc_vu getChuc_vu() {
		return chuc_vu;
	}


	public void setChuc_vu(Chuc_vu chuc_vu) {
		this.chuc_vu = chuc_vu;
	}


	public void Nhan_Vien(String EmployeeID, String FullName, String UserName, String Email, Date Day_begin,String Phone, Chuc_vu chuc_vu,Boolean Nghi_thai_san, Boolean Nghi_cuoi) {
		Date date = new Date();
		this.EmployeeID = EmployeeID;
		this.FullName = FullName;
		this.UserName = UserName;
		this.Email = Email;
		this.Day_begin = Day_begin;
		this.Phone = Phone;
		int Tham_nien = (int) (( date.getTime() -  Day_begin.getTime() )/(24 * 3600 * 1000));
		this.Tham_nien = Tham_nien/365;
		this.Nghi_cuoi = Nghi_cuoi;
		this.Nghi_thai_san = Nghi_thai_san;
		this.chuc_vu = chuc_vu;
		Nhan_vien.add(this);
		
		
		if(this.Tham_nien>10) {
			So_ngay_nghỉ += 5;
		}

	}
}
