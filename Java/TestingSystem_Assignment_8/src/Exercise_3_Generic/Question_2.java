package Exercise_3_Generic;

import java.util.List;

public class Question_2 {
	public <T> void print(T a){
		System.out.println(a);
		}
		
	public <T> void printArray(List<T> listInt){
	System.out.println("Cac so trong mang la :");
			for(int i =0;i<listInt.size();i++){
				System.out.println(listInt.get(i)+" ");
			}
			System.out.println("");
	}
}