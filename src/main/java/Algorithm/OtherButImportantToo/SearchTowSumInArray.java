package Algorithm.OtherButImportantToo;

import Algorithm.Sort.QuickSort_MyTest;
import Algorithm.Sort.Sort;

import java.util.Arrays;

/**
 * Ѱ�Һ�Ϊ��ֵ����������
 * ����һ�������һ�����֣��������в�����������ʹ�����ǵĺ�������������Ǹ����֡�
 * Ҫ��ʱ�临�Ӷ���O(N)������ж�����ֵĺ͵�����������֣��������һ�Լ��ɡ�
 * ������������1��2��4��7��11��15������15������4+11=15��������4��11��
 * Created by johnny on 15-9-12.
 */
public class SearchTowSumInArray {


    /**
     * �������������ģ�������(N log N)��Ȼ��������ָ��i��j������ָ���������β���ˣ���i=0��j=n-1��Ȼ��i++��j--������ж�a[i]+a[j]?=sum��
     * ���ĳһ��a[i]+a[j] > sum����Ҫ��취��sum��ֵ��С�����Դ˿�i������j--��
     * ���ĳһ��a[i]+a[j] < sum����Ҫ��취��sum��ֵ�������Դ˿�i++��j������
     * ���ԣ����������ʱ��ʱ�临�Ӷ�����ΪO(N log N + N)=O(N log N)��
     *
     * @param arr ��������
     * @param sum ��
     */
    // �ٶ������Ѿ���С��������
    public static void towSum(int[] arr, int sum) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int nowSum = arr[i] + arr[j];
            if (nowSum < sum) {
                i++;
            } else if (nowSum > sum) {
                j--;
            } else {
                System.out.println(arr[i] + " + " + arr[j] + " = " + sum);
                break;
            }
        }
    }

    // if need sort, use this
    private static void quickSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = position(arr, p, r);
            quickSort(arr, p, q - 1);
            quickSort(arr, q + 1, r);
        }
    }

    private static int position(int[] arr, int start, int end) {
        int base = arr[end];
        int i = start;
        int j;
        for (j = start; j < end; j++) {
            if (arr[j] < base) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, end);
        System.out.println(Arrays.toString(arr));
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 7, 9};
        towSum(arr, 5);

        int[] arr2 = {1, 2, 3, 10, 8, 1, 9};
        quickSort(arr2, 0 , arr2.length - 1);
        towSum(arr2, 11);
    }
}
