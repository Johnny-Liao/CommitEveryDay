package Algorithm.Sort;

import java.util.Arrays;

/**
 * 多关键字基数排序：使用桶排序实现(只要是稳定的排序算法都行，但桶在此效率高)<br>
 * 时间复杂度O(n*n) 空间复杂度：两个辅助数组
 * @author JohnnyLiao
 */
public class MultiKeyRadixSort {
	
	/**
	 * 
	 * @param data 待排序数组
	 * @param radix 指定关键字拆分的进制。如：radix = 10 为10进制
	 * @param d 子关键字个数 ： 循环排序的次数
	 */
	public static void radixSort(int[] data, int radix, int d) {
		System.out.println("基数排序：");
		int arrayLength = data.length;
		int[] tmp = new int[arrayLength]; 	// 临时数组
		int[] buckets = new int[radix];		// 桶排序所需
		
		// rate用于保存当前计算的位
		for (int i = 0, rate = 1; i < d; i++) {
			Arrays.fill(buckets, 0);		// 重置buckets数组，用于后面一趟比较
			System.arraycopy(data, 0, tmp, 0, arrayLength);			// 缓存
			
			// 计算每个待排数据的子关键字,并放入桶中
			for (int j = 0; j < arrayLength; j++) {
				int subKey = (tmp[j] / rate) % radix;		// 10 /10 %10 = 1 (取出的10进制中的10位数)
				buckets[subKey]++;
			}
			// 计算“落入”各桶中的元素在有序序列中的位置
			for (int j = 1; j < radix; j++) {
				buckets[j] = buckets[j] + buckets[j - 1];
			}
			// 按子关键字对指定数据进行排序
			for (int m = arrayLength - 1; m >= 0; m--) {
				int subKey = (tmp[m] / rate) % radix;
				data[--buckets[subKey]] = tmp[m];
			}
			System.out.println("对" + rate + "位上子关键字排序：" + Arrays.toString(data));
			rate *= radix;
		}
	}
	
	public static void main(String[] args) {
		int[] data = {1100, 192, 221, 12, 13};
		System.out.println("排序前：\n" + Arrays.toString(data));
		radixSort(data, 10, 4);
		System.out.println("排序后：\n" + Arrays.toString(data));
	}
}
