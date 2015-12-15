package org.lsh.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * �����ļ�·�����ݹ��ȡ·���������ļ������������̨��ָ�������
 * 
 * @author JohnnyLiao
 * 
 */
public class PathAnalyze {

	private static StringBuilder allNames = new StringBuilder();

	// �ݹ��ȡĿ¼�������ļ���
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
			allNames.append("��������ļ���" + pathName.getName() + ", ��������ȷ��·������\n");
		}
		return allNames.toString();
	}

	// ��գ���ֹ��ζ�ȡʱ�ļ����ظ�
	private static void clear() {
		allNames.delete(0, allNames.length());
	}

	// �����ַ����������ָ���ļ�
	private static void sendTextToFile(String fileName, String text) throws IOException {
		PrintWriter out = new PrintWriter(fileName);
		out.print(text);
		out.close();
		clear();
	}

	// ��ȡ�ļ�·�����ļ������������ָ���ļ���
	public static void readPathAndSendToFile(String fileName, String dist) throws IOException {
		String text = recursion(new File(fileName));
		sendTextToFile(dist, text);
	}

	// ��ȡ�ļ�·�����ļ������
	public static void readPathAndPrint(String pathName) {
		System.out.println(recursion(new File(pathName)));
		clear();
	}

}
