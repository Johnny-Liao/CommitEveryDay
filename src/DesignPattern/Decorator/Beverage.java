package DesignPattern.Decorator;

//������-��ͬ�Ļ���(���ü̳дﵽ����ƥ�䣬�����ǻ�ȡ��Ϊ�����ýӿڴ���)
public abstract class Beverage {
	String description = "Unknow Beverage.";

	public String getDescription() {
		return description;
	}

	public abstract double cost();
}
