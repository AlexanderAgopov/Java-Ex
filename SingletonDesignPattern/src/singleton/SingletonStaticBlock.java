package singleton;

public class SingletonStaticBlock {

	private static SingletonStaticBlock instance;

	private SingletonStaticBlock() {
	}

	// static block initialization for exception handling
	static {
		try {
			instance = new SingletonStaticBlock();
		} catch (Exception e) {
			throw new RuntimeException("Exception occured while initializing singleton instance");
		}
	}

	public static SingletonStaticBlock getInstance() {
		return instance;
	}

}
