package Algorithm.Sort;

import java.util.Arrays;

/**
 * ������1���������ѻ���С�ѡ�2���öѵĸ��ڵ�����һ���ڵ㽻����
 * 
 * @author JohnnyLiao
 */

public class HeapSort implements Sort {

	public static void heapSort(DataWrap[] data) {
		System.out.println("������");
		for (int i = 0; i < data.length - 1; i++) {
			buildMaxHeap(data, data.length - 1 - i); // ��סÿ�μ���һ��Ԫ��
			// �����Ѷ������һ��Ԫ��
			swap(data, 0, data.length - 1 - i);
			System.out.println(Arrays.toString(data));
		}
	}

	private static void buildMaxHeap(DataWrap[] data, int lastIndex) {
		// �����һ����Ҷ�ӽڵ�(lastIndex�ĸ��ڵ�)��ʼ
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			// ���浱ǰ�����жϵĽڵ�
			int k = i;
			// �����ӽڵ�
			while (2 * k + 1 <= lastIndex) {
				int biggerIndex = 2 * k + 1; // ���ڴ���ӽڵ�Ľϴ���
				// �ҳ��ϴ���ӽڵ�
				if (biggerIndex < lastIndex) {
					// ������ӽڵ��
					if (data[biggerIndex + 1].compareTo(data[biggerIndex]) > 0)
						biggerIndex++;
				}

				if (data[biggerIndex].compareTo(data[k]) > 0) {
					swap(data, biggerIndex, k);
					// ! ע�⣡�������ӽڵ㽻����Ҫ�жϽ�����᲻���ƻ��ӽڵ�Ķ�����
					// ���԰�biggerIndex��ֵ��k,��ʼ��һ��ѭ��
					k = biggerIndex;
				} else
					break;
			}
		}
	}

	private static void swap(DataWrap[] data, int start, int end) {
		DataWrap tmp = data[start];
		data[start] = data[end];
		data[end] = tmp;
	}

	@Override
	public void sort(DataWrap[] data) {
		heapSort(data);
	}
}
