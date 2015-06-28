package Algorithm.Sort;

import java.util.Arrays;

public class SortTest {
	
	private static DataWrap[] getData() {
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
	
	private static void testDiffSort(Sort sort) {
		DataWrap[] data = getData();
		System.out.println("排序之前：\n" + Arrays.toString(data));
		sort.sort(data);
		System.out.println("排序之后：\n" + Arrays.toString(data));
		System.out.println();
	}

	public static void main(String[] args) {
		
/*		testDiffSort(new SelectSort());
		
		testDiffSort(new SelectSortUpgraded());
		
		testDiffSort(new HeapSort());
		
		testDiffSort(new BubbleSort());
		
		testDiffSort(new QuickSort());
		
		testDiffSort(new InsertSort());
		
		testDiffSort(new BinaryInsertSort());

		testDiffSort(new ShellSort());*/
		
		testDiffSort(new MergeSort());
		
	}
}
