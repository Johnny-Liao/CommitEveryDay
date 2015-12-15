package DesignPattern.Observer;

// 主题对象--被观察者应该实现此接口
public interface Subject {
	public void registerObserver(Observer o);

	public void removeObserver(Observer o);

	public void notifyObserver();
}
