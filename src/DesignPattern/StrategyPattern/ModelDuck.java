package DesignPattern.StrategyPattern;

//ÂÌÍ·Ñ¼
public class ModelDuck extends Duck {
	
	public ModelDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyNoWay();
	}

	@Override
	public void display() {
		System.out.println("I'm a model duck");
	}

}
