package DesignPattern.Singleton;

/**
 * Implements Singleton Pattern with Enum class.
 *      Can't be destroy by Reflection and does not allow lazy initialization.
 * Created by johnny on 16-7-8.
 */
public enum EnumSingleton {
    INSTANCE;

    public static void doSomething() {
        // do something
    }

}
