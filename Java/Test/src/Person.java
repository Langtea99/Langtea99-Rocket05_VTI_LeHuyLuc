
public abstract class Person {
	protected String name;
	protected int age;
	public Person()
	{
		
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public abstract void eat(String tenDoAn);
	public abstract void eat(String tenDoAn,String doUong);
}
