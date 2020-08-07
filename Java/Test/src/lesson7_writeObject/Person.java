package lesson7_writeObject;

import java.io.Serializable;

public class Person implements Serializable {
	public static int COUNT = 0;
	private String name;
	
	public Person(String name){
		this.name = name;
		COUNT++;
	}
}
