package Algorithm.IntroductionToAlgorithms.Sort;

import java.util.Arrays;

/**
 * CountingSort:使用输入元素的实际值来确定其在数组中的位置。<br/>
 * 时间复杂度：O(n+k) = O(n) 空间复杂度：O(n+k) 稳定
 * 
 * @author JohnnyLiao
 * @date 2015年7月26日 下午2:56:04
 */
public class CountingSort {

	private static int[] A = { 2, 5, 3, 0, 2, 3, 0, 3 };

	public int[] countingSort(int[] A, int k) {
		int[] B = new int[A.length];
		int[] C = new int[k];
		// 把A[i]值的个数，记录到C[A[i]]中
		for (int i = 0; i < A.length; i++) {
			C[A[i]] = C[A[i]] + 1;
		}
		// 确定每一个 i=1...k 有多少个输出元素(A[i]值的个数)<=i
		for (int i = 1; i < k; i++) {
			C[i] = C[i] + C[i - 1];
		}
		// C[A[i]]包括包含其本身，所以先--运算
		for (int i = A.length - 1; i >= 0; i--) {
			C[A[i]] = C[A[i]] - 1;
			B[C[A[i]]] = A[i];
		}
		return B;
	}

	public static void main(String[] args) {
		CountingSort sort = new CountingSort();
		int[] B = sort.countingSort(A, 6);
		System.out.println(Arrays.toString(B));
	}
}
