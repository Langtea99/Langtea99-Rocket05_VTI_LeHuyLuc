import java.util.Date;

public class Nu extends NhanVien{
	private Gender gender = Gender.NỮ;

	public Gender getGender() {
		return gender;
	}

	public  Nu(String EmployeeID, String FullName, String UserName, String Email, Date Day_begin, String Phone,
			Chuc_vu chuc_vu, Boolean Nghi_thai_san, Boolean Nghi_cuoi) {
		super();
		if(Nghi_thai_san== true) {
			this.setSo_ngay_nghỉ(getSo_ngay_nghỉ()+180);
		}
		
		if(Nghi_cuoi==true) {
			this.setSo_ngay_nghỉ(getSo_ngay_nghỉ()+7);
		}
		
		if(chuc_vu==Chuc_vu.TRƯỞNG_PHÒNG) {
			this.setSo_ngay_nghỉ(getSo_ngay_nghỉ()+2);
		}
		
		if(chuc_vu==Chuc_vu.PHÓ_PHÒNG) {
			this.setSo_ngay_nghỉ(getSo_ngay_nghỉ()+1);
		}
}
}
