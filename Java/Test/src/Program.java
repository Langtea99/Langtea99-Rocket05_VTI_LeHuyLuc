import java.util.Date;
public class Program {

	public static void main(String[] args) {
		Person student = new Student();
		Person mentor = new Mentor();
		
		student.eat("Pho");
		mentor.eat("Banh my");
		
		student.eat("Banh my","Coca");
		
		System.out.println( student instanceof Student);
	}
}
