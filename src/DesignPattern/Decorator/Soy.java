package DesignPattern.Decorator;

//豆浆-装饰器
public class Soy extends CondimentDecorator {
	// 使用实例变量记录被装饰者
	Beverage beverage;
	
	public Soy(Beverage b) {
		beverage = b;
	}
	
	//以下两个为装饰方法

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	@Override
	public double cost() {
		return .15 + beverage.cost();
	}

}
