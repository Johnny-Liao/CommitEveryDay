package Algorithm.OtherButImportantToo;

/**
 * Implement the binary search algorithm : a simple understand but not easy implement algorithm.
 * Created by johnny on 15-9-6.
 */
public class BinarySearch {

    /**
     * implement the binary search
     * @param array the array use to search
     * @param num search number
     * @return the position should be found, is not return -1.
     */
    public static int binarySearch(int[] array, int num) {
        if (array.length <= 0)
            return -1;
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);  // to prevent overflow and effective with binary move
            if (array[middle] > num)
                right = middle - 1;
            else if (array[middle] < num)
                left = middle + 1;
            else
                return middle;
        }
        return -1; // not found
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 7, 9, 21, 65};
        int num = 6;
        int result = binarySearch(arr, num);
        System.out.println(result);
    }
}
