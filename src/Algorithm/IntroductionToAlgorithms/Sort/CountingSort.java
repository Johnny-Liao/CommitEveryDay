package Algorithm.IntroductionToAlgorithms.Sort;

import java.util.Arrays;

/**
 * CountingSort:ʹ������Ԫ�ص�ʵ��ֵ��ȷ�����������е�λ�á�<br/>
 * ʱ�临�Ӷȣ�O(n+k) = O(n) �ռ临�Ӷȣ�O(n+k) �ȶ�
 * 
 * @author JohnnyLiao
 * @date 2015��7��26�� ����2:56:04
 */
public class CountingSort {

	private static int[] A = { 2, 5, 3, 0, 2, 3, 0, 3 };

	public int[] countingSort(int[] A, int k) {
		int[] B = new int[A.length];
		int[] C = new int[k];
		// ��A[i]ֵ�ĸ�������¼��C[A[i]]��
		for (int i = 0; i < A.length; i++) {
			C[A[i]] = C[A[i]] + 1;
		}
		// ȷ��ÿһ�� i=1...k �ж��ٸ����Ԫ��(A[i]ֵ�ĸ���)<=i
		for (int i = 1; i < k; i++) {
			C[i] = C[i] + C[i - 1];
		}
		// C[A[i]]���������䱾��������--����
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
