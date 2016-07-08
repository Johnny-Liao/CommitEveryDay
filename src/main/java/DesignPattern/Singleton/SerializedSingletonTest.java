package DesignPattern.Singleton;

import java.io.*;

/**
 * Test deserialized Singleton is worked.
 * Created by johnny on 16-7-8.
 */
public class SerializedSingletonTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializedSingleton instanceOne = SerializedSingleton.getInstance();

        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
        out.writeObject(instanceOne);
        out.close();

        ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
        SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
        in.close();

        System.out.println("Instance one haseCode : " + instanceOne.hashCode());
        System.out.println("Instance two haseCode : " + instanceTwo.hashCode());
    }
}
