package DesignPattern.Template;

public class Tea extends CaffeineBeverage {

	void brew() {
		System.out.println("Steeping the tea");
	}

	void addCondiments() {
		System.out.println("Adding Lemon");
	}

}
