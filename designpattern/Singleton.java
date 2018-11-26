package designpattern;

//This is an example of single instance design pattern
public class Singleton {
	// Single instance
	private static Singleton instance;
	// Initialize single instance
	static {
		instance = new Singleton();
	}

	// The method for getting the single instance
	public static Singleton getInstance() {
		return instance;
	}

	// Private constructor - denies direct instantiation in another classes
	private Singleton() {
	}

}
