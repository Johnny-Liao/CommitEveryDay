package DesignPattern.Observer;

// 观察者接口--就此例所有气象组件都应该实现此接口
public interface Observer {
	
	public void update(float temp, float humidity, float pressure);
	
}
