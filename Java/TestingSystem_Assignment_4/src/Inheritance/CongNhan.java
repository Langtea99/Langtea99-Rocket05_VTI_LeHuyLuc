package Inheritance;

import java.util.Scanner;

public class CongNhan extends CanBo{
	private int bac;

	public CongNhan()
	{
		
	}
	public CongNhan(int bac) {
		super();
		this.bac = bac;
	}
	public int getBac() {
		return bac;
	}

	public void setBac(int bac) {
		this.bac = bac;
	}
	@Override
	public void inputCanBo() {
		super.inputCanBo();

		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập bậc của công nhân (1-10): ");
		bac = scanner.nextByte();
		
		while(bac <0 & bac>10 )
		{
			System.out.print("Nhập sai!Nhập lại bậc của công nhân(1-10): ");
			bac = scanner.nextByte();
		}
	}

	@Override
	public void getInfor() {
		super.getInfor();
		System.out.println("Bậc  : " + bac);
	}
}
