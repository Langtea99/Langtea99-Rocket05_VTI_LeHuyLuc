package Abstraction;

public abstract class Phone {

	private String[] contacts;
	private String number;
	private String name;
	
	public Phone(){
		
	}

	public abstract void insertContact(String name, String phone);

	public abstract void removeContact(String name);

	public abstract void updateContact(String name, String newPhone);

	public abstract void searchContact(String name);

	public String[] getContacts() {
		return contacts;
	}

	public void setContacts(String[] contacts) {
		this.contacts = contacts;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Phone(String[] contacts, String number, String name) {
		super();
		this.contacts = contacts;
		this.number = number;
		this.name = name;
	}

}