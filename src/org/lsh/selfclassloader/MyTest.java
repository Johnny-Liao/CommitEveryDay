package org.lsh.selfclassloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Test self define class loader.
 * Demonstration get class by byte code.
 * Created by johnny on 15-9-24.
 */
public class MyTest {
    public static void main(String[] args) throws IOException {
        File file = new File(".");
        String filePathForIDEA = "/out/production/CommitEveryDay/org/lsh/selfclassloader/Programmer.class";
        InputStream input = new FileInputStream(file.getCanonicalPath() + filePathForIDEA);
        byte[] result = new byte[1024];
        int count = input.read(result);

        // Use self define class loader to get
        MyClassLoader myClassLoader = new MyClassLoader();
        Class clazz = myClassLoader.defineMyClass(result, 0, count);

        System.out.println(clazz.getCanonicalName());   // Output the clazz name.

        Object programmer = null;
        try {
             programmer = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            System.out.println("get class instance exception.");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        try {
            Method method = clazz.getMethod("code", null);
            method.invoke(programmer, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
