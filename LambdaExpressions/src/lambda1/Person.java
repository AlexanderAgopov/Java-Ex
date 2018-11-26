package lambda1;

public class Person {

	private String name;
	private int age;

	public enum Sex {
		MALE, FEMALE
	}
	
	private Sex sex;

	public Person() {

		this.name = name;
		this.age = age;
		this.sex = sex;
		

	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
