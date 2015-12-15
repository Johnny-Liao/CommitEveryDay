package Algorithm.Sort;

import java.util.Arrays;

/**
 * 注：这是计数排序不是桶排序！
 * 选一本好的教科书是前提，这明明是计数排序，在《疯狂java程序员的基本修养》中竟然把它当成桶排序来用，害死人不偿命啊！！！
 * 开始以为这书挺好的，会带你研读源码，可是在发现好多错误之后作者有时真是误人子弟啊！
 * @author JohnnyLiao
 * @date 2015年7月26日 下午3:04:23
 */
public class BucketSort implements Sort {

	@Override
	public void sort(DataWrap[] data) {
//		bucketSort(data);
	}

	// 计数排序
	public static void bucketSort(DataWrap[] data, int min, int max) {
		System.out.println("通排序");
		int arrayLength = data.length;
		DataWrap[] tmp = new DataWrap[arrayLength];
		int[] buckets = new int[max - min];
		// 计算每个元素在序列中出现的次数
		for (int i = 0; i < arrayLength; i++) {
			buckets[data[i].data - min]++;					// 每有一个数落入相应的位置 buckets[i]++		设计巧妙
		}
		System.out.println("桶中元素：");
		System.out.println(Arrays.toString(buckets));
		// 计算“落入”各桶中的元素在有序序列中的位置
		for (int i = 1; i < max - min; i++) {
			buckets[i] = buckets[i] + buckets[i - 1];
		}
		// 循环结束后，buckets数组中记录了“落入”当前桶和“落入”前面所有桶的元素的总数，因为落入时已经有序：
		// buckets 数组中元素的值代表了“落入”当前桶中的元素在有序序列中的位置
		System.out.println(Arrays.toString(buckets));
		// 将data数组中数据完全复制到tmp数组中缓存
		System.arraycopy(data, 0, tmp, 0, arrayLength);
		// 根据buckets数组中信息将待排序列的各元素放入相应的位置
		for (int k = arrayLength - 1; k >=0; k--) {
			data[--buckets[tmp[k].data - min]] = tmp[k];		// data[位置]： 位置 = buckets的值
		}
	}
	
	public static void main(String[] args) {
		DataWrap[] data = {
				new DataWrap(9, ""),
				new DataWrap(5, ""),
				new DataWrap(-1, ""),
				new DataWrap(8, ""),
				new DataWrap(5, "*"),
				new DataWrap(7, ""),
				new DataWrap(3, ""),
				new DataWrap(-3, ""),
				new DataWrap(1, ""),
				new DataWrap(3, "*")
		};
		
		System.out.println("排序之前：\n" + Arrays.toString(data));
		bucketSort(data, -3, 10);
		System.out.println("排序之后：\n" + Arrays.toString(data));
	}

}
