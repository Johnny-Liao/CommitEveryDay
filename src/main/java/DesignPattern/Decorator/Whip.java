package DesignPattern.Decorator;

//����-װ����
public class Whip extends CondimentDecorator {
	// ʹ��ʵ��������¼��װ����
	Beverage beverage;
	
	public Whip(Beverage b) {
		beverage = b;
	}
	
	//��������Ϊװ�η���

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}

	@Override
	public double cost() {
		return .10 + beverage.cost();
	}

}
