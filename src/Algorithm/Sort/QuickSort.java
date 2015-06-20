package Algorithm.Sort;

import java.util.Arrays;

/**
 * 快速排序：把小分界值的数放左边，大于分界值的数放右边，依次找出分界值的相应位置(一般选取第一个数当分界值)。
 * 
 * @author JohnnyLiao
 */
public class QuickSort {
	
	public static void quickSort(DataWrap[] data) {
		System.out.println("快速排序：");
		subSort(data, 0, data.length - 1);
	}
	
	// 对data从start到end范围内的子序列进行处理
	// 使其满足小于分界值的放于左边，大于分界值的放于右边---选第一个为分界值
	private static void subSort(DataWrap[] data, int start, int end) {
		if (start < end) {
			DataWrap base = data[start];		//分界值
			int i = start;		//++i
			int j = end + 1;	//--j
			while (true) {
				while (i < end && data[++i].compareTo(base) <=0);	// 找出大于分界值的索引，或i已到end处
				while (j > start && data[--j].compareTo(base) >= 0);// 找出小于分界值的索引，或j已到start处
				if (i < j) {				
					swap(data, i, j);
					
				} else {
					break;											// 分界完毕
				}
			}
			swap(data, start, j);	// 把分界值归位
			System.out.println(Arrays.toString(data));
			// 递归左边子序列
			subSort(data, start, j - 1);
			// 递归右边子序列
			subSort(data, j + 1, end);
		}
	}

	private static void swap(DataWrap[] data, int i, int j) {
		DataWrap tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
}
