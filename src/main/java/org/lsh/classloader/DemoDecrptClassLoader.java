package org.lsh.classloader;

public class DemoDecrptClassLoader {

	public static void main(String[] args) throws ClassNotFoundException {
		int a = 3;
		System.out.println(Integer.toBinaryString(a^0xff));
		
		DecrptClassLoader loader = new DecrptClassLoader("D:/aaa");
		Class<?> c = loader.loadClass("EncrptUtil");
		System.out.println(c);
	}

}
