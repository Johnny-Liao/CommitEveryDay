package org.lsh.nestedclass;

@SuppressWarnings("unused")
public class DemoNestedClass {
	// ��̬�ڲ���

	private static class StaticNestedClassClass {

	}

	// ��ͨ�ڲ���(��Ա�ڲ���)
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
