package Algorithm.Sort;

import java.util.Arrays;

/**
 * 快速排序：把小分界值的数放左边，大于分界值的数放右边，依次找出分界值的相应位置(一般选取第一个数当分界值)。
 * 
 * @author JohnnyLiao
 */
public class QuickSort {
	
	public static DataWrap[] data() {
		DataWrap[] data = {
				new DataWrap(21, ""),
				new DataWrap(30, ""),
				new DataWrap(49, ""),
				new DataWrap(30, "*"),
				new DataWrap(16, ""),
				new DataWrap(9, "")
		};
		return data;
	}
	
	public static void main(String[] args) {
		DataWrap[] data = data();
		QuickSort.quickSort(data, 0, data.length -1);
	}

	public static void quickSort(DataWrap[] data, int p, int r) {
//		System.out.println("快速排序：");
//		subSort(data, 0, data.length - 1);
		if (p < r) {
			int q = patision(data, p, r);
			quickSort(data, p, q - 1);
			quickSort(data, q + 1, r);
		}
	}
	
	/**
	 * 要疯了。。。。。快排的几种原理都懂了，但是实现时总是出错！！没逻辑错误的感觉，，，，
	 * 这种是算法导论中的思想：for (j = start + 1 ..... end) 如果j小于第一个元素(分界值) i(start + 1 ...) 和 j 互换 i++
	 * 从而（...i+1）小于分界值(j...end)大于分界值
	 * @param data
	 * @param start
	 * @param end
	 * @return
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
		swap(data, start, i - 1);		// 和比它小的那个数交换
		System.out.println(Arrays.toString(data));
		return i - 1;
	}

/*	// 对data从start到end范围内的子序列进行处理
	// 使其满足小于分界值的放于左边，大于分界值的放于右边---选第一个为分界值
	private static void subSort(DataWrap[] data, int start, int end) {
		if (start < end) {
			DataWrap base = data[start];		//分界值
			int i = start;		//++i
			int j = end + 1;	//--j
			while (true) {
				while (i < end && data[++i].compareTo(base) <=0);	// 找出大于分界值的索引，或i已到end处
				while (j > start && data[--j].compareTo(base) >= 0);// 找出小于分界值的索引，或j已到start处
				System.out.println( i + "   " + j);
				if (i < j) {				//##################有错，回来解决
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
	}*/

	private static void swap(DataWrap[] data, int i, int j) {
		DataWrap tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
}
