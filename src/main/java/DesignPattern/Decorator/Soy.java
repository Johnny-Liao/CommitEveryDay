package DesignPattern.Decorator;

//����-װ����
public class Soy extends CondimentDecorator {
	// ʹ��ʵ��������¼��װ����
	Beverage beverage;
	
	public Soy(Beverage b) {
		beverage = b;
	}
	
	//��������Ϊװ�η���

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	@Override
	public double cost() {
		return .15 + beverage.cost();
	}

}
