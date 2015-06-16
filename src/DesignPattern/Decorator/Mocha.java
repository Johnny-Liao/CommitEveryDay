package DesignPattern.Decorator;

//摩卡-装饰器
public class Mocha extends CondimentDecorator {
	// 使用实例变量记录被装饰者
	Beverage beverage;
	
	public Mocha(Beverage b) {
		beverage = b;
	}
	
	//以下两个为装饰方法

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

	@Override
	public double cost() {
		return .20 + beverage.cost();
	}

}
