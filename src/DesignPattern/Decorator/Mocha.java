package DesignPattern.Decorator;

//Ħ��-װ����
public class Mocha extends CondimentDecorator {
	// ʹ��ʵ��������¼��װ����
	Beverage beverage;
	
	public Mocha(Beverage b) {
		beverage = b;
	}
	
	//��������Ϊװ�η���

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

	@Override
	public double cost() {
		return .20 + beverage.cost();
	}

}
