package Exercise_2_Comparing;

import java.util.Comparator;

public class SortByDate implements Comparator<Student>{

	@Override
	public int compare(Student student1, Student student2) {
		int value = 0;
		if(student1.getNgaySinh().compareTo(student2.getNgaySinh())!=0){
			value = student1.getNgaySinh().compareTo(student2.getNgaySinh());
		}
		return value;
	}

}
