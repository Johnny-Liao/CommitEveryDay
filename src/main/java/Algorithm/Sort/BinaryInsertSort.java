package Algorithm.Sort;

import java.util.Arrays;

/**
 * ’€∞Î≤Â»Î≈≈–Ú
 * 
 * @author JohnnyLiao
 */
public class BinaryInsertSort implements Sort {

	public static void binaryInsertSort(DataWrap[] data) {
		System.out.println("’€∞Î≤Â»Î≈≈–Ú£∫");
		for (int i = 1; i < data.length; i++) {
			DataWrap tmp = data[i];
			int low = 0;
			int high = i - 1;
			while (low <= high) {
				int mid = (high + low) / 2;			// notice : it's plus
				if (tmp.compareTo(data[mid]) > 0)
					low = mid + 1;
				else 
					high = mid -1;
			}
			// low = high data[low] <= tmp
			for (int j = i; j > low; j--) {
				data[j] = data[j - 1];
			}
			data[low] = tmp;
			System.out.println(Arrays.toString(data));
		}
	}
	
	@Override
	public void sort(DataWrap[] data) {
		binaryInsertSort(data);
	}
	
}
