package Algorithm.OtherButImportantToo;

/**
 * 输出字符串的全排列
 * Created by johnny on 15-9-5.
 */
public class CalcAllPermutation {

    public static void allPermutation(char[] chars, int from, int to) {

        if (to <= 1)
            return;
        if (from == to) {
            for (int i = 0; i < to; i++) {
                System.out.print(chars[i]);
            }
            System.out.println();
        } else {
            for (int i = from; i < to; i++) {
                char tmp = chars[i];
                chars[i] = chars[from];
                chars[from] = tmp;

                allPermutation(chars, from + 1, to);

                char tmp2 = chars[i];
                chars[i] = chars[from];
                chars[from] = tmp2;
            }
        }
    }

    public static void main(String[] args) {
        String test = "abc";
        char[] chars = test.toCharArray();
        allPermutation(chars, 0, 3);
    }
}
