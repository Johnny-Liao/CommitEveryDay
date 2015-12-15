package org.lsh.singleton;

public class SingletonTest {
	public static void main(String[] args) {
		SingletonDemo1 singlet1 = SingletonDemo1.getInstance(); 
		SingletonDemo1 singlet2 = SingletonDemo1.getInstance();
		System.out.println(singlet1 == singlet2);
		
		SingletonDemo2 singlet3 = SingletonDemo2.getInstance(); 
		SingletonDemo2 singlet4 = SingletonDemo2.getInstance();
		System.out.println(singlet3 == singlet4);
	}
}
