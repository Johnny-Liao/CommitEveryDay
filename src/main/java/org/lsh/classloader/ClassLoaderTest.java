package org.lsh.classloader;

//����ClassLoader
public class ClassLoaderTest {
	public static void main(String[] args) {
		System.out.println(ClassLoader.getSystemClassLoader());		//Ӧ�ó������������AppClassLoader
		System.out.println(ClassLoader.getSystemClassLoader().getParent());		//��չ���������ExtClassLoader
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());		//�������������null ԭ�����루C���룩
		
		System.out.println(System.getProperty("java.class.path"));	//�����·���� xxx\bin
		
		//�������ʵ�ֻ��ƣ�˫��ί�л���	�������������   ��ȫ����	(����ģʽ)
	}
}
