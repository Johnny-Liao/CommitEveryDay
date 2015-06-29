package Algorithm.Sort;

import java.util.Arrays;

/**
 * 使得基数排序可以使用不同的稳定的排序算法来实现不同位数上的排序<br>
 * 时间效率O(n*n* n/2) 空间效率：和原数据等大的数组<br>
 * 结论：实现基数排序还是针对某种具体的排序算法来实现，效率更高，此处只是为了实现所有稳定的排序都可用而设计的低效率的算法，不推荐使用
 * @author JohnnyLiao
 */
public class RadixSortWithDiffStableSort {

	/**
	 * @param data 待排序数组
	 * @param radix 指定关键字拆分的进制。如：radix = 10 为10进制
	 * @param d 子关键字个数 ： 循环排序的次数
	 */
	public static void radixSort(int[] data, int radix, int d) {
		System.out.println("基数排序：");
		int arrayLength = data.length;

		// rate用于保存当前计算的位
		for (int i = 0, rate = 1; i < d; i++) {
			// 计算每个待排数据的子关键字
			int[] sub = new int[arrayLength];
			for (int j = 0; j < arrayLength; j++) {
				int subKey = (data[j] / rate) % radix;		// 10 /10 %10 = 1 (取出的10进制中的10位数)
				sub[j] = subKey;
			}
			// 不仅仅是比较好子关键字就是，还要把原数据排好位置
			data = stableSort(data, sub, rate, radix);

			System.out.println(Arrays.toString(data) + "\n");
			rate *= radix;
		}
	}

	/**
	 * 能够根据原数据所在位排序，并返回排好序的数组
	 * @param data	原数据
	 * @param sub 所在位所有的数据
	 * @param d 当前计算的位
	 * @param radix 进制
	 * @return
	 */
	private static int[] stableSort(int[] data, int[] sub, int d, int radix) {
		System.out.println(d + "位数排序前：" + Arrays.toString(sub));
		BubbleSort.bubbleSort(sub);												// 此处使用稳定的排序算法来排不同位上的数的序--还可以封装传入--上一级封装传入更好-在此就不改了
		System.out.println(d + "位数排序后：" + Arrays.toString(sub));
		
		int[] tmp = new int[data.length]; 	// 临时数组
		System.arraycopy(data, 0, tmp, 0, data.length);			// 缓存
		
		// 根据排好序的子数据排好原数据的序----此算法还可以优化--现在效率极低
		for (int j = 0; j < sub.length; j++) {
			for (int i = 0; i < data.length; i++) {
				int rateNum = (data[i] / d) % radix;
				if (sub[j] == rateNum) {
					tmp[j] = data[i];
					// 需要移除data[i]--把data[i]移到最后，其他的依次前移(不能换位置)
					for (int k = i; k < data.length - 1; k++) {
						data[k] = data[k + 1];			// 最后一位弃置不管，比较时根本比不到
					}
					break;
				}
			}
		}
		System.arraycopy(tmp, 0, data, 0, data.length);
		return data;
	}
	
	public static void main(String[] args) {
		int[] data = {1100, 192, 221, 12, 13};
		System.out.println("排序前：\n" + Arrays.toString(data));
		radixSort(data, 10, 4);
		System.out.println("排序后：\n" + Arrays.toString(data));
	}
}
