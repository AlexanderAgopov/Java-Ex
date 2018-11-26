package cat;

public class Cat {

	private boolean male;

	public Cat() {
		this(true);
	}
	
	public Cat(boolean male) {
		this.male = male;
	}

	public boolean isMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

}
