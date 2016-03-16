package org.lsh.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 工具类：根据Map的值排序
 * Created by Johnny Liao on 2016/3/16.
 */
public class SortMap<K, V extends Number> implements Comparator<Map.Entry<K, V>> {

    /**
     * 比较方法：值由大到小排序
     */
    public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
        return (int) (o2.getValue().floatValue() * 1000 - o1.getValue().floatValue() * 1000);
    }

    /**
     * 把值乱序的Map转化成按值排序的Map
     *
     * @param unSortedMap 未排序的Map
     * @return 排序后的Map
     */
    public static <K, V extends Number> Map<K, V> mapSorter(Map<K, V> unSortedMap) {
        List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>();
        list.addAll(unSortedMap.entrySet());
        // sort list based on comparator
        Collections.sort(list, new SortMap<K, V>());
        // put sorted list into map again
        Map<K, V> sortedMap = new LinkedHashMap<K, V>();
        for (Iterator<Map.Entry<K, V>> it = list.iterator(); it.hasNext(); ) {
            Map.Entry<K, V> entry = it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    /**
     * 工具方法：输出Map
     *
     * @param map 待输出Map
     */
    public static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey()
                    + "\t Value : " + entry.toString());
        }
    }
}
