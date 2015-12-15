package DesignPattern.Observer;

public class CurrentConditionDisplay implements DisplayElement, Observer {
	private float temperature;
	private float humidity;
	private Subject weatherData;
	
	// 构造器使用WeatherData对象作为注册之用
	public CurrentConditionDisplay(WeatherData w) {
		this.weatherData = w;
		weatherData.registerObserver(this);		//自身注册为气象站的观察者
	}
	
	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temperature = temp;
		this.humidity = humidity;
		display();
	}

	@Override
	public void display() {
		System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% hunidity");
	}

}
