package dog;

import java.util.Scanner;

public class dog {
	// Property-field definition
	private String name;

	// Constructor definition
	public dog() {
		this.name = "Sharo";
	}

	// Constructor definition
	public dog(String name) {
		super();
		this.name = name;
	}

	// Property getter-method definition
	public String getName() {
		return this.name;
	}

	// Property setter-method definition
	public void setName(String name) {
		this.name = name;
	}

	// Method definition
	public void bark() {
		System.out.printf("The dog %s said: \"Bow-wow\"%n", name);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("The name of the first dog is: ");
		String firstDogName = input.nextLine();
		// Assign dog name with a constructor
		dog firstDog = new dog(firstDogName);

		System.out.println("The name of the second dog is: ");
		dog secondDog = new dog();
		// Assign dog name with a property
		secondDog.setName(input.nextLine());

		// Create a dog with a default name
		dog thirdDog = new dog();

		dog[] dogs = new dog[] { firstDog, secondDog, thirdDog };
		for (dog dog1 : dogs) {
			dog1.bark();
		}

	}

}
