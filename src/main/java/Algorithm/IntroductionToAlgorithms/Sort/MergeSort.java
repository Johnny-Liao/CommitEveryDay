package Algorithm.IntroductionToAlgorithms.Sort;

/**
 * 《算法导论》《归并排序》，利用分治思想进行排序。（针对习题2.3-2）
 * 摘至：本文地址：http://mushiqianmeng.blog.51cto.com/3970029/730242
 * Test by johnny on 15-9-12.
 */
public class MergeSort {

    private static int[] input = new int[]{2, 1, 5, 4, 9, 8, 6, 7, 10, 3};

    public static void main(String[] args) {
        mergeSort(input);
        //打印数组
        printArray();
    }

    /*
        * 复杂度分析：
        * 由于采用了递归，设解决长度为n的数组需要的时间为T(n)，则分解成两个长度为n/2的子
        * 数组后，需要的时间为T(n/2)，归并需要时间Θ(n)。所以有当n>1时，T(n)=2T(n/2)+Θ(n),
        * 当n=1时，T(1)=Θ(1)
        * 解这个递归式，设Θ(1)=c,(c为常量)，则Θ(n)=cn。
        * 有上式可得T(n/2)=2T(n/4)+Θ(n/2),T(n/4)=2T(n/8)+Θ(n/4)....依次带入可得
        * 所以可以有T(n)=nT(1)+Θ(n)+2Θ(n/2)+4Θ(n/4)...+(2^lgn)Θ(n/(2^lgn)),其中共有lgn个Θ(n)相加。
        * 即T(n)=cn+cnlgn
        * 所以，时间复杂度为：Θ(nlgn)
        */
    private static int[] mergeSort(int[] array) {
        //如果数组的长度大于1，继续分解数组
        if (array.length > 1) {

            // 分

            int leftLength = array.length / 2;
            int rightLength = array.length - leftLength;
            //创建两个新的数组
            int[] left = new int[leftLength];
            int[] right = new int[rightLength];
            //将array中的值分别对应复制到两个子数组中
            for (int i = 0; i < leftLength; i++) {
                left[i] = array[i];
            }
            for (int i = 0; i < rightLength; i++) {
                right[i] = array[leftLength + i];
            }
            //递归利用归并排序，排序子数组
            left = mergeSort(left);
            right = mergeSort(right);


            // 合


            //设置初始索引
            int i = 0;
            int j = 0;
            for (int k = 0; k < array.length; k++) {
                //如果左边数据索引到达边界则取右边的值
                if (i == leftLength && j < rightLength) {
                    array[k] = right[j];
                    j++;
                    //如果右边数组索引到达边界，取左数组的值
                } else if (i < leftLength && j == rightLength) {
                    array[k] = left[i];
                    i++;
                    //如果均为到达则取，较小的值
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
