package com.revature.day4;

public class DesignPatterns {

	public static void main(String[] args) {
		System.out.println("======SINGLETON EXAMPLE====");
/*		SingletonObject so = new SingletonObject();
		SingletonObject so2 = new SingletonObject();*/
		
		System.out.println(SingletonObject.instanceCount);
		
/*		System.out.println(System.identityHashCode(so));
		System.out.println(System.identityHashCode(so2));*/
		
		SingletonObject so3 = SingletonObject.getSingleton();
		SingletonObject so4 = SingletonObject.getSingleton();
		
		System.out.println(SingletonObject.instanceCount);
		
		System.out.println(System.identityHashCode(so3));
		System.out.println(System.identityHashCode(so4));
		
		System.out.println("======FACTORY EXAMPLE=======");
		
		ShapeFactory sf = new ShapeFactory();
		
		Shape s1 = sf.getShape("SqUaRe");
		Shape s2 = sf.getShape("CiRCle");
		Shape s3 = sf.getShape("Triangle");
		
		s1.writeShape();
		s2.writeShape();
		s3.writeShape();
	}

}
