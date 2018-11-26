package cat;

public class Lynx extends Cat {

	public Lynx(boolean male, int weight) {
		super(male);
		// super.male = male; - if we use such code the field "male" in the super class
		// should be "protected" not "private"
	}

}
