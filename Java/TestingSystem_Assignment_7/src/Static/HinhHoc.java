package Static;

public class HinhHoc implements IHinhHoc{
	
	private static int counter = 0;

	private float a;
	private float b;

	public HinhHoc(float a, float b) throws Exception {
		if (counter > Configs.SO_LUONG_HINH_TOI_DA) {
			throw new Exception("Số lượng hình tối đa là: " + Configs.SO_LUONG_HINH_TOI_DA);
		}

		this.a = a;
		this.b = b;
	}

	@Override
	public void chuVi(float a, float b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dienTich(float a, float b) {
		// TODO Auto-generated method stub
		
	}

}