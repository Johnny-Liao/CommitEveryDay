package org.lsh.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecrptClassLoader extends ClassLoader {
	private String rootDir;

	public DecrptClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> c = findLoadedClass(name);
		if (c != null) {
			return c;
		} else {
			// 实现双亲委派机制，先由父类加载器加载，加载不到在自己加载
			ClassLoader parent = this.getParent(); // 获取父类加载器
			try {
				c = parent.loadClass(name); // 委派给父类加载
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (c != null) {
				return c; // 父类加载到了，返回
			} else {
				byte[] classData = getClassData(name);
				if (classData == null) {
					throw new ClassNotFoundException();
				} else {
					c = defineClass(name, classData, 0, classData.length);
				}
			}

		}
		return c;
	}

	private byte[] getClassData(String classname) { // com.bjsxt.test.User
													// d:/myjava/
													// com/bjsxt/test/User.class
		String path = rootDir + "/" + classname.replace('.', '/') + ".class";

		// IOUtils,可以使用它将流中的数据转成字节数组
		InputStream is = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			is = new FileInputStream(path);

			// change here
			int temp = -1;
			while ((temp = is.read()) != -1) {
				baos.write(temp ^ 0xff); // 取反输出
			}

			return baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (baos != null) {
					baos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
