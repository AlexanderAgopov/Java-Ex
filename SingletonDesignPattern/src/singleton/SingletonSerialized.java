package singleton;

import java.io.Serializable;

public class SingletonSerialized implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1827818791656061139L;

	private SingletonSerialized() {
	}

	private static class SingletonHelper {
		private static final SingletonSerialized instance = new SingletonSerialized();
	}

	public static SingletonSerialized getInstance() {
		return SingletonHelper.instance;
	}

	protected Object readResolve() {
		return getInstance();
	}

}
