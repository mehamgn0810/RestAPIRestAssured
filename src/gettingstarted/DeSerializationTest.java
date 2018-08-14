package gettingstarted;

import static gettingstarted.SerializationTest.serializeToFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.testng.annotations.Test;

public class DeSerializationTest {

	public static Object deSerializeToObject(String fileName) {
		
		try {
			FileInputStream fileInputStream = new FileInputStream(fileName);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Object deSerializedObject = objectInputStream.readObject();
			
			objectInputStream.close();
			fileInputStream.close();
			
			return deSerializedObject;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Test
	public static void test() {
		
		Rectangle rectangle = new Rectangle(20, 40);
		serializeToFile(rectangle, "rectSerialized");
		
		Rectangle deSerializedRectangle = (Rectangle) deSerializeToObject("rectSerialized");
		System.out.println("Area of Rectangle is => " + deSerializedRectangle.Area());
		
	}
}
