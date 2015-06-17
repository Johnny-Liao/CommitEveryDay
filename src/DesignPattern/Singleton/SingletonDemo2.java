package DesignPattern.Singleton;

/**
 * ���Զ���ʽ����ģʽ
 * 
 * @author JohnnyLiao
 */
public class SingletonDemo2 {
	//���ʼ��ʱ����������(û���ӳټ��ص�����)�����ڼ�����ʱ��Ȼ���̰߳�ȫ�ġ�
	private static SingletonDemo2 instance = new SingletonDemo2();	

	private SingletonDemo2() {
	}

	public static SingletonDemo2 getInstance() {
		return instance;
	}
}
