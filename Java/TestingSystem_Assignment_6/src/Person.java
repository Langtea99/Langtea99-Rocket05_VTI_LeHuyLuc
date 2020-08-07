import java.util.Scanner;

public class Person {
	private static Scanner scanner = new Scanner(System.in);
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public static void checkAge(int age) throws InvalidAgeException{
		if(age<0){
			throw new InvalidAgeException("Wrong inputing! The age must be greaterthan 0, please input again.");
		}
	}
	}
