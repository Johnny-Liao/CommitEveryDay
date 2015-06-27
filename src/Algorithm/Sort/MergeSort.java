package Algorithm.Sort;

import java.util.Arrays;

public class MergeSort implements Sort {

	@Override
	public void sort(DataWrap[] data) {
		mergeSort(data);
	}
	
	public static void mergeSort(DataWrap[] data) {
		System.out.println("�鲢����");
		resolve(data, 0, data.length - 1);
	}
	
	// �ֽ�ԭ����-�ݹ�鲢����
	private static void resolve(DataWrap[] data, int left, int right) {
		if (left < right) {
			int center = (left + right) / 2;
			resolve(data, left, center);
			resolve(data, center + 1, left);
			
			merge(data, left, center, right);
			
			System.out.println(Arrays.toString(data));
		}
	}
	
	/**
	 * ������������й鲢���鲢ǰ��������ֱ����򣬹鲢����������
	 * @param data �������
	 * @param left �������һ��Ԫ������
	 * @param center ���������һ��Ԫ�����������������һ��Ԫ������-1
	 * @param right ���������һ������
	 */
	private static void merge(DataWrap[] data, int left, int center, int right) {
		DataWrap[] tmpArr = new DataWrap[data.length];
		int rightIndex = center + 1;
		// �м����������
		int tmpIndex = left;
		while (left <= center && rightIndex <= right) {
			// �������н�С�߷�����ʱ����
			if (data[left].compareTo(data[rightIndex]) <= 0) {
				tmpArr[tmpIndex++] = data[left++];
			} else {
				tmpArr[tmpIndex++] = data[rightIndex++];
			}
		}
		// ʣ�ಿ�����η�������
		while (rightIndex <= right) {
			tmpArr[tmpIndex++] = data[rightIndex++]; 
		}
		while (left <= center) {
			tmpArr[tmpIndex++] = data[left++];
		}
		// ���м������е����ݸ��ƻ�ԭ����
		int tmp = left;
		while (tmp <= right) {
			data[tmp] = tmpArr[tmp++];
		}
	} 

}
