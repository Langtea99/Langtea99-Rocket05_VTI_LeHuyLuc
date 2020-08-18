
public class Server {
	public static void inDanhSach() {
		for (NhanVien nv : NhanVien.Nhan_vien) {
			System.out.println("ID: "+nv.getEmployeeID());
			System.out.println("FullName: "+nv.getFullName());
			System.out.println("Email: "+nv.getEmail());
			System.out.println("Thâm niên: "+nv.getTham_nien());
			System.out.println("Số ngày nghỉ: "+nv.getSo_ngay_nghỉ() );
			System.out.println("----------------------------------------------");
			System.out.println("----------------------------------------------");
		
		}
	}
}
