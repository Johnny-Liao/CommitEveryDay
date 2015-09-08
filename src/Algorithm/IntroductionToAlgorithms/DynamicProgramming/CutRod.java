package Algorithm.IntroductionToAlgorithms.DynamicProgramming;

/**
 * ���ö�̬�滮(bottom-up method �Ե����Ϸ�)���������и����⣺ <br>
 * ���룺����Ϊ  nӢ��ĸ������۸�� p(i=1,i=2,...)<br>
 * �����r[n] ����и���ó�����Ѽ۸�
 *
 * @author JohnnyLiao
 * @date 2015��7��29�� ����10:13:38
 */
public class CutRod {

    // �Ե�����
    public int buttomUpCutRod(int n, int[] p) {
        int[] r = new int[n  + 1];    // Ϊ�����ɳ���Ϊn�ļ۸�
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
        int n = 4;        //��������
        int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};        //�۸��

        CutRod c = new CutRod();
        int result = c.buttomUpCutRod(n, p);
        System.out.println(result);
    }

}
