package Algorithm.OtherButImportantToo;

/**
 * 判断字符串是否是回文的
 * Created by johnny on 15-9-4.
 */
public class PalindromeString {

    /**
     * is very simple :
     *   从字符串头和尾部同时遍历字符串看是否相等，亦可从中开始判断。
     * @param s 需要判断的字符串
     * @return 判断结果boolean值
     */
    public boolean isPalindrom(String s) {
        // don't forget
        if (s == null || "".equals(s))
            return false;

        int begin = 0;
        int end = s.length() - 1;
        while (begin < end) {
            if (s.charAt(begin) != s.charAt(end))
                return false;
            begin++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeString ps = new PalindromeString();
        String s = "aba";
        boolean result = ps.isPalindrom(s);
        System.out.println(s +  " is " + (result ? "" : "not ") + "palindrome string.");
    }
}
