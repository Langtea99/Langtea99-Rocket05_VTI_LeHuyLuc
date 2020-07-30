package Inheritance;

import java.util.Scanner;

public class KySu extends CanBo{
	private String nganhDaoTao;
	
	public KySu(){
		
	}

	public KySu(String nganhDaoTao) {
		super();
		this.nganhDaoTao = nganhDaoTao;
	}

	public String getNganhDaoTao() {
		return nganhDaoTao;
	}

	public void setNganhDaoTao(String nganhDaoTao) {
		this.nganhDaoTao = nganhDaoTao;
	}
	@Override
	public void inputCanBo() {
		super.inputCanBo();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập ngành đào tạo: ");
		nganhDaoTao = scanner.nextLine();
	}

	@Override
	public void getInfor() {
		super.getInfor();
		System.out.println("Ngành đào tạo  : " + nganhDaoTao);
	}
}
