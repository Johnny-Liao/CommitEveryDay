package Algorithm.Sort;

import java.util.Arrays;

/**
 * ע�����Ǽ���������Ͱ����
 * ѡһ���õĽ̿�����ǰ�ᣬ�������Ǽ��������ڡ����java����Ա�Ļ����������о�Ȼ��������Ͱ�������ã������˲�������������
 * ��ʼ��Ϊ����ͦ�õģ�������ж�Դ�룬�����ڷ��ֺö����֮��������ʱ���������ӵܰ���
 * @author JohnnyLiao
 * @date 2015��7��26�� ����3:04:23
 */
public class BucketSort implements Sort {

	@Override
	public void sort(DataWrap[] data) {
//		bucketSort(data);
	}

	// ��������
	public static void bucketSort(DataWrap[] data, int min, int max) {
		System.out.println("ͨ����");
		int arrayLength = data.length;
		DataWrap[] tmp = new DataWrap[arrayLength];
		int[] buckets = new int[max - min];
		// ����ÿ��Ԫ���������г��ֵĴ���
		for (int i = 0; i < arrayLength; i++) {
			buckets[data[i].data - min]++;					// ÿ��һ����������Ӧ��λ�� buckets[i]++		�������
		}
		System.out.println("Ͱ��Ԫ�أ�");
		System.out.println(Arrays.toString(buckets));
		// ���㡰���롱��Ͱ�е�Ԫ�������������е�λ��
		for (int i = 1; i < max - min; i++) {
			buckets[i] = buckets[i] + buckets[i - 1];
		}
		// ѭ��������buckets�����м�¼�ˡ����롱��ǰͰ�͡����롱ǰ������Ͱ��Ԫ�ص���������Ϊ����ʱ�Ѿ�����
		// buckets ������Ԫ�ص�ֵ�����ˡ����롱��ǰͰ�е�Ԫ�������������е�λ��
		System.out.println(Arrays.toString(buckets));
		// ��data������������ȫ���Ƶ�tmp�����л���
		System.arraycopy(data, 0, tmp, 0, arrayLength);
		// ����buckets��������Ϣ���������еĸ�Ԫ�ط�����Ӧ��λ��
		for (int k = arrayLength - 1; k >=0; k--) {
			data[--buckets[tmp[k].data - min]] = tmp[k];		// data[λ��]�� λ�� = buckets��ֵ
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
		
		System.out.println("����֮ǰ��\n" + Arrays.toString(data));
		bucketSort(data, -3, 10);
		System.out.println("����֮��\n" + Arrays.toString(data));
	}

}
