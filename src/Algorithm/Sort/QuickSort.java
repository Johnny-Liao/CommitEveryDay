package Algorithm.Sort;

import java.util.Arrays;

/**
 * �������򣺰�С�ֽ�ֵ��������ߣ����ڷֽ�ֵ�������ұߣ������ҳ��ֽ�ֵ����Ӧλ��(һ��ѡȡ��һ�������ֽ�ֵ)��
 * 
 * @author JohnnyLiao
 */
public class QuickSort {
	
	public static DataWrap[] data() {
		DataWrap[] data = {
				new DataWrap(21, ""),
				new DataWrap(30, ""),
				new DataWrap(49, ""),
				new DataWrap(30, "*"),
				new DataWrap(16, ""),
				new DataWrap(9, "")
		};
		return data;
	}
	
	public static void main(String[] args) {
		DataWrap[] data = data();
		QuickSort.quickSort(data, 0, data.length -1);
	}

	public static void quickSort(DataWrap[] data, int p, int r) {
//		System.out.println("��������");
//		subSort(data, 0, data.length - 1);
		if (p < r) {
			int q = patision(data, p, r);
			quickSort(data, p, q - 1);
			quickSort(data, q + 1, r);
		}
	}
	
	/**
	 * Ҫ���ˡ������������ŵļ���ԭ�����ˣ�����ʵ��ʱ���ǳ�����û�߼�����ĸо���������
	 * �������㷨�����е�˼�룺for (j = start + 1 ..... end) ���jС�ڵ�һ��Ԫ��(�ֽ�ֵ) i(start + 1 ...) �� j ���� i++
	 * �Ӷ���...i+1��С�ڷֽ�ֵ(j...end)���ڷֽ�ֵ
	 * @param data
	 * @param start
	 * @param end
	 * @return
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
		swap(data, start, i - 1);		// �ͱ���С���Ǹ�������
		System.out.println(Arrays.toString(data));
		return i - 1;
	}

/*	// ��data��start��end��Χ�ڵ������н��д���
	// ʹ������С�ڷֽ�ֵ�ķ�����ߣ����ڷֽ�ֵ�ķ����ұ�---ѡ��һ��Ϊ�ֽ�ֵ
	private static void subSort(DataWrap[] data, int start, int end) {
		if (start < end) {
			DataWrap base = data[start];		//�ֽ�ֵ
			int i = start;		//++i
			int j = end + 1;	//--j
			while (true) {
				while (i < end && data[++i].compareTo(base) <=0);	// �ҳ����ڷֽ�ֵ����������i�ѵ�end��
				while (j > start && data[--j].compareTo(base) >= 0);// �ҳ�С�ڷֽ�ֵ����������j�ѵ�start��
				System.out.println( i + "   " + j);
				if (i < j) {				//##################�д��������
					swap(data, i, j);
					
				} else {
					break;											// �ֽ����
				}
			}
			swap(data, start, j);	// �ѷֽ�ֵ��λ
			System.out.println(Arrays.toString(data));
			// �ݹ����������
			subSort(data, start, j - 1);
			// �ݹ��ұ�������
			subSort(data, j + 1, end);
		}
	}*/

	private static void swap(DataWrap[] data, int i, int j) {
		DataWrap tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
}
