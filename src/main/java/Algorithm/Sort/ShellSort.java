package Algorithm.Sort;

import java.util.Arrays;

public class ShellSort implements Sort{

	public static void shellSort(DataWrap[] data) {
		System.out.println("Shell≈≈–Ú£∫");
		int arrayLength = data.length;
		int h = 1;
		while (h <= arrayLength / 3)
			h = h * 3 + 1;
		while (h > 0) {
			System.out.println("===hµƒ÷µ£∫" + h + "===");
			for (int i = h; i < arrayLength; i++) {
				DataWrap tmp = data[i];
				if (data[i].compareTo(data[i - h]) < 0) {
					int j = i -h;
					for ( ; j >= 0 && data[j].compareTo(tmp) > 0; j-=h) {
						data[j + h] = data[j];
					}
					data[j + h] = tmp;
				}
				System.out.println(Arrays.toString(data));
			}
			h = (h - 1) / 3;
		}
	}
	
	@Override
	public void sort(DataWrap[] data) {
		shellSort(data);
	}

}
