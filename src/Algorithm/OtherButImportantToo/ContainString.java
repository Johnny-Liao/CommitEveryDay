package Algorithm.OtherButImportantToo;

/**
 * 判断字符串A中是否包含字符串B中所有字符.
 * Created by Johnny Liao on 15-9-3.
 */
public class ContainString {

    // 第一想法是用hashmap来实现，但是通过位运算能达到O(1)的空间效率，时间效率都为O(n + m)
    public boolean contain(String A, String B) {
        int hash = 0;
        for (int i = 0; i < A.length(); i++) {
            hash |= (1 << A.charAt(i));             // 使用位运算来代替hashmap
        }
        for (int i = 0; i < B.length(); i++) {
            if ((hash & (1 << B.charAt(i))) == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String A = "dkjadkaj";
        String B = "jkm";
        ContainString cs = new ContainString();
        boolean result = cs.contain(A, B);
        System.out.println("A is " + (result ? "" : "not ") + "contain B");

    }
}
