package org.lsh.singleton;

/**
 * ���Զ���ʽ����ģʽ
 * 
 * @author JohnnyLiao
 */
public class SingletonDemo1 {
	//���ʼ��ʱ����������(û���ӳټ��ص�����)�����ڼ�����ʱ��Ȼ���̰߳�ȫ�ġ�
	private static SingletonDemo1 instance = new SingletonDemo1();	

	private SingletonDemo1() {
	}

	public static SingletonDemo1 getInstance() {
		return instance;
	}
}
