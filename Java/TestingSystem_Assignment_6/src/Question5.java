import java.util.Scanner;

public class Question5 {

	public static void main(String[] args) throws Exception {
		Person person = new Person();
		Scanner scanner = new Scanner(System.in);
			try {
				System.out.print("Nhap vao tuoi :");
				int age = scanner.nextInt();
				person.checkAge(age);
			}catch (InvalidAgeException e) {
				System.out.println("Wrong inputing! The age must be greaterthan 0, please input again.");
				}catch(Exception e){
				System.out.println("Wrong inputing! Please input an age as int, inputagain.");
		}
	}
}
