package Algorithm.Sort;

import java.util.Arrays;

/**
 * ð���������������������Ƚϣ��Ѵ��������ݰ�ð�ݵ�����������û�������������ǰ������
 * 
 * @author JohnnyLiao
 */
public class BubbleSort {

	public static void bubbleSort(DataWrap[] data) {
		System.out.println("ð������");
		for (int i = 0; i < data.length - 1; i++) {
			boolean flag = false; // �����жϴ��˱Ƚ���û�з�������
			for (int j = 0; j < data.length - 1 - i; j++) {
				if (data[j].compareTo(data[j + 1]) > 0) {
					// ����
					DataWrap tmp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = tmp;
					flag = true;
				}
			}
			System.out.println(Arrays.toString(data));
			if (!flag) {
				break;
			}
		}
	}
	
}
