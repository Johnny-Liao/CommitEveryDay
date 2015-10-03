/*
package Algorithm.OtherButImportantToo;

import java.util.Arrays;

*/
/**
 * 题目描述�? * 给定�?��字符串，要求把字符串前面的若干个字符移动到字符串的尾部，
 * 如把字符串�?abcdef”前面的2个字�?a'�?b'移动到字符串的尾部，
 * 使得原字符串变成字符串�?cdefab”�?
 * 请写�?��函数完成此功能，要求对长度为n的字符串操作的时间复杂度�?O(n)，空间复杂度�?O(1)�? * 采用三步反转法解�? *//*

public class ReverseString {

    */
/**
     * 转置字符串数组中的字符位�?     *
     * @param array 待处理的字符串数�?     * @param form  交换区第�?��位置
     * @param to    交换区最后一个位�?     *//*

    private void reverseString(char[] array, int form, int to) {
        while (form < to) {
            char t = array[form];
            array[form++] = array[to];
            array[to--] = t;
        }
    }

    */
/**
     * 左旋转字符串
     *
     * @param s 用于转换的字符串
     * @param n 字符串长�?     * @param m 移动的位�?     *//*

    public void leftRotateString(String s, int n, int m) {
        char[] arrayString = s.toCharArray();
        System.out.println("旋转之前�? + Arrays.toString(arrayString));
        m %= n; // 若要左移动大于n位，那么�?n 是等价的
        reverseString(arrayString, 0, m - 1);
        reverseString(arrayString, m, n - 1);
        reverseString(arrayString, 0, n - 1);
        System.out.println("旋转之后�? + Arrays.toString(arrayString));
    }


    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        rs.leftRotateString("abcdef", 6, 4);
    }
}*/
