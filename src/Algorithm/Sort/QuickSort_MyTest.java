package Algorithm.Sort;

import java.util.Arrays;

/**
 * �������򣺰�С�ֽ�ֵ��������ߣ����ڷֽ�ֵ�������ұߣ������ҳ��ֽ�ֵ����Ӧλ��(һ��ѡȡ��һ�������ֽ�ֵ)��
 * 
 * @author JohnnyLiao
 */
public class QuickSort_MyTest {
	
	// ����ͳһ���÷�ʽ
	public static void quickSort(DataWrap[] data) {
		quickSort(data, 0, data.length -1);
	}

	private static void quickSort(DataWrap[] data, int p, int r) {
		if (p < r) {
			int q = patision(data, p, r);
			quickSort(data, p, q - 1);
			quickSort(data, q + 1, r);
		}
	}
	
	/**
	 * �������㷨�����е�˼�룺for (j = start + 1 ..... end)<br> 
	 * ���jС�ڷֽ�ֵ i(start + 1 ...), i �� j ����, i++<br>
	 * �Ӷ���...i+1��С�ڷֽ�ֵ(j...end)���ڷֽ�ֵ<br>
	 * @param data Ҫ��������ݼ���
	 * @param start �������ַ
	 * @param end �����βַ
	 * @return �ֽ�ֵ�ĵ�ַ
	 */
	private static int patision(DataWrap[] data, int start, int end) {
		DataWrap base = data[start];		
		int i = start + 1;
		int j;
		for (j = start + 1; j <= end; j++) {
			if (data[j].compareTo(base) < 0) {			
				swap(data, i, j);
				i = i + 1;
			}
		}
		swap(data, start, i - 1);		// �͸պñ���С���Ǹ�������
		System.out.println(Arrays.toString(data));
		return i - 1;
	}

	private static void swap(DataWrap[] data, int i, int j) {
		DataWrap tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
	
	private static DataWrap[] data() {
		DataWrap[] data = {
				new DataWrap(21, ""),
				new DataWrap(30, ""),
				new DataWrap(49, "*"),
				new DataWrap(30, "*"),
				new DataWrap(16, ""),
				new DataWrap(19, ""),
				new DataWrap(29, ""),
				new DataWrap(49, ""),
				new DataWrap(9, "")
		};
		return data;
	}
	
	public static void main(String[] args) {
		DataWrap[] data = data();
		System.out.println("����ǰ");
		System.out.println(Arrays.toString(data));
		System.out.println("�㷨����-��������");
		QuickSort_MyTest.quickSort(data);
		System.out.println("�����");
		System.out.println(Arrays.toString(data));
	}
	

}
