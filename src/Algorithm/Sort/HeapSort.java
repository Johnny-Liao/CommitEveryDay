package Algorithm.Sort;

import java.util.Arrays;

/**
 * 堆排序：1、构建最大堆或最小堆。2、拿堆的跟节点和最后一个节点交换。
 * 
 * @author JohnnyLiao
 */

public class HeapSort implements Sort {

	public static void heapSort(DataWrap[] data) {
		System.out.println("堆排序：");
		for (int i = 0; i < data.length - 1; i++) {
			buildMaxHeap(data, data.length - 1 - i); // 记住每次减少一个元素
			// 交换堆顶和最后一个元素
			swap(data, 0, data.length - 1 - i);
			System.out.println(Arrays.toString(data));
		}
	}

	private static void buildMaxHeap(DataWrap[] data, int lastIndex) {
		// 从最后一个非叶子节点(lastIndex的父节点)开始
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			// 保存当前正在判断的节点
			int k = i;
			// 存在子节点
			while (2 * k + 1 <= lastIndex) {
				int biggerIndex = 2 * k + 1; // 用于存放子节点的较大者
				// 找出较大的子节点
				if (biggerIndex < lastIndex) {
					// 如果右子节点大
					if (data[biggerIndex + 1].compareTo(data[biggerIndex]) > 0)
						biggerIndex++;
				}

				if (data[biggerIndex].compareTo(data[k]) > 0) {
					swap(data, biggerIndex, k);
					// ! 注意！！！和子节点交换后还要判断交换后会不会破坏子节点的堆性质
					// 所以把biggerIndex赋值给k,开始下一次循环
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
