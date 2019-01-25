package singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SIngletonSerializedTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		// serialize
		SingletonSerialized instanceOne = SingletonSerialized.getInstance();
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.ser"));
		out.writeObject(instanceOne);
		out.close();

		// deserialize
		ObjectInput in = new ObjectInputStream(new FileInputStream("file.ser"));
		SingletonSerialized instanceTwo = (SingletonSerialized) in.readObject();

		System.out.println("instanceOne hashcode = " + instanceOne.hashCode());
		System.out.println("instanceTwo hashcode = " + instanceTwo.hashCode());

	}

}
