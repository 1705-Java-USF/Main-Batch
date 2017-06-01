package com.revature.day3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationExample {
	static ObjectOutputStream oos;
	
	
	public static void main(String[] args) {
		/*
		 * In Java we have the option to serialize objects.
		 * By serializing an object, we convert it to a byte code format.
		 * This offers the ability to pass the object between application safely and securely.
		 * 
		 * When the target receives the serialized object, they should have a method for
		 * deserializing it for their own use.
		 */

		//Create our employee object
		Employee e1 = new Employee("Bobbert", "Bobson", 123123123);
		System.out.println(e1);
		
		try{
			//Wrap an object output stream around a fileoutputstream, with the filename to be created as a parameter
			oos = new ObjectOutputStream(new FileOutputStream("employee.ser"));
			//Finally, serialize the object
			oos.writeObject(e1);
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
