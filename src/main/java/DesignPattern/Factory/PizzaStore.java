package DesignPattern.Factory;

/**
 * 抽象披萨店，以后各个不同地区的披萨店继承此抽象店，生产各自的披萨
 * @author JohnnyLiao
 *
 */
public abstract class PizzaStore {

	public Pizza orderPizza(String type) {
		Pizza pizza;

		// 具体的Pizza由子类初始化
		pizza = createPizza(type);

		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;
	}

	// 工厂方法--留给子类实现
	abstract Pizza createPizza(String type);
}
