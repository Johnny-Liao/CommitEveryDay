package Algorithm.LeetCode;

/**
 * 给定一个字符串S，找出它的最大的回文子串，你可以假设字符串的最大长度是1000，而且存在唯一的最长回文子串
 *
 * @author JohnnyLiao
 * @date 2015年8月16日 下午7:15:50
 */
public class LongestPalindromicSubstring {

    /**
     * 解题思路：
     * 动态规划法：
     *
     * 假设dp[ i ][ j ]的值为true，表示字符串s中下标从 i 到 j 的字符组成的子串是回文串。
     *
     * 推出：dp[i][j] = dp[i+1][j-1] && s[i] == s[j]
     *
     * 由于需要依靠i+1, j -1，所以有可能 i + 1 = j -1 或 i + 1 = (j - 1) -1
     *      a. i + 1 = j -1，即回文长度为1时，dp[ i ][ i ] = true;
     *      b. i + 1 = (j - 1) -1，即回文长度为2时，dp[ i ][ i + 1] = （s[ i ] == s[ i +1]）
     * 所以先要求出前面的基准情况才能套用以上公式
     * 需要注意的是动态规划法需要额外的O(n^2)的空间
     * 此算法时间复杂度也为O(n),效率不高。
     */

    // 个人总结：判断后面的较长的子串是否回文基于前面的2种基准情况而来，由短推到长
    public String logestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int maxLength = 0;
        String longest = null;
        int length = s.length();
        boolean[][] table = new boolean[length][length];

        // length = 1 单个字符都是回文
        for (int i = 0; i < length; i++) {
            table[i][i] = true;
            longest = s.substring(i, i + 1);
            maxLength = 1;
        }

        // length = 2 判断两个字符是否是回文
        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = true;
                longest = s.substring(i, i + 2);
                maxLength = 2;
            }
        }

        // length > 2 判断长度大于2的子串是否是回文
        for (int len = 3; len <= length; len++) {
            for (int i = 0, j; (j = i + len - 1) <= length - 1; i++) { // j定位到拿出来比较的字符串最后一位字符<=length - 1
                if (s.charAt(i) == s.charAt(j)) {
                    table[i][j] = table[i + 1][j - 1]; // 看其内部子串的状态，内部不是回文其自然不是回文，内部已在前面循环中求出：动态规划
                    if (table[i][j] && maxLength < len) {
                        longest = s.substring(i, j + 1);
                        maxLength = len;
                    }
                } else {
                    table[i][j] = false;// 头尾不相等直接判断不是回文
                }
            }
        }

        return longest;
    }

    // test
    public static void main(String[] args) {
        String s = "abcdefedcaaaa";
        String result = new LongestPalindromicSubstring().logestPalindrome(s);
        System.out.println("Longest Palindromic Substring in " + s + " is : " + result);
    }
}
