package DesignPattern.Factory;

/**
 * ���������꣬�Ժ������ͬ������������̳д˳���꣬�������Ե�����
 * @author JohnnyLiao
 *
 */
public abstract class PizzaStore {

	public Pizza orderPizza(String type) {
		Pizza pizza;

		// �����Pizza�������ʼ��
		pizza = createPizza(type);

		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;
	}

	// ��������--��������ʵ��
	abstract Pizza createPizza(String type);
}
