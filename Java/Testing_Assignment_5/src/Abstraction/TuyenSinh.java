package Abstraction;

import java.util.ArrayList;

public class TuyenSinh implements ITuyenSinh{
	private ArrayList<ThiSinh>  dsThiSinh;
	public TuyenSinh()
	{
		dsThiSinh = new ArrayList<ThiSinh>();
	}
	@Override
	public void themMoiThiSinh(ThiSinh thiSinhMoi) {
		dsThiSinh.add(thiSinhMoi);
	}
	@Override
	public void hienThiThiSinh(ThiSinh thiSinh) {
		for(int i=0;i<dsThiSinh.size();i++)
		{
			dsThiSinh.get(i);
		}	
	}
	@Override
	public ArrayList<ThiSinh> ds(String hoTen) {
		ArrayList<ThiSinh> ds = new ArrayList<ThiSinh>();
		for(int i=0;i<ds.size();i++)
		{
			if(hoTen == ds.get(i).getHoTen()){
				System.out.println(ds.toString());
			}
		}	
		return ds;
	}

}
