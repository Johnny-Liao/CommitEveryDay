package DesignPattern.Singleton;

/**
 * 测试懒汉式单例模式
 * 
 * @author JohnnyLiao
 */
public class SingletonDemo1 {
	//延迟加载(真正用时在加载)。
	private static SingletonDemo1 instance;	

	private SingletonDemo1() {
	}

	//方法同步，调用效率低
	public static synchronized SingletonDemo1 getInstance() {
		if (instance == null) {
			instance = new SingletonDemo1();
		}
		return instance;
	}
}
