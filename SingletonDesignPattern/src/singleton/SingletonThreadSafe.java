package singleton;

public class SingletonThreadSafe {

	private static SingletonThreadSafe instance;

	private SingletonThreadSafe() {

	}

	public static synchronized SingletonThreadSafe getInstance() {
		if (instance == null) {
			instance = new SingletonThreadSafe();
		}
		return instance;
	}

	public static SingletonThreadSafe getInstanceUsingDoubleLocking() {
		if (instance == null) {
			synchronized (SingletonThreadSafe.class) {
				if (instance == null) {
					instance = new SingletonThreadSafe();
				}
			}
		}
		return instance;
	}

}
