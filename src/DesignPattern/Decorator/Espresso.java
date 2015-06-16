package DesignPattern.Decorator;

//Å¨Ëõ¿§·È
public class Espresso extends Beverage {

	public Espresso() {
		description = "Espresso";
	}
	
	@Override
	public double cost() {
		return 1.99;
	}

}
