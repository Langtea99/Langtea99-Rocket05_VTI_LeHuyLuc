package Exercise_3_Generic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Exercise_2_Comparing.Student;

public class Main {

	public static void main(String[] args) {
	//Question2
		
		Question_2 q2 = new Question_2();
		q2.print(new Student(2,"Le Huy Luc",new Date("2020/08/08"),8.0f));
		q2.print(4);
		q2.print(4.5f);
		
	//Question4
		
		List<Integer> listInt = new ArrayList<Integer>();
		listInt.add(2);
		listInt.add(1);
		listInt.add(5);
		
		List<Float> listFloat = new ArrayList<Float>();
		listFloat.add(2.4f);
		listFloat.add(1.3f);
		listFloat.add(5.5f);
		
		List<Long> listLong = new ArrayList<Long>();
		listLong.add(2l);
		listLong.add(1l);
		listLong.add(5l);
		
		List<Double> listDouble = new ArrayList<Double>();
		listDouble.add(5.6d);
		listDouble.add(4.6d);
		listDouble.add(6.7d);
		
		System.out.println("_Day Integer_");
		q2.printArray(listInt);
		System.out.println("_Day Float_");
		q2.printArray(listFloat);
		System.out.println("_Day Long_");
		q2.printArray(listLong);
		System.out.println("_Day Double_");
		q2.printArray(listDouble);
		
	//Question6
		
		MyMap<Integer,String> students = new MyMap<Integer,String>();
		students.put(1,"Huy");
		students.put(2,"Luc");
		students.put(3,"Minh");
		
		System.out.println(students.getValue(2));
	}
}
