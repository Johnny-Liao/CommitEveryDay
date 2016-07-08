package DesignPattern.Singleton;

/**
 * The best way to implements Singleton Pattern.
 * Created by johnny on 16-7-8.
 */
public class SingletonInnerClass {

    private SingletonInnerClass() {
    }

    private static class SingletonHelper {
        private static final SingletonInnerClass INSTANCE = new SingletonInnerClass();
    }

    public static SingletonInnerClass getInstance() {
        return new SingletonHelper().INSTANCE;
    }
}
