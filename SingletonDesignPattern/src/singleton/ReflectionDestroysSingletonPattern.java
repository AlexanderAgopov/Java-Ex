package singleton;

import java.lang.reflect.Constructor;

public class ReflectionDestroysSingletonPattern {
	// Use Singleton Enum to overcome the following situation
	public static void main(String[] args) {
		SingletonBasic instanceOne = SingletonBasic.getInstance();
		SingletonBasic instanceTwo = null;
		try {
			Constructor[] constructors = SingletonBasic.class.getDeclaredConstructors();
			for (Constructor c : constructors) {
				c.setAccessible(true);
				instanceTwo = (SingletonBasic) c.newInstance();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("instanceOne hashcode = " + instanceOne.hashCode());
		System.out.println("instanceTwo hashcode = " + instanceTwo.hashCode());
	}

}
