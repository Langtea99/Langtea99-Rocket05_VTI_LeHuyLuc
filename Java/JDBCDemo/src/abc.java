import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;

public class abc {

	public static void main(String[] args) {
		daysBetween2Dates();

	}
	public static void daysBetween2Dates() {
     
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        // Định nghĩa 2 mốc thời gian ban đầu
        Date date1 = Date.valueOf("1999-08-04");
        Date date2 = Date.valueOf("2020-08-17");


        c1.setTime(date1);
        c2.setTime(date2);

        // Công thức tính số ngày giữa 2 mốc thời gian:
        int noDay = (int) ((c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000));
        int b=365;
        int nam = noDay/b;
        int thamnien = 0;
     //   System.out.println(nam);
        
        if(nam>10){
        	thamnien = nam +2;
        	System.out.println(thamnien);
        }else{
        	thamnien = 12;
        	System.out.println(thamnien);
        }
        
//        long a = 417;
//        long b = 365;
//        long c = a/b;
//        System.out.println(c);
    }
}