package Algorithm.IntroductionToAlgorithms.DynamicProgramming;

/**
 * 利用动态规划来求解钢条切割问题： <br>
 * 输入：长度为  n英寸的钢条、价格表 p(i=1,i=2,...)<br>
 * 输出：r[n] 切割方案
 * @author JohnnyLiao
 * @date 2015年7月29日 上午10:13:38
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
		int n = 3;		//钢条长度
		int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};		//价格表
		
		
		CutRod c = new CutRod();
		int result = c.buttomUpCutRod(n, p);
		System.out.println(result);
	}

}
