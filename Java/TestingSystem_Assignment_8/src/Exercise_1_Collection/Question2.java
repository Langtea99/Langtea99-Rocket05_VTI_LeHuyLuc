package Exercise_1_Collection;

import java.util.*;

public class Question2 {
	
	static void showpush(Stack st, String a) {
	      st.push(new String(a));
	   }

	   static void showpop(Stack st) {
	      String a = (String) st.pop();
	      System.out.println(a);
	   }
	public static void main(String[] args) {
		
		Stack st = new Stack();
	      showpush(st,"Nguyen Van A");
	      showpush(st,"Nguyen Van B");
	      showpush(st,"Nguyen Van C");
	      System.out.println("Danh sach tu muon den som :");
	      showpop(st);
	      showpop(st);
	      showpop(st);
	}
}
