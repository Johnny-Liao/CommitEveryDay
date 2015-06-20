package Algorithm.Sort;

import java.util.Arrays;

/**
 * ������ѡ������ʹÿ������ʱ���ݽ�����������Ϊ1�����ռ临�Ӷ�Ϊ��O(1)
 * 
 * @author JohnnyLiao
 */
public class SelectSortUpgraded {
	public static void selectSortUpgrade(DataWrap[] data) {
		System.out.println("������ѡ������");
		for (int i = 0; i < data.length -1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < data.length; j++) {
				// ! ע�⣡����minIndexλ�õ����ݺ�j�Ƚ� minIndex��̬�ı�
				if (data[minIndex].compareTo(data[j]) > 0) {
					minIndex = j; // ÿ������ֻΪ�ҵ�λ��i�������С��
				}
			}
			if (minIndex != i) {
				DataWrap tmp = data[i];
				data[i] = data[minIndex];
				data[minIndex] = tmp;
			}
			System.out.println(Arrays.toString(data));
		}
	}
}
