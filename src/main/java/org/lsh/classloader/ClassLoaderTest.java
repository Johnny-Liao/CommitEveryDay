package org.lsh.classloader;

//测试ClassLoader
public class ClassLoaderTest {
	public static void main(String[] args) {
		System.out.println(ClassLoader.getSystemClassLoader());		//应用程序类加载器：AppClassLoader
		System.out.println(ClassLoader.getSystemClassLoader().getParent());		//扩展类加载器：ExtClassLoader
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());		//引导类加载器：null 原生代码（C代码）
		
		System.out.println(System.getProperty("java.class.path"));	//类加载路径： xxx\bin
		
		//类加载器实现机制：双亲委托机制	父类加载器优先   安全优先	(代理模式)
	}
}
