package Algorithm.OtherButImportantToo;

import java.util.Arrays;

/**
 * 输出字符串的全排列
 * Created by johnny on 15-9-5.
 */
@Deprecated
public class CalcAllPermutation {

    public void allPermutation_1(String s, int from, int to) {
        char[] strs = s.toCharArray();
        if (to <= 1)
            return;
        if (from == to) {
            for (int i = 0; i < to; i++) {
                System.out.print(strs[i]);
            }
            System.out.println();
        } else {
            for (int i = from; i < to; i++) {
                char tmp = strs[i];
                strs[i] = strs[from];
                strs[from] = tmp;

                allPermutation_1(s, from + 1, to);

                char tmp2 = strs[i];
                strs[i] = strs[from];
                strs[from] = tmp2;
            }
        }
    }

    private String swap(int f, int t, String s) {
        char[] c = s.toCharArray();
        char tmp = c[f];
        c[f] = c[t];
        c[t] = tmp;
        return Arrays.toString(c);
    }

    // wrong
    @Deprecated
    public static void main(String[] args) {
        CalcAllPermutation c = new CalcAllPermutation();
        String test = "abcdef";
        c.allPermutation_1(test, 0, 6);
    }
}
