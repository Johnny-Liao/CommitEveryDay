package Algorithm.LeetCode;

/**
 * ����һ���ַ���S���ҳ��������Ļ����Ӵ�������Լ����ַ�������󳤶���1000�����Ҵ���Ψһ��������Ӵ�
 * 
 * @author JohnnyLiao
 * @date 2015��8��16�� ����7:15:50
 */
public class LongestPalindromicSubstring {

	/**
	 * ����˼·��<br>
	 * ��̬�滮����<br>
	 * ����dp[ i ][ j ]��ֵΪtrue����ʾ�ַ���s���±�� i �� j ���ַ���ɵ��Ӵ��ǻ��Ĵ���<br>
	 * �Ƴ���dp[i][j] = dp[i+1][j-1] && s[i] == s[j] <br>
	 * ������Ҫ����i+1, j -1�������п��� i + 1 = j -1, i + 1 = (j - 1) -1 <br>
	 * a. i + 1 = j -1�������ĳ���Ϊ1ʱ��dp[ i ][ i ] = true; <br>
	  * ��b. i + 1 = (j - 1) -1�������ĳ���Ϊ2ʱ��dp[ i ][ i + 1] = ��s[ i ] == s[ i +1]����<br>
	 * ������Ҫ���ǰ��Ļ�׼��������������Ϲ�ʽ <br>
	 * ��Ҫע����Ƕ�̬�滮����Ҫ�����O(n^2)�Ŀռ�
	 */
	
	// �����ܽ᣺�жϺ���Ľϳ����Ӵ��Ƿ���Ļ���ǰ���2�ֻ�׼����������ɶ��Ƶ���

	public String logestPalindrome(String s) {
		if (s == null || s.length() < 2) {
			return s;
		}

		int maxLength = 0;
		String longest = null;
		int length = s.length();
		boolean[][] table = new boolean[length][length];

		// length = 1 �����ַ����ǻ���
		for (int i = 0; i < length; i++) {
			table[i][i] = true;
			longest = s.substring(i, i + 1);
			maxLength = 1;
		}

		// length = 2 �ж������ַ��Ƿ��ǻ���
		for (int i = 0; i < length - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				table[i][i + 1] = true;
				longest = s.substring(i, i + 2);
				maxLength = 2;
			}
		}

		// length > 2 �жϳ��ȴ���2���Ӵ��Ƿ��ǻ���
		for (int len = 3; len <= length; len++) {
			for (int i = 0, j; (j = i + len - 1) <= length - 1; i++) { // j��λ���ó����Ƚϵ��ַ������һλ�ַ�<=length
																		// - 1

				if (s.charAt(i) == s.charAt(j)) {
					table[i][j] = table[i + 1][j - 1]; // �����ڲ��Ӵ���״̬���ڲ����ǻ�������Ȼ���ǻ��ģ��ڲ�����ǰ��ѭ�����������̬�滮
					if (table[i][j] && maxLength < len) {
						longest = s.substring(i, j + 1);
						maxLength = len;
					}
				} else {
					table[i][j] = false;// ͷβ�����ֱ���жϲ��ǻ���
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
