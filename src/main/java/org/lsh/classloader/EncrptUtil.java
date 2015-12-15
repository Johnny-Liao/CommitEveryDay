package org.lsh.classloader;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 加密工具类
 * 
 * @author JohnnyLiao
 */
public class EncrptUtil {
	public static void enctpt(String src, String dest) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dest);

			int temp = -1;
			while ((temp = fis.read()) != -1) {
				fos.write(temp ^ 0xff); // 取反输出
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		EncrptUtil.enctpt("D:/eclipse/javaworkspace_64/MyTest/bin/org/lsh/classloader/EncrptUtil.class", "D:/EncrptUtil.class");
	}
}
