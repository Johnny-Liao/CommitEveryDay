package DesignPattern.Singleton;

import java.io.Serializable;

/**
 * Sometime in distributed systems, we need to implement Serializable interface in Singleton class.
 * Created by johnny on 16-7-8.
 */
public class SerializedSingleton implements Serializable {
    private static final long serialVersionUID = 3973835013585169467L;

    private SerializedSingleton() {
    }

    private static class SingletonHelper {
        private static final SerializedSingleton INSTANCE = new SerializedSingleton();
    }

    public static SerializedSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    // To solve the problem of inconsistent deserialization
    protected Object readResolve() {
        return getInstance();
    }
}
