package DesignPattern.StrategyPattern;

public abstract class Duck {
	//Ϊ��Ϊ�ӿ�����������������
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;

	public Duck() {
	}

	public abstract void display();

	public void performFly() {
		flyBehavior.fly();		//ί�и���Ϊ��
	}

	public void performQuack() {
		quackBehavior.quack();	//ί�и���Ϊ��
	}

	public void swing() {
		System.out.println("All ducks float.");
	}
	
	//��̬�趨��Ϊ
	public void setFlyBehavior(FlyBehavior fb) {
		flyBehavior = fb;
	}
	
	public void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}

}
