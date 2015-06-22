package Algorithm.Sort;

import java.util.Arrays;

/**
 * 冒泡排序：相邻两数据两两比较，把大数如泡泡般冒泡到最后；如果哪趟没发生交换则可提前结束。
 * 
 * @author JohnnyLiao
 */
public class BubbleSort implements Sort {

	@Override
	public void sort(DataWrap[] data) {
		bubbleSort(data);
	}
	
	public static void bubbleSort(DataWrap[] data) {
		System.out.println("冒泡排序：");
		for (int i = 0; i < data.length - 1; i++) {
			boolean flag = false; // 用于判断此趟比较有没有发生交换
			for (int j = 0; j < data.length - 1 - i; j++) {
				if (data[j].compareTo(data[j + 1]) > 0) {
					// 交换
					DataWrap tmp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = tmp;
					flag = true;
				}
			}
			System.out.println(Arrays.toString(data));
			if (!flag) {
				break;
			}
		}
	}
	
}
