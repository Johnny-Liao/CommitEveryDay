package Algorithm.IntroductionToAlgorithms.DynamicProgramming;

/**
 * 利用动态规划(bottom-up method 自底向上法)来求解钢条切割问题： <br>
 * 输入：长度为  n英寸的钢条、价格表 p(i=1,i=2,...)<br>
 * 输出：r[n] 最佳切割方案得出的最佳价格
 *
 * @author JohnnyLiao
 * @date 2015年7月29日 上午10:13:38
 */
public class CutRod {

    // wrong
    public int buttomUpCutRod(int n, int[] p) {
        int[] r = new int[n  + 1];    // 为了容纳长度为n的价格
		r[0] = 0;
        int q;
        for (int j = 0; j <= n; j++) {
            q = 0;
            for (int i = 0; i < j; i++) {
                q = Math.max(q, (p[i] + r[j - i - 1]));
            }
            r[j] = q;
        }
        return r[n];
    }

    public static void main(String[] args) {
        int n = 4;        //钢条长度
        int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};        //价格表

        CutRod c = new CutRod();
        int result = c.buttomUpCutRod(n, p);
        System.out.println(result);
    }

}
