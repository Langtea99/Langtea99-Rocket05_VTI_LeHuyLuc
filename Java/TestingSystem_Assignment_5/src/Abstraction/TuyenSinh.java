package Abstraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TuyenSinh implements ITTuyenSinh{
	private List<ThiSinh> thiSinhs;
	public TuyenSinh() {
		thiSinhs = new ArrayList<>();
	}

	@Override
	public void themThiSinh() {
		ThiSinh thiSinh = new ThiSinh();
		thiSinh.nhap ();
		thiSinhs.add(thiSinh);
		
	}

	@Override
	public void hienThiSinh() {
		for(ThiSinh thisinh : thiSinhs){
			System.out.println(thisinh);
		}		
	}

	@Override
	public void timThiSinh() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập sbd cần tìm: ");
		int sbd = scanner.nextInt();

		for (ThiSinh thisinh : thiSinhs) {
			if (thisinh.getSoBaoDanh()== sbd ) {
				System.out.println(thisinh);
			}
		}
		
	}

}
