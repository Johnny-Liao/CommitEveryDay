package Algorithm.OtherButImportantToo;

import java.util.Arrays;

public class ReverseString {

    private static void reverseString(char[] array, int form, int to) {
        while (form < to) {
            char t = array[form];
            array[form++] = array[to];
            array[to--] = t;
        }
    }


    public static void leftRotateString(String s, int n, int m) {
        char[] arrayString = s.toCharArray();
        System.out.println("Before reverse : " + Arrays.toString(arrayString));
        m %= n;
        // three times to reverse string.
        reverseString(arrayString, 0, m - 1);
        reverseString(arrayString, m, n - 1);
        reverseString(arrayString, 0, n - 1);
        System.out.println("After reverse : " + Arrays.toString(arrayString));
    }


    public static void main(String[] args) {
        leftRotateString("abcdef", 6, 4);
    }
}
