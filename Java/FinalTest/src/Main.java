import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Nhap vao he so a :");
		float a = scanner.nextFloat();
		System.out.print("Nhap vao he so b :");
		float b = scanner.nextFloat();
		System.out.print("Nhap vao he so c :");
		float c = scanner.nextFloat();
		
		giaiPTBac2(a, b, c);
	}
	private static void giaiPTBac2(float a, float b, float c) {
		// Ktra cac he so
		if(a == 0){
			if(b == 0){
				System.out.println("Phương trình vô nghiệm !");
			}else{
				System.out.println("Phương trình co nghiệm la : x = " + (-c / b) );
			}
			return;
		}
		float delta = b*b - 4*a*c;
        float x1;
        float x2;
		if(delta > 0){
			x1 = (float) ((-b + Math.sqrt(delta)) / (2*a));
            x2 = (float) ((-b - Math.sqrt(delta)) / (2*a));
            System.out.println("Phương trình có 2 nghiệm là: "
                    + "x1 = " + x1 + " và x2 = " + x2);
		} else if (delta == 0) {
            x1 = (-b / (2 * a));
            System.out.println("Phương trình có nghiệm kép: "
                    + "x1 = x2 = " + x1);
        } else {
            System.out.println("Phương trình vô nghiệm!");
        }
	}

}
