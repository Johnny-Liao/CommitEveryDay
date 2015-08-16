package Algorithm.LeetCode;

/**
 * 处理罗马数字与十进制数之间的转换。
 * 
 * @author JohnnyLiao
 * @date 2015年8月16日 下午3:39:07
 */
public class DealWithRomanNumeral {

	// int to roman
	// 创建一个二维数组保存每个位数上的1-9的数位写法，对数字进行求余求商操作，从低位开始计算每个数位的字符，直到最后的结果。 
	public String intToRoman(int num) {

		String[][] base = new String[][] { { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" }, // 个位的表示
				{ "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" }, // 十位的表示
				{ "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" }, // 百位的表示
				{ "M", "MM", "MMM", "", "", "", "", "", "" } }; // 千位的表示 1~3999

		String result = "";

		// 每除一次就示处理后一个数位（从小到大）
		// i记录当前处理的是第几个数位
		for (int i = 0; num != 0; num /= 10, i++) {
			// 如果不为0，说明这个数位上有值，要进行相加操作
			if (num % 10 != 0) {
				// 拼接结果
				result = base[i][num % 10 - 1] + result;
			}
		}

		return result;
	}

	// roman to int
	// 根据罗马数字与整数数字对应关系进行加法操作，如果前一个数字比后一个大就相减，否则进行相加。
	public int romanToInt(String s) {

		int result = 0;
		int prev = 0; // 记录前一个数字的值

		for (int i = s.length() - 1; i > -1; i--) {
			switch (s.charAt(i)) {

			case 'I': // 1
				if (1 < prev) {
					result -= 1;
				} else {
					result += 1;

				}
				prev = 1;
				break;

			case 'V': // 5
				if (5 < prev) {
					result -= 5;
				} else {
					result += 5;
				}
				prev = 5;
				break;
				
			case 'X': // 10
				if (10 < prev) {
					result -= 10;
				} else {
					result += 10;
				}
				prev = 10;
				break;
				
			case 'L': // 50
				if (50 < prev) {
					result -= 50;
				} else {
					result += 50;
				}
				prev = 50;
				break;
				
			case 'C': // 100
				if (100 < prev) {
					result -= 100;
				} else {
					result += 100;
				}
				prev = 100;
				break;
				
			case 'D': // 500
				if (500 < prev) {
					result -= 500;
				} else {
					result += 500;
				}
				prev = 500;
				break;
				
			case 'M': // 1000
				result += 1000;
				prev = 1000;
				break;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		DealWithRomanNumeral num = new DealWithRomanNumeral();
		int intNum = 145;
		String romanNum = "VM";

		int resultOfInt = num.romanToInt(romanNum);
		String resultOfRoman = num.intToRoman(intNum);

		System.out.println(intNum + " to roman is : " + resultOfRoman);
		System.out.println(romanNum + " to int is : " + resultOfInt);
	}

}
