package Exercise_1_Collection;

import java.util.ArrayList;

public class Student {
	private ArrayList<Student> students;
	public Student(){
		students = new ArrayList<>();
	}
	public Student(String student) {
		students = new ArrayList<>();
	}
	public Student(ArrayList<Student> students) {
		super();
		this.students = students;
	}
	public ArrayList<Student> getStudents() {
		return students;
	}
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	} 
}
