package org.lsh.singleton;

/**
 * 测试懒汉式单例模式
 * 
 * @author JohnnyLiao
 */
public class SingletonDemo2 {
	//延迟加载(真正用时在加载)。
	private static SingletonDemo2 instance;	

	private SingletonDemo2() {
	}

	//方法同步，调用效率低
	public static synchronized SingletonDemo2 getInstance() {
		if (instance == null) {
			instance = new SingletonDemo2();
		}
		return instance;
	}
}
