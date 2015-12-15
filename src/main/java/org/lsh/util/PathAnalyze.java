package org.lsh.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 输入文件路径，递归读取路径下所有文件并输出（控制台和指定输出）
 * 
 * @author JohnnyLiao
 * 
 */
public class PathAnalyze {

	private static StringBuilder allNames = new StringBuilder();

	// 递归获取目录下所有文件名
	private static String recursion(File pathName) {
		if (pathName.isDirectory()) {
			for (File f : pathName.listFiles()) {
				if (f.isDirectory()) {
					recursion(f);
				} else {
					allNames.append(f.getName() + "\n");
				}
			}
		} else {
			allNames.append("输入的是文件：" + pathName.getName() + ", 请输入正确的路径名！\n");
		}
		return allNames.toString();
	}

	// 清空，防止多次读取时文件名重复
	private static void clear() {
		allNames.delete(0, allNames.length());
	}

	// 输入字符串，输出到指定文件
	private static void sendTextToFile(String fileName, String text) throws IOException {
		PrintWriter out = new PrintWriter(fileName);
		out.print(text);
		out.close();
		clear();
	}

	// 读取文件路径下文件名，并输出到指定文件中
	public static void readPathAndSendToFile(String fileName, String dist) throws IOException {
		String text = recursion(new File(fileName));
		sendTextToFile(dist, text);
	}

	// 读取文件路劲下文件名输出
	public static void readPathAndPrint(String pathName) {
		System.out.println(recursion(new File(pathName)));
		clear();
	}

}
