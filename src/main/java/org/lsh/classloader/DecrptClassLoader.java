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
			// ʵ��˫��ί�ɻ��ƣ����ɸ�����������أ����ز������Լ�����
			ClassLoader parent = this.getParent(); // ��ȡ���������
			try {
				c = parent.loadClass(name); // ί�ɸ��������
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (c != null) {
				return c; // ������ص��ˣ�����
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

		// IOUtils,����ʹ���������е�����ת���ֽ�����
		InputStream is = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			is = new FileInputStream(path);

			// change here
			int temp = -1;
			while ((temp = is.read()) != -1) {
				baos.write(temp ^ 0xff); // ȡ�����
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
