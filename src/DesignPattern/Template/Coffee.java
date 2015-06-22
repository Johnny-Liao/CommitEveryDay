package DesignPattern.Template;

public class Coffee extends CaffeineBeverage {

	void brew() {
		System.out.println("Dripping Coffee through filter");
	}

	void addCondiments() {
		System.out.println("Adding Sugar and Milk");
	}

}
