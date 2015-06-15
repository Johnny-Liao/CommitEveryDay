package DesignPattern.Observer;

public class WeatherStation {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();

		// 此处可以生成多种布告板(观察者)
		@SuppressWarnings("unused")
		CurrentConditionDisplay current = new CurrentConditionDisplay(weatherData);

		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(83, 70, 38.4f);
		weatherData.setMeasurements(70, 62, 29.4f);
	}
}
