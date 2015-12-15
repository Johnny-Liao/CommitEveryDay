package Algorithm.Sort;

import java.util.Arrays;

/**
 * ��ؼ��ֻ�������ʹ��Ͱ����ʵ��(ֻҪ���ȶ��������㷨���У���Ͱ�ڴ�Ч�ʸ�)<br>
 * ʱ�临�Ӷ�O(n*n) �ռ临�Ӷȣ�������������
 * @author JohnnyLiao
 */
public class MultiKeyRadixSort {
	
	/**
	 * 
	 * @param data ����������
	 * @param radix ָ���ؼ��ֲ�ֵĽ��ơ��磺radix = 10 Ϊ10����
	 * @param d �ӹؼ��ָ��� �� ѭ������Ĵ���
	 */
	public static void radixSort(int[] data, int radix, int d) {
		System.out.println("��������");
		int arrayLength = data.length;
		int[] tmp = new int[arrayLength]; 	// ��ʱ����
		int[] buckets = new int[radix];		// Ͱ��������
		
		// rate���ڱ��浱ǰ�����λ
		for (int i = 0, rate = 1; i < d; i++) {
			Arrays.fill(buckets, 0);		// ����buckets���飬���ں���һ�˱Ƚ�
			System.arraycopy(data, 0, tmp, 0, arrayLength);			// ����
			
			// ����ÿ���������ݵ��ӹؼ���,������Ͱ��
			for (int j = 0; j < arrayLength; j++) {
				int subKey = (tmp[j] / rate) % radix;		// 10 /10 %10 = 1 (ȡ����10�����е�10λ��)
				buckets[subKey]++;
			}
			// ���㡰���롱��Ͱ�е�Ԫ�������������е�λ��
			for (int j = 1; j < radix; j++) {
				buckets[j] = buckets[j] + buckets[j - 1];
			}
			// ���ӹؼ��ֶ�ָ�����ݽ�������
			for (int m = arrayLength - 1; m >= 0; m--) {
				int subKey = (tmp[m] / rate) % radix;
				data[--buckets[subKey]] = tmp[m];
			}
			System.out.println("��" + rate + "λ���ӹؼ�������" + Arrays.toString(data));
			rate *= radix;
		}
	}
	
	public static void main(String[] args) {
		int[] data = {1100, 192, 221, 12, 13};
		System.out.println("����ǰ��\n" + Arrays.toString(data));
		radixSort(data, 10, 4);
		System.out.println("�����\n" + Arrays.toString(data));
	}
}
