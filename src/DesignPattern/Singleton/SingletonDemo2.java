package DesignPattern.Singleton;

/**
 * 测试饿汉式单例模式
 * 
 * @author JohnnyLiao
 */
public class SingletonDemo2 {
	//类初始化时，立即加载(没有延迟加载的优势)。由于加载类时天然的线程安全的。
	private static SingletonDemo2 instance = new SingletonDemo2();	

	private SingletonDemo2() {
	}

	public static SingletonDemo2 getInstance() {
		return instance;
	}
}
