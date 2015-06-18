package Algorithm.Sort;

/**
 * ����һ�����ݰ����ͣ�����������ڴ˻��ڴ����ݰ�
 * 
 * @author JohnnyLiao
 */
public class DataWrap implements Comparable<DataWrap> {
	int data;
	String flag;

	public DataWrap(int d, String f) {
		data = d;
		flag = f;
	}

	@Override
	public String toString() {
		return data + flag;
	}

	@Override
	// ����dataʵ����������������DataWrap�Ĵ�С
	public int compareTo(DataWrap dw) {
		return this.data > dw.data ? 1 : (this.flag == dw.flag ? 0 : -1);
	}

}
