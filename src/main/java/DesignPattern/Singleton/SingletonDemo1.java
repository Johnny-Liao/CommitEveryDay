package DesignPattern.Singleton;

/**
 * ��������ʽ����ģʽ
 * 
 * @author JohnnyLiao
 */
public class SingletonDemo1 {
	//�ӳټ���(������ʱ�ڼ���)��
	private static SingletonDemo1 instance;	

	private SingletonDemo1() {
	}

	//����ͬ��������Ч�ʵ�
	public static synchronized SingletonDemo1 getInstance() {
		if (instance == null) {
			instance = new SingletonDemo1();
		}
		return instance;
	}
}
