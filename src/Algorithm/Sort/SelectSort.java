package Algorithm.Sort;

import java.util.Arrays;

/**
 * ѡ������ÿ��ѡ�����С��Ԫ�أ����η�����ǰ��
 * 
 * @author JohnnyLiao
 * 
 */
public class SelectSort implements Sort {

	public static void selectSort(DataWrap[] data) {
		System.out.println("ѡ������");
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[i].compareTo(data[j]) > 0) {
					DataWrap temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
			// ÿ���������һ�Σ����ڲ鿴�������
			System.out.println(Arrays.toString(data));
		}
	}

	@Override
	public void sort(DataWrap[] data) {
		selectSort(data);
	}

}
