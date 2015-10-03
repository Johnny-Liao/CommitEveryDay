package org.lsh.selfclassloader;

/**
 * Created by johnny on 15-9-24.
 */
public class MyClassLoader extends ClassLoader {

    public Class<?> defineMyClass(byte[] b, int off, int len) {
        return super.defineClass(b, off, len);
    }
}
