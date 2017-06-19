package com.revature.day3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SerializationDecryptionExample {

	static ObjectInputStream ois;
	static Employee e1;
	
	public static void main(String[] args) throws IOException{
		
		try{
			ois = new ObjectInputStream(new FileInputStream("employee.ser"));
			e1 = (Employee)ois.readObject();
			
			
			System.out.println(e1);
			
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			if(ois != null){
				ois.close();
			}
		}
		
	}

}
