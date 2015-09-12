package Algorithm.OtherButImportantToo;

import Algorithm.Sort.QuickSort_MyTest;
import Algorithm.Sort.Sort;

import java.util.Arrays;

/**
 * 寻找和为定值的两个数：
 * 输入一个数组和一个数字，在数组中查找两个数，使得它们的和正好是输入的那个数字。
 * 要求时间复杂度是O(N)。如果有多对数字的和等于输入的数字，输出任意一对即可。
 * 例如输入数组1、2、4、7、11、15和数字15。由于4+11=15，因此输出4和11。
 * Created by johnny on 15-9-12.
 */
public class SearchTowSumInArray {


    /**
     * 如果数组是无序的，先排序(N log N)，然后用两个指针i，j，各自指向数组的首尾两端，令i=0，j=n-1，然后i++，j--，逐次判断a[i]+a[j]?=sum，
     * 如果某一刻a[i]+a[j] > sum，则要想办法让sum的值减小，所以此刻i不动，j--；
     * 如果某一刻a[i]+a[j] < sum，则要想办法让sum的值增大，所以此刻i++，j不动。
     * 所以，数组无序的时候，时间复杂度最终为O(N log N + N)=O(N log N)。
     *
     * @param arr 输入数组
     * @param sum 和
     */
    // 假定数组已经从小到大有序
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
