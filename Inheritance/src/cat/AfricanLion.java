package cat;

public class AfricanLion extends Lion {

	public AfricanLion(boolean male, int weight) {
		super(male, weight);
	}

	public String toString() {

		if (this.isMale() == true) {
			return String.format("This African lion weighs %d kilos because it is male.", this.getWeight());
		}

		return String.format("This African lion weighs %d kilos because it is female.", this.getWeight());

	}

	@Override
	public void catchPray(Object pray) {
		System.out.println("africanLion.catchPray");
		super.catchPray(pray); // Thus we use the method implementation from the super class, i.e. we add
								// functionality instead of changing the functionality
	}

}
