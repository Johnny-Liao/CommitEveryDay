package org.lsh.nestedclass;

/**
 * 简单罗列各种内部类的不同用法
 * 
 * @author JohnnyLiao
 */
@SuppressWarnings("unused")
public class DemoNestedClass {

	// 静态内部类
	private static class StaticNestedClassClass {

	}

	// 普通内部类(成员内部类)
	private class FieldInnerClass {

	}

	void sayHello() {
		// 方法内部类(局部内部类)
		class LocalClass {

		}

		// 匿名内部类
		Runnable runnable = new Runnable() { // 两个作用：定义了匿名内部类的类体；创建了匿名内部类的一个实例！
			@Override
			public void run() {

			}
		};
	}
}
