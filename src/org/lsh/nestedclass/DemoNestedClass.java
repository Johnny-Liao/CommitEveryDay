package org.lsh.nestedclass;

/**
 * �����и����ڲ���Ĳ�ͬ�÷�
 * 
 * @author JohnnyLiao
 */
@SuppressWarnings("unused")
public class DemoNestedClass {

	// ��̬(��Ա)�ڲ���
	private static class StaticNestedClassClass {

	}

	// ��ͨ�ڲ���(��Ա�ڲ���/�Ǿ�̬��Ա�ڲ���)
	private class FieldInnerClass {

	}

	void sayHello() {
		// �����ڲ���(�ֲ��ڲ���)
		class LocalClass {

		}

		// �����ڲ���
		Runnable runnable = new Runnable() { // �������ã������������ڲ�������壻�����������ڲ����һ��ʵ����
			@Override
			public void run() {

			}
		};
	}
}
