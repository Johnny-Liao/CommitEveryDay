package Algorithm.IntroductionToAlgorithms.DynamicProgramming;

/**
 * ���ö�̬�滮���������и����⣺ <br>
 * ���룺����Ϊ  nӢ��ĸ������۸�� p(i=1,i=2,...)<br>
 * �����r[n] �и��
 * @author JohnnyLiao
 * @date 2015��7��29�� ����10:13:38
 */
public class CutRod {
	
	// wrong
	public int buttomUpCutRod(int n, int[] p) {
		int[] r = new int[n];
		r[0] = 0;
		int q = 0;
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < j; i++) {
				q = Math.max(q, p[i] + r[j - i]);
			}
			r[j] = q;
		}
		return r[n - 1];
	}

	public static void main(String[] args) {
		int n = 3;		//��������
		int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};		//�۸��
		
		
		CutRod c = new CutRod();
		int result = c.buttomUpCutRod(n, p);
		System.out.println(result);
	}

}
