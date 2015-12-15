package DesignPattern.Observer;

// �������--���۲���Ӧ��ʵ�ִ˽ӿ�
public interface Subject {
	public void registerObserver(Observer o);

	public void removeObserver(Observer o);

	public void notifyObserver();
}
