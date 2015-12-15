package Algorithm.Offer;

/**
 * ͳ���������ֶ����Ʊ�ʾ��1�ĸ���
 * ������
 * ��һ��������ȥ1֮����ԭ��������λ�����㡣
 * Created by johnny on 15-10-11.
 */
public class NumberOf1 {

    /**
     * ��һ��������ȥ1֮����ԭ��������λ�����㣬�õ��Ľ���൱�ڰ������Ķ����Ƶ����һλ��Ϊ0.
     * @param n ��Ҫͳ�Ƹ�������
     * @return ����
     */
    public static int numberOfOne (int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfOne(10));
    }
}
