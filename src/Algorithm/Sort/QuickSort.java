package Algorithm.Sort;

import java.util.Arrays;

/**
 * �������򣺰�С�ֽ�ֵ��������ߣ����ڷֽ�ֵ�������ұߣ������ҳ��ֽ�ֵ����Ӧλ��(һ��ѡȡ��һ�������ֽ�ֵ)��
 * 
 * @author JohnnyLiao
 */
public class QuickSort implements Sort {
	
	@Override
	public void sort(DataWrap[] data) {
		quickSort(data);
	}
	
	public static void quickSort(DataWrap[] data) {
		System.out.println("��������");
		subSort(data, 0, data.length - 1);
	}
	
	// ��data��start��end��Χ�ڵ������н��д���
	// ʹ������С�ڷֽ�ֵ�ķ�����ߣ����ڷֽ�ֵ�ķ����ұ�---ѡ��һ��Ϊ�ֽ�ֵ
	private static void subSort(DataWrap[] data, int start, int end) {
		if (start < end) {
			DataWrap base = data[start];		//�ֽ�ֵ
			int i = start;		//++i
			int j = end + 1;	//--j
			while (true) {
				while (i < end && data[++i].compareTo(base) <=0);	// �ҳ����ڷֽ�ֵ����������i�ѵ�end��
				while (j > start && data[--j].compareTo(base) >= 0);// �ҳ�С�ڷֽ�ֵ����������j�ѵ�start��
				if (i < j) {				
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
	}

	private static void swap(DataWrap[] data, int i, int j) {
		DataWrap tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
}
