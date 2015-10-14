package Algorithm.OtherButImportantToo;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * <p/>
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * Created by johnny on 15-9-4.
 */
public class ValidAnagramString {

    // 时间复杂度O(n), 空间复杂度O(n)
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null)
            return false;

        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        for (int i = 0; i < t.length(); i++) {
            if (list.contains(t.charAt(i))) {
                list.remove(list.lastIndexOf(t.charAt(i)));
            } else {
                return false;
            }
        }

        if (list.isEmpty())
            return true;

        return false;
    }

    public static void main(String[] args) {
        ValidAnagramString vas = new ValidAnagramString();
        String a = "bca";
        String b = "abc";
        boolean result = vas.isAnagram(a, b);
        boolean result2 = vas.isAnagram("", "2");
        System.out.println(result);
        System.out.println(result2);
    }
}
