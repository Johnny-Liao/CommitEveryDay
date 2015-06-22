package DesignPattern.Template;

public class BeverageTestDrive {
	public static void main(String[] args) {
		Tea tea = new Tea();
		Coffee coffee = new Coffee();
		
		System.out.println("Making tea...");
		tea.prepareRecipe();
		
		System.out.println("\nMaking coffee...");
		coffee.prepareRecipe();
	}
}
