package cat;

public class Lion extends Cat {

	private int weight;
	
	public Lion(boolean male, int weight) {
		super(male);
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
	public void catchPray(Object pray) {
		System.out.println("lion.catchPray");
	}
	
	
	
	

}
