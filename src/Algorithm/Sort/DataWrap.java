package Algorithm.Sort;

/**
 * 定义一个数据包类型，后续排序均在此基于此数据包
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
	// 根据data实例变量来决定两个DataWrap的大小
	public int compareTo(DataWrap dw) {
		return this.data > dw.data ? 1 : (this.data == dw.data ? 0 : -1); 
	}

}
