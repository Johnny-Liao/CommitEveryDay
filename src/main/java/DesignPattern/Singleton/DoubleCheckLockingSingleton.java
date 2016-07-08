package DesignPattern.Singleton;

/**
 * Double check locking singleton.
 * Created by johnny on 16-7-8.
 */
public class DoubleCheckLockingSingleton {
    // notice volatile.
    private volatile static DoubleCheckLockingSingleton instance;

    private DoubleCheckLockingSingleton() {}

    public static DoubleCheckLockingSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckLockingSingleton.class) {
                if (instance == null) {
                    return new DoubleCheckLockingSingleton();
                }
            }
        }
        return instance;
    }
}
