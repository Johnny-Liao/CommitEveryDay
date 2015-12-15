package Algorithm.IntroductionToAlgorithms.Sort;

/**
 * ���㷨���ۡ����鲢���򡷣����÷���˼��������򡣣����ϰ��2.3-2��
 * ժ�������ĵ�ַ��http://mushiqianmeng.blog.51cto.com/3970029/730242
 * Test by johnny on 15-9-12.
 */
public class MergeSort {

    private static int[] input = new int[]{2, 1, 5, 4, 9, 8, 6, 7, 10, 3};

    public static void main(String[] args) {
        mergeSort(input);
        //��ӡ����
        printArray();
    }

    /*
        * ���Ӷȷ�����
        * ���ڲ����˵ݹ飬��������Ϊn��������Ҫ��ʱ��ΪT(n)����ֽ����������Ϊn/2����
        * �������Ҫ��ʱ��ΪT(n/2)���鲢��Ҫʱ�䦨(n)�������е�n>1ʱ��T(n)=2T(n/2)+��(n),
        * ��n=1ʱ��T(1)=��(1)
        * ������ݹ�ʽ���覨(1)=c,(cΪ����)����(n)=cn��
        * ����ʽ�ɵ�T(n/2)=2T(n/4)+��(n/2),T(n/4)=2T(n/8)+��(n/4)....���δ���ɵ�
        * ���Կ�����T(n)=nT(1)+��(n)+2��(n/2)+4��(n/4)...+(2^lgn)��(n/(2^lgn)),���й���lgn����(n)��ӡ�
        * ��T(n)=cn+cnlgn
        * ���ԣ�ʱ�临�Ӷ�Ϊ����(nlgn)
        */
    private static int[] mergeSort(int[] array) {
        //�������ĳ��ȴ���1�������ֽ�����
        if (array.length > 1) {

            // ��

            int leftLength = array.length / 2;
            int rightLength = array.length - leftLength;
            //���������µ�����
            int[] left = new int[leftLength];
            int[] right = new int[rightLength];
            //��array�е�ֵ�ֱ��Ӧ���Ƶ�������������
            for (int i = 0; i < leftLength; i++) {
                left[i] = array[i];
            }
            for (int i = 0; i < rightLength; i++) {
                right[i] = array[leftLength + i];
            }
            //�ݹ����ù鲢��������������
            left = mergeSort(left);
            right = mergeSort(right);


            // ��


            //���ó�ʼ����
            int i = 0;
            int j = 0;
            for (int k = 0; k < array.length; k++) {
                //������������������߽���ȡ�ұߵ�ֵ
                if (i == leftLength && j < rightLength) {
                    array[k] = right[j];
                    j++;
                    //����ұ�������������߽磬ȡ�������ֵ
                } else if (i < leftLength && j == rightLength) {
                    array[k] = left[i];
                    i++;
                    //�����Ϊ������ȡ����С��ֵ
                } else if (i < leftLength && j < rightLength) {
                    if (left[i] > right[j]) {
                        array[k] = right[j];
                        j++;
                    } else {
                        array[k] = left[i];
                        i++;
                    }
                }
            }
        }
        return array;
    }

    private static void printArray() {
        for (int i : input) {
            System.out.print(i + " ");
        }
    }
}
