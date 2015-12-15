package DesignPattern.Factory;

import java.util.ArrayList;

/**
 * 以后各种各样的披萨都从此类继承，实现不同风味的披萨
 * @author JohnnyLiao
 */

@SuppressWarnings(value = { "unused", "rawtypes" })
public abstract class Pizza {
	private String name;
	private String dough;
	private String sauce;
	ArrayList toppings = new ArrayList();

	void prepare() {
		System.out.println("Preparing " + name);
		System.out.println("Tossing dough...");
		System.out.println("Adding sauce...");
		System.out.println("Adding toppings: ");
		for (int i = 0; i < toppings.size(); i++) {
			System.out.println("   " + toppings.get(i));
		}
	}

	void bake() {
		System.out.println("Back for 25 minutes at 350");
	}

	void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	}

	void box() {
		System.out.println("Place pizza in offcial PizzaStore box");
	}

	public String getName() {
		return name;
	}

}
