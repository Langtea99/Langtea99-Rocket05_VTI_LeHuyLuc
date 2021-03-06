package Exercise_2_Comparing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Student> students = new ArrayList<>();
		students.add(new Student(1,"Le Dang Huy",new Date("2020/08/08"),8.5f));
		students.add(new Student(2,"Le Huy Luc",new Date("2020/08/08"),8.0f));
		students.add(new Student(3,"Le Huy Luc",new Date("2020/08/08"),7.5f));
		students.add(new Student(4,"Nguyen Dinh Minh",new Date("2020/08/08"),8.5f));
		students.add(new Student(5,"Le Qua Quyt",new Date("2020/08/08"),9.5f));
		
//		Collections.sort(students);
//		for(Student student : students){
//			System.out.println(student);
//		}
		Comparator sortBy = new SortBy();
		Comparator sortBy1 = new SortByDate();
		Collections.sort(students, sortBy.thenComparing(sortBy1));
		
		for(Student student : students){
			System.out.println(student);
		}
	}

}
