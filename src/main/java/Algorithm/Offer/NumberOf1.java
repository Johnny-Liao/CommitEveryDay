package Algorithm.Offer;

/**
 * 统计整形数字二进制表示中1的个数
 * 方法：
 * 把一个整数减去1之后与原来的整数位与运算。
 * Created by johnny on 15-10-11.
 */
public class NumberOf1 {

    /**
     * 把一个整数减去1之后与原来的整数位与运算，得到的结果相当于把整数的二进制的最后一位变为0.
     * @param n 需要统计个数的数
     * @return 个数
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
