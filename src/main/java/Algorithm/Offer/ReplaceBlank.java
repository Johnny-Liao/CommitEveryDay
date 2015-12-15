package Algorithm.Offer;

import java.util.Arrays;

/**
 * ��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20����
 * ���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���Ϊ:We%20Are%20Happy��
 * Created by johnny on 15-10-9.
 */
public class ReplaceBlank {

    public static String replaceSpace(StringBuffer str) {
        int orn_length = str.length();
        if (str.toString().equals("") || orn_length == 0)
            return "";

        int i = 0;
        int blank_num = 0;
        // count blank number
        while (i < orn_length) {
            if (str.charAt(i) == ' ') {
                ++blank_num;
            }
            i++;
        }

        int newLength = orn_length + blank_num * 2;
        int indexOfOriginal = orn_length - 1;
        int indexOfNew = newLength - 1;
        char[] orgString = str.toString().toCharArray();
        char[] newString = new char[newLength];
        System.arraycopy(orgString, 0, newString, 0, orn_length);
        System.out.println("Debug new Array : " + Arrays.toString(newString));
        while (indexOfOriginal >= 0 && indexOfNew > indexOfOriginal) {
            if (newString[indexOfOriginal] == ' ') {
                newString[indexOfNew--] = '0';
                newString[indexOfNew--] = '2';
                newString[indexOfNew--] = '%';
            } else {
                newString[indexOfNew--] = newString[indexOfOriginal];
            }
            --indexOfOriginal;
        }
        System.out.println("Debug new Array : " + Arrays.toString(newString));
        return String.valueOf(newString);
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer(" HelloWorld!");
        System.out.println(replaceSpace(sb));
    }
}
