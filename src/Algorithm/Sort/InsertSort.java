package Algorithm.Sort;

import java.util.Arrays;

public class InsertSort implements Sort {

	public static void insertSort(DataWrap[] data) {
		System.out.println("插入排序：");
		for (int i = 1; i < data.length; i++) {		// 界限+1
			DataWrap tmp = data[i];
			// data[i] >= data[i - 1] 已经有序无需排序
			if (data[i].compareTo(data[i - 1]) < 0) {
				int j = i - 1;
				while (j >= 0 && data[j].compareTo(tmp) > 0) {
					data[j + 1] = data[j];
					j--;
				}
				data[j + 1] = tmp;
			}
			System.out.println(Arrays.toString(data));
		}
	}

	@Override
	public void sort(DataWrap[] data) {
		insertSort(data);
	}

}