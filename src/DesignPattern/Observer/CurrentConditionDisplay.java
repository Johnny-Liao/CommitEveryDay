package DesignPattern.Observer;

public class CurrentConditionDisplay implements DisplayElement, Observer {
	private float temperature;
	private float humidity;
	private Subject weatherData;
	
	// ������ʹ��WeatherData������Ϊע��֮��
	public CurrentConditionDisplay(WeatherData w) {
		this.weatherData = w;
		weatherData.registerObserver(this);		//����ע��Ϊ����վ�Ĺ۲���
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
