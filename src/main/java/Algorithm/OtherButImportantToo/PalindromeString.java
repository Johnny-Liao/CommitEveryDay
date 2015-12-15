package Algorithm.OtherButImportantToo;

/**
 * �ж��ַ����Ƿ��ǻ��ĵ�
 * Created by johnny on 15-9-4.
 */
public class PalindromeString {

    /**
     * is very simple :
     *   ���ַ���ͷ��β��ͬʱ�����ַ������Ƿ���ȣ���ɴ��п�ʼ�жϡ�
     * @param s ��Ҫ�жϵ��ַ���
     * @return �жϽ��booleanֵ
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
