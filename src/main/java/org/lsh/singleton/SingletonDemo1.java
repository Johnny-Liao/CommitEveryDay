package org.lsh.singleton;

/**
 * 测试饿汉式单例模式
 * 
 * @author JohnnyLiao
 */
public class SingletonDemo1 {
	//类初始化时，立即加载(没有延迟加载的优势)。由于加载类时天然的线程安全的。
	private static SingletonDemo1 instance = new SingletonDemo1();	

	private SingletonDemo1() {
	}

	public static SingletonDemo1 getInstance() {
		return instance;
	}
}
