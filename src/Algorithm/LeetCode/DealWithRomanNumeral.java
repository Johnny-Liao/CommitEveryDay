package Algorithm.LeetCode;

/**
 * ��������������ʮ������֮���ת����
 * 
 * @author JohnnyLiao
 * @date 2015��8��16�� ����3:39:07
 */
public class DealWithRomanNumeral {

	// int to roman
	// ����һ����ά���鱣��ÿ��λ���ϵ�1-9����λд���������ֽ����������̲������ӵ�λ��ʼ����ÿ����λ���ַ���ֱ�����Ľ���� 
	public String intToRoman(int num) {

		String[][] base = new String[][] { { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" }, // ��λ�ı�ʾ
				{ "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" }, // ʮλ�ı�ʾ
				{ "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" }, // ��λ�ı�ʾ
				{ "M", "MM", "MMM", "", "", "", "", "", "" } }; // ǧλ�ı�ʾ 1~3999

		String result = "";

		// ÿ��һ�ξ�ʾ�����һ����λ����С����
		// i��¼��ǰ������ǵڼ�����λ
		for (int i = 0; num != 0; num /= 10, i++) {
			// �����Ϊ0��˵�������λ����ֵ��Ҫ������Ӳ���
			if (num % 10 != 0) {
				// ƴ�ӽ��
				result = base[i][num % 10 - 1] + result;
			}
		}

		return result;
	}

	// roman to int
	// ���������������������ֶ�Ӧ��ϵ���мӷ����������ǰһ�����ֱȺ�һ�������������������ӡ�
	public int romanToInt(String s) {

		int result = 0;
		int prev = 0; // ��¼ǰһ�����ֵ�ֵ

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
