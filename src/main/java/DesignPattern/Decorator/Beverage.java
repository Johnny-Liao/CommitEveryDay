package DesignPattern.Decorator;

//饮料类-共同的基类(利用继承达到类型匹配，并不是获取行为，可用接口代替)
public abstract class Beverage {
	String description = "Unknow Beverage.";

	public String getDescription() {
		return description;
	}

	public abstract double cost();
}
