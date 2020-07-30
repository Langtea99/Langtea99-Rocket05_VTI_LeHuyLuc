package Abstraction;

public class Exercise6 {

	public static void main(String[] args) {
		question1();
		question2_3();
	}

	public static void question1() {
		Phone phone = new VietnamesePhone();
		phone.insertContact("Đăng Black", "0825294200");
		phone.removeContact("Đăng Black");
		phone.updateContact("Đăng Black", "0962282193");
		phone.searchContact("Đăng Black");		
	}
	public static void question2_3() {
		Employee employee = new Employee("Đăng Black", 6.9);
		employee.displayInfo();

		Manager manager = new Manager("Quang Anh", 9.6);
		manager.displayInfo();

		Waiter waiter = new Waiter("Chiến Panda", 2.6);
		waiter.displayInfo();
	}
}
