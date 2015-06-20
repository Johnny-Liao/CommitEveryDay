package Algorithm.Sort;

import java.util.Arrays;

public class SortTest {
	
	private static DataWrap[] data() {
		DataWrap[] data = {
				new DataWrap(21, ""),
				new DataWrap(30, ""),
				new DataWrap(49, "*"),
				new DataWrap(30, "*"),
				new DataWrap(16, ""),
				new DataWrap(39, ""),
				new DataWrap(29, ""),
				new DataWrap(19, ""),
				new DataWrap(79, ""),
				new DataWrap(49, "")
		};
		return data;
	}

	public static void main(String[] args) {
		DataWrap[] data = data();
		
		System.out.println("排序之前：\n" + Arrays.toString(data));
		SelectSort.selectSort(data);
		System.out.println("排序之后：\n" + Arrays.toString(data));
		System.out.println();
		
		data = data();
		System.out.println("排序之前：\n" + Arrays.toString(data));
		SelectSortUpgraded.selectSortUpgrade(data);
		System.out.println("排序之后：\n" + Arrays.toString(data));
		System.out.println();
		
		data = data();
		System.out.println("排序之前：\n" + Arrays.toString(data));
		HeapSort.heapSort(data);
		System.out.println("排序之后：\n" + Arrays.toString(data));
		System.out.println();
		
		data = data();
		System.out.println("排序之前：\n" + Arrays.toString(data));
		BubbleSort.bubbleSort(data);
		System.out.println("排序之后：\n" + Arrays.toString(data));
		System.out.println();
		
		data = data();
		System.out.println("排序之前：\n" + Arrays.toString(data));
		QuickSort.quickSort(data);
		System.out.println("排序之后：\n" + Arrays.toString(data));
		System.out.println();
		
		
	}
}
