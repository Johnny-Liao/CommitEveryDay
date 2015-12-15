package Algorithm.Sort;

import java.util.Arrays;

/**
 * 选择排序：每次选择出最小的元素，依次放在最前面
 * 
 * @author JohnnyLiao
 * 
 */
public class SelectSort implements Sort {

	public static void selectSort(DataWrap[] data) {
		System.out.println("选择排序：");
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[i].compareTo(data[j]) > 0) {
					DataWrap temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
			// 每次排序输出一次，便于查看排序过程
			System.out.println(Arrays.toString(data));
		}
	}

	@Override
	public void sort(DataWrap[] data) {
		selectSort(data);
	}

}
