package entity;

public class CPU {
	private int price;
	public CPU(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public class Processor {
		private int coreAmount;
		private String memufacturer;
		
		public Processor(int coreAmount, String memufacturer) {
			this.coreAmount = coreAmount;
			this.memufacturer = memufacturer;
		}
		public int getCoreAmount() {
			return coreAmount;
		}
		public void setCoreAmount(int coreAmount) {
			this.coreAmount = coreAmount;
		}
		public String getMemufacturer() {
			return memufacturer;
		}
		public void setMemufacturer(String memufacturer) {
			this.memufacturer = memufacturer;
		}
		public float getCache() {
			return (float) 4.3;
		}
	}
	public class Ram {

		private int memory;
		private String menufacturer;
		
		public float getClockSpeed() {
			return (float) 5.5;	
		}

		public Ram(int memory, String menufacturer) {
			super();
			this.memory = memory;
			this.menufacturer = menufacturer;
		}

		public int getMemory() {
			return memory;
		}

		public void setMemory(int memory) {
			this.memory = memory;
		}

		public String getMenufacturer() {
			return menufacturer;
		}

		public void setMenufacturer(String menufacturer) {
			this.menufacturer = menufacturer;
		}
	}
}
