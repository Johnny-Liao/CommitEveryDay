package DesignPattern.StrategyPattern;

public abstract class Duck {
	//为行为接口类型声明两个变量
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;

	public Duck() {
	}

	public abstract void display();

	public void performFly() {
		flyBehavior.fly();		//委托给行为类
	}

	public void performQuack() {
		quackBehavior.quack();	//委托给行为类
	}

	public void swing() {
		System.out.println("All ducks float.");
	}
	
	//动态设定行为
	public void setFlyBehavior(FlyBehavior fb) {
		flyBehavior = fb;
	}
	
	public void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}

}
