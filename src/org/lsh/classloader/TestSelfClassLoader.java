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
		
		//��ʾ����ί�ɻ���
		System.out.println(c.getClassLoader());		//�Զ����������
		System.out.println(c2.getClassLoader());	//�����������
		System.out.println(c3.getClassLoader());	//Ĭ��������� AppClassLoader
		
	}
}
