
public class Student extends Person{
	private int mark;	
	Student()
	{
		name = "Luc";
		age = 20;
	}
	public Student(int mark) {
		super();
		this.mark = mark;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public void eat(String nameDoAn)
	{
		System.out.println(this.name + " da lay " + nameDoAn);
		System.out.println(this.name + " da an " + nameDoAn);
	}
	public void eat(String nameDoAn,String doUong)
	{
		System.out.println(this.name + " da lay " + nameDoAn +" da uong "+doUong);
		System.out.println(this.name + " da an " + nameDoAn);
	}
	
}
