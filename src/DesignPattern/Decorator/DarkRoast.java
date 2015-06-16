package DesignPattern.Decorator;

//…Ó±∫øß∑»
public class DarkRoast extends Beverage {
	
	public DarkRoast() {
		description = "DarkRoast";
	}

	@Override
	public double cost() {
		return .99;
	}

}
