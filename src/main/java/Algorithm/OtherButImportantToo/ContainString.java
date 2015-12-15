package Algorithm.OtherButImportantToo;

/**
 * �ж��ַ���A���Ƿ�����ַ���B�������ַ�.
 * Created by Johnny Liao on 15-9-3.
 */
public class ContainString {

    // ��һ�뷨����hashmap��ʵ�֣�����ͨ��λ�����ܴﵽO(1)�Ŀռ�Ч�ʣ�ʱ��Ч�ʶ�ΪO(n + m)
    public boolean contain(String A, String B) {
        int hash = 0;
        for (int i = 0; i < A.length(); i++) {
            hash |= (1 << A.charAt(i));             // ʹ��λ����������hashmap
        }
        for (int i = 0; i < B.length(); i++) {
            if ((hash & (1 << B.charAt(i))) == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String A = "dkjadkaj";
        String B = "jkm";
        ContainString cs = new ContainString();
        boolean result = cs.contain(A, B);
        System.out.println("A is " + (result ? "" : "not ") + "contain B");

    }
}
