package Algorithm.Sort;

import java.util.Arrays;

/**
 * 升级版选择排序，使每次排序时数据交换次数减少为1，即空间复杂度为：O(1)
 * 
 * @author JohnnyLiao
 */
public class SelectSortUpgraded implements Sort {
	
	public static void selectSortUpgrade(DataWrap[] data) {
		System.out.println("升级版选择排序：");
		for (int i = 0; i < data.length -1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < data.length; j++) {
				// ! 注意！！是minIndex位置的数据和j比较 minIndex动态改变
				if (data[minIndex].compareTo(data[j]) > 0) {
					minIndex = j; // 每次排序只为找到位于i后面的最小数
				}
			}
			if (minIndex != i) {
				DataWrap tmp = data[i];
				data[i] = data[minIndex];
				data[minIndex] = tmp;
			}
			System.out.println(Arrays.toString(data));
		}
	}

	@Override
	public void sort(DataWrap[] data) {
		selectSortUpgrade(data);
	}
}
