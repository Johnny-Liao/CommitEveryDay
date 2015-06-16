package DesignPattern.Decorator;

//奶泡-装饰器
public class Whip extends CondimentDecorator {
	// 使用实例变量记录被装饰者
	Beverage beverage;
	
	public Whip(Beverage b) {
		beverage = b;
	}
	
	//以下两个为装饰方法

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}

	@Override
	public double cost() {
		return .10 + beverage.cost();
	}

}
