package Inheritance;
import java.util.ArrayList;
import java.util.Scanner;

public class QLCB {
	private ArrayList<CanBo> canBos;
	public QLCB() {
		
	}
	public void themCanBo() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhập số cán bộ muốn nhập:  ");
		int n = scanner.nextInt();

		CanBo canBo = new CanBo();
		for (int i = 0; i < n; i++) {
			System.out.print("Bạn muốn nhập cán bộ nào? (1:Công nhân || 2: Kỹ sư || 3: Nhân Viên) ");
			byte luaChon = scanner.nextByte();

			switch (luaChon) {
			case 1:
				canBo = new CongNhan();
				break;
			case 2:
				canBo = new KySu();
				break;
			case 3:
				canBo = new NhanVien();
				break;
			default:
				System.out.println("Nhập sai !");
				i--;
				break;
			}
			canBo.inputCanBo();
			canBos.add(canBo);
			scanner.close();
		}
	}
	public void timKiemCanBo() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập họ tên cần tìm: ");
		String hoTen = scanner.nextLine();

		for (CanBo canBo : canBos) {
			if (hoTen.equals(canBo.getHoTen())) {
				canBo.getInfor();
			}
		}
	}
	public void hienThiCanBo() {
		for (CanBo canBo : canBos) {
			canBo.getInfor();
		}
	}
	public void xoaCanBo() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập họ tên cần xóa: ");
		String hoTen = scanner.nextLine();
		canBos.removeIf(cb -> hoTen.equals(cb.getHoTen()));
	}
}
