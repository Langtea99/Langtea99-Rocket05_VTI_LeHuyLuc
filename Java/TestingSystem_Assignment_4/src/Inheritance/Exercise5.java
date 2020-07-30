package Inheritance;

import java.util.Scanner;

public class Exercise5 {

	public static void main(String[] args) {
		question1_2();
		question3();
		question4();
		
	}	
		private static void menuQuesion1_2() {
			System.out.println("=======MENU==========");
			System.out.println("==  1. Thêm cán bộ ==");
			System.out.println("==  2. Hiện cán bộ ==");
			System.out.println("==  3. Tìm cán bộ  ==");
			System.out.println("==  4. Xóa cán bộ  ==");
			System.out.println("==  0. Thoát       ==");
			System.out.println("=====================");
		}

		public static void question1_2() {
			QLCB qlcb = new QLCB();

			byte choose;
			do {
				Scanner scanner = new Scanner(System.in);
				menuQuesion1_2();
				choose = scanner.nextByte();

				switch (choose) {
				case 1:
					qlcb.themCanBo();
					break;
				case 2:
					qlcb.hienThiCanBo();
					break;
				case 3:
					qlcb.timKiemCanBo();
					break;
				case 4:
					qlcb.xoaCanBo();
					break;
				case 0:
					break;
				default:
					System.out.println("Nhập sai ! Nhập lại !");
					break;
				}
			} while (choose != 0);

		}
		private static void menuQuestion4() {
			System.out.println("=======MENU==========");
			System.out.println("==  1. Thêm tài liệu ==");
			System.out.println("==  2. Hiện tài liệu ==");
			System.out.println("==  3. Tìm tài liệu  ==");
			System.out.println("==  4. Xóa tài liệu  ==");
			System.out.println("==  0. Thoát         ==");
			System.out.println("=====================");
		}

		public static void question4() {
			QLTV qltv = new QLTV();

			byte choose;
			do {
				menuQuestion4();
				Scanner scanner = new Scanner(System.in);

				choose = scanner.nextByte();
				switch (choose) {
				case 1:
					qltv.inputTaiLieu();
					break;
				case 2:
					qltv.printTaiLieu();
					break;
				case 3:
					qltv.findTaiLieu();
					break;
				case 4:
					qltv.deleteTaiLieu();
					break;
				case 0:
					break;
				default:
					System.out.println("Nhập sai ! Nhập lại !");
					break;
				}
			} while (choose != 0);
		}
		public static void question3() {
			HighSchoolStudent highSchoolStudent = new HighSchoolStudent("Nam", 1, "Chuyên Văn", "Đại học công nghệ");
			System.out.println(highSchoolStudent);
		}
	}
