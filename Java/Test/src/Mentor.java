
public  class Mentor extends Person{
	@Override
	public void eat(String nameDoAn)
	{
		System.out.println(this.name + " da rua tay ");
		System.out.println(this.name + " da lay " + nameDoAn);
		System.out.println(this.name + " da an " + nameDoAn);
	}

	@Override
	public void eat(String tenDoAn, String doUong) {
		
	}
}
