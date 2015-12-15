package Algorithm.Sort;

import java.util.Arrays;

/**
 * 快速排序：把小分界值的数放左边，大于分界值的数放右边，依次找出分界值的相应位置(一般选取第一个数当分界值)。
 * 
 * @author JohnnyLiao
 */
public class QuickSort_MyTest {
	
	// 保持统一调用方式
	public static void quickSort(DataWrap[] data) {
		quickSort(data, 0, data.length -1);
	}

	private static void quickSort(DataWrap[] data, int p, int r) {
		if (p < r) {
			int q = patision(data, p, r);
			quickSort(data, p, q - 1);
			quickSort(data, q + 1, r);
		}
	}
	
	/**
	 * 这种是算法导论中的思想：for (j = start + 1 ..... end)<br> 
	 * 如果j小于分界值 i(start + 1 ...), i 和 j 互换, i++<br>
	 * 从而（...i+1）小于分界值(j...end)大于分界值<br>
	 * @param data 要排序的数据集合
	 * @param start 排序的首址
	 * @param end 排序的尾址
	 * @return 分界值的地址
	 */
	private static int patision(DataWrap[] data, int start, int end) {
		DataWrap base = data[start];		
		int i = start + 1;
		int j;
		for (j = start + 1; j <= end; j++) {
			if (data[j].compareTo(base) < 0) {			
				swap(data, i, j);
				i = i + 1;
			}
		}
		swap(data, start, i - 1);		// 和刚好比它小的那个数交换
		System.out.println(Arrays.toString(data));
		return i - 1;
	}

	private static void swap(DataWrap[] data, int i, int j) {
		DataWrap tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
	
	private static DataWrap[] data() {
		DataWrap[] data = {
				new DataWrap(21, ""),
				new DataWrap(30, ""),
				new DataWrap(49, "*"),
				new DataWrap(30, "*"),
				new DataWrap(16, ""),
				new DataWrap(19, ""),
				new DataWrap(29, ""),
				new DataWrap(49, ""),
				new DataWrap(9, "")
		};
		return data;
	}
	
	public static void main(String[] args) {
		DataWrap[] data = data();
		System.out.println("排序前");
		System.out.println(Arrays.toString(data));
		System.out.println("算法导论-快速排序：");
		QuickSort_MyTest.quickSort(data);
		System.out.println("排序后：");
		System.out.println(Arrays.toString(data));
	}
	

}
