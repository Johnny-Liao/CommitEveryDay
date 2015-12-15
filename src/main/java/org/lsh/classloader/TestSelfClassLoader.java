package org.lsh.classloader;

public class TestSelfClassLoader {
	public static void main(String[] args) throws ClassNotFoundException {
		FileSystemClassLoader loader = new FileSystemClassLoader("D:/TestClassLoader");
		
		Class<?> c = loader.loadClass("HelloWorld");
		Class<?> c2 = loader.loadClass("java.lang.String");
		Class<?> c3 = loader.loadClass("org.lsh.classloader.TestSelfClassLoader");
		
		System.out.println(c);
		System.out.println(c2);

		System.out.println(c.hashCode());
		System.out.println(c2.hashCode());
		
		//演示父类委派机制
		System.out.println(c.getClassLoader());		//自定义类加载器
		System.out.println(c2.getClassLoader());	//引导类加载器
		System.out.println(c3.getClassLoader());	//默认类加载器 AppClassLoader
		
	}
}
