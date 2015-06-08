package org.lsh.singleton;

/**
 * ��������ʽ����ģʽ
 * 
 * @author JohnnyLiao
 */
public class SingletonDemo2 {
	//�ӳټ���(������ʱ�ڼ���)��
	private static SingletonDemo2 instance;	

	private SingletonDemo2() {
	}

	//����ͬ��������Ч�ʵ�
	public static synchronized SingletonDemo2 getInstance() {
		if (instance == null) {
			instance = new SingletonDemo2();
		}
		return instance;
	}
}
