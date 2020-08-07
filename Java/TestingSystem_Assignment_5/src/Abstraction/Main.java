package Abstraction;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		TuyenSinh tuyenSinh = new TuyenSinh();
		Scanner scanner = new Scanner(System.in);

		int choose;

		do {
			loadMenu();
			choose = scanner.nextInt();

			switch (choose) {

			case 1:
				tuyenSinh.themThiSinh();
				break;

			case 2:
				tuyenSinh.hienThiSinh();
				break;

			case 3:
				tuyenSinh.timThiSinh();
				break;

			case 4:
				break;

			default:
				System.out.println("Nhập sai ! Vui lòng nhập lại !");
				break;
			}

		} while (choose != 4);

		scanner.close();
	}
	private static void loadMenu() {
		System.out.println("===============MENU=================");
		System.out.println("======1. Thêm mới thí sinh  ========");
		System.out.println("======2. Hiện thông tin thí sinh ===");
		System.out.println("======3. Tìm kiếm theo số báo danh==");
		System.out.println("======4. Thoát                     =");
		System.out.println("====================================");
		System.out.println("===           Bạn chọn:          ===");
	}
}
