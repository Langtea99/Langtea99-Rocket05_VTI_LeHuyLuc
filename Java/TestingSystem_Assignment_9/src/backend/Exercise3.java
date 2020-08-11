package backend;

import entity.CPU;
import entity.Car;
import entity.Car.Engine;

public class Exercise3 {
	
	public void question1() {
		CPU cpu = new CPU(100);
		CPU.Ram ram = cpu.new Ram(8, "Acer");
		CPU.Processor processor = cpu.new Processor(4, "Asus");
		System.out.println(ram.getClockSpeed());
		System.out.println(processor.getCache());
		}
	public void question2(){

		Car car = new Car("Mazda", "8WD");

		Engine engine = car.new Engine();
		engine.setEngineType("Crysler");

		car.setEngine(engine);

		car.printInfor();
	}
}
