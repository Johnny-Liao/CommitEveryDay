package Algorithm.Sort;

import java.util.Arrays;

public class MergeSort implements Sort {

	@Override
	public void sort(DataWrap[] data) {
		mergeSort(data);
	}
	
	public static void mergeSort(DataWrap[] data) {
		System.out.println("归并排序：");
		resolve(data, 0, data.length - 1);
	}
	
	// 分解原数组-递归归并排序
	private static void resolve(DataWrap[] data, int left, int right) {
		if (left < right) {
			int center = (left + right) / 2;
			
			resolve(data, left, center);
			resolve(data, center + 1, right);		// be careful this is 'right' you have wrong write 'left'
			
			merge(data, left, center, right);
			
			System.out.println(Arrays.toString(data));
		}
	}
	
	/**
	 * 将两个数组进行归并，归并前两个数组分别有序，归并后整体有序
	 * @param data 数组对象
	 * @param left 左数组第一个元素索引
	 * @param center 左数组最后一个元素索引，亦右数组第一个元素索引-1
	 * @param right 右数组最后一个索引
	 */
	private static void merge(DataWrap[] data, int left, int center, int right) {
		DataWrap[] tmpArr = new DataWrap[data.length];
		int tmp = left;		//后面用来把中间数组复制回原数组
		int rightIndex = center + 1;
		// 中间数组的索引
		int tmpIndex = left;
		while (left <= center && rightIndex <= right) {
			// 将两者中较小者放入临时数组
			if (data[left].compareTo(data[rightIndex]) <= 0) {
				tmpArr[tmpIndex++] = data[left++];
			} else {
				tmpArr[tmpIndex++] = data[rightIndex++];
			}
		}
		// 剩余部分依次放入数组
		while (rightIndex <= right) {
			tmpArr[tmpIndex++] = data[rightIndex++]; 
		}
		while (left <= center) {
			tmpArr[tmpIndex++] = data[left++];
		}
		// 将中间数组中的内容复制回原数组
//		int tmp = left;					严重错误-在上面的操作已经改变left的值
		while (tmp <= right) {
			data[tmp] = tmpArr[tmp];
			tmp++;
		}
	} 

}
