package singleton;

public class SingletonEnum {
	// This way reflection cannot be used to destroy the singleton pattern
	public enum EnumSingleton {
		INSTANCE;

		public static void doSomething() {
			// some code
		}
	}

}
