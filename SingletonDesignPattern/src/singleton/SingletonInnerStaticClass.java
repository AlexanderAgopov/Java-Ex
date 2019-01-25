package singleton;

public class SingletonInnerStaticClass {

	private SingletonInnerStaticClass() {
	}

	private static class SingletonHelper {
		private static final SingletonInnerStaticClass INSTANCE = new SingletonInnerStaticClass();
	}

	public static SingletonInnerStaticClass getInstance() {
		return SingletonHelper.INSTANCE;
	}

}
