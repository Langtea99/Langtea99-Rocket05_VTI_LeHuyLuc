package Exercise_2_Comparing;

import java.util.Date;

public class Student implements Comparable<Student>{
	
	private int id;
	private String name;
	private Date ngaySinh;
	private Float diem;
	
	public Student(int id, String name, Date ngaySinh, float diem) {
		super();
		this.id = id;
		this.name = name;
		this.ngaySinh = ngaySinh;
		this.diem = diem;
	}
	
	@Override
	public int compareTo(Student student) {
		
		return this.name.compareTo(student.getName());
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public float getDiem() {
		return diem;
	}

	public void setDiem(Float diem) {
		this.diem = diem;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString(){
		return "ID :"+id+'\n'+"Name :"+name+'\n'+"Ngay sinh :"+'\n'+ngaySinh+'\n'+"Diem :"+diem;
	}

}
