package Algorithm.Sort;

import java.util.Arrays;

/**
 * ʹ�û����������ʹ�ò�ͬ���ȶ��������㷨��ʵ�ֲ�ͬλ���ϵ�����<br>
 * ʱ��Ч��O(n*n* n/2) �ռ�Ч�ʣ���ԭ���ݵȴ������<br>
 * ���ۣ�ʵ�ֻ������������ĳ�־���������㷨��ʵ�֣�Ч�ʸ��ߣ��˴�ֻ��Ϊ��ʵ�������ȶ������򶼿��ö���Ƶĵ�Ч�ʵ��㷨�����Ƽ�ʹ��
 * @author JohnnyLiao
 */
public class RadixSortWithDiffStableSort {

	/**
	 * @param data ����������
	 * @param radix ָ���ؼ��ֲ�ֵĽ��ơ��磺radix = 10 Ϊ10����
	 * @param d �ӹؼ��ָ��� �� ѭ������Ĵ���
	 */
	public static void radixSort(int[] data, int radix, int d) {
		System.out.println("��������");
		int arrayLength = data.length;

		// rate���ڱ��浱ǰ�����λ
		for (int i = 0, rate = 1; i < d; i++) {
			// ����ÿ���������ݵ��ӹؼ���
			int[] sub = new int[arrayLength];
			for (int j = 0; j < arrayLength; j++) {
				int subKey = (data[j] / rate) % radix;		// 10 /10 %10 = 1 (ȡ����10�����е�10λ��)
				sub[j] = subKey;
			}
			// �������ǱȽϺ��ӹؼ��־��ǣ���Ҫ��ԭ�����ź�λ��
			data = stableSort(data, sub, rate, radix);

			System.out.println(Arrays.toString(data) + "\n");
			rate *= radix;
		}
	}

	/**
	 * �ܹ�����ԭ��������λ���򣬲������ź��������
	 * @param data	ԭ����
	 * @param sub ����λ���е�����
	 * @param d ��ǰ�����λ
	 * @param radix ����
	 * @return
	 */
	private static int[] stableSort(int[] data, int[] sub, int d, int radix) {
		System.out.println(d + "λ������ǰ��" + Arrays.toString(sub));
		BubbleSort.bubbleSort(sub);												// �˴�ʹ���ȶ��������㷨���Ų�ͬλ�ϵ�������--�����Է�װ����--��һ����װ�������-�ڴ˾Ͳ�����
		System.out.println(d + "λ�������" + Arrays.toString(sub));
		
		int[] tmp = new int[data.length]; 	// ��ʱ����
		System.arraycopy(data, 0, tmp, 0, data.length);			// ����
		
		// �����ź�����������ź�ԭ���ݵ���----���㷨�������Ż�--����Ч�ʼ���
		for (int j = 0; j < sub.length; j++) {
			for (int i = 0; i < data.length; i++) {
				int rateNum = (data[i] / d) % radix;
				if (sub[j] == rateNum) {
					tmp[j] = data[i];
					// ��Ҫ�Ƴ�data[i]--��data[i]�Ƶ��������������ǰ��(���ܻ�λ��)
					for (int k = i; k < data.length - 1; k++) {
						data[k] = data[k + 1];			// ���һλ���ò��ܣ��Ƚ�ʱ�����Ȳ���
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
		System.out.println("����ǰ��\n" + Arrays.toString(data));
		radixSort(data, 10, 4);
		System.out.println("�����\n" + Arrays.toString(data));
	}
}
