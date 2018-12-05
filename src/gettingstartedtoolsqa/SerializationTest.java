package gettingstartedtoolsqa;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.testng.annotations.Test;

public class SerializationTest {

	public static void serializeToFile(Object classObject, String fileName) {
		
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(fileName);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(classObject);
			
			objectOutputStream.close();
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public static void test() {
		
		Rectangle rectangle = new Rectangle(20, 40);
		serializeToFile(rectangle, "rectSerialized");
		
	}
}
