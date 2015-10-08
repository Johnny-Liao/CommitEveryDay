package Algorithm.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * <p/>
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * <p/>
 * Notes:
 * patterncontains only lowercase alphabetical letters, and str contains words separated by a single space. Each word in str contains only lowercase alphabetical letters.
 * Both pattern and str do not have leading or trailing spaces.
 * Each letter in pattern must map to a word with length that is at least 1.
 * <p/>
 * Created by johnny on 15-10-8.
 */
public class WordPattern {

    static Map<Character, String> map = new HashMap<>();

    public static boolean wordPattern(String pattern, String str) {
        // 鲁棒性
        if (pattern == null || pattern.equals("")) {
            if (str == null || str.equals("")) {
                return true;
            }
            return false;
        }
        if (str == null || str.equals("")) {
            return false;
        }

        // begin
        char[] patternChar = pattern.toCharArray();
        String[] strArray = str.split(" ");
        int i = 0;
        int j = 0;

        while ((i < patternChar.length) && (j < strArray.length)) {
            if (!map.containsKey(patternChar[i])) {
                if (map.containsValue(strArray[j])) {       // 确保一个模式对应一个单词
                    return false;
                }
                map.put(patternChar[i], strArray[j]);
            } else {
                if (!map.get(patternChar[i]).equals(strArray[j])) {
                    return false;
                }
            }
            i++;
            j++;
        }
        // both to the end
        if (i == patternChar.length && j == strArray.length)
            return true;
        return false;
    }

    public static void main(String[] args) {
        boolean result = wordPattern("aaba", "dog dog cat cat");
        System.out.println(result);
    }
}
