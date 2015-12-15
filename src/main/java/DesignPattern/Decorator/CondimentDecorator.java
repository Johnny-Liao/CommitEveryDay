package DesignPattern.Decorator;

//所有装饰者的基类-为了能替代Beverage所以继承
public abstract class CondimentDecorator extends Beverage {
	
	public abstract String getDescription();
	
}
