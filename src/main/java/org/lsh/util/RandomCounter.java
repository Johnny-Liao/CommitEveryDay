package org.lsh.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Generate random number with controllable rate.
 * Created by Johnny Liao on 2016/7/29.
 */
public class RandomCounter {

    public static void main(String[] args) {
        Random random = new Random();
        int temp;
        Map<Integer, Integer> map = new HashMap<>(10);
        int[] rateController = {1, 2, 3, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 10, 10, 10};
        for (int i = 0; i < 5000; i++) {
            temp = random.nextInt(rateController.length) + 1;
            int num = rateController[temp - 1];
            if (map.get(num) == null)
                map.put(num, 1);
            else
                map.put(num, map.get(num) + 1);
        }
        for (Integer key : map.keySet()) {
            System.out.println(key + " " + map.get(key) * 10000 / 5000);
        }
        System.out.println(map);
    }
}
