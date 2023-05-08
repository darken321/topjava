package ru.javawebinar.topjava;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @see <a href="http://topjava.herokuapp.com">Demo application</a>
 * @see <a href="https://github.com/JavaOPs/topjava">Initial project</a>
 */
public class Main {
    public static void main(String[] args) {
        System.out.format("Hello TopJava Enterprise!");
        //TODO удалить тесты ниже
        System.out.println();
        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("first", 11);
        myMap.put("second", 22);
        myMap.put("third", 33);
        myMap.put("fourth", 44);

        for (Map.Entry<String, Integer> entry : myMap.entrySet()) {
            System.out.println(entry);
        }
        System.out.println();
        Integer newKey = myMap.merge("new key", 444, (v1, v2) -> v1 + v2);
        Integer second = myMap.merge("second", 6, (v1, v2) -> v1 + v2);

        System.out.println();
        for (Map.Entry<String, Integer> entry : myMap.entrySet()) {
            System.out.println(entry);
        }
//        Set<Map.Entry<String, Integer>> entrySet = myMap.entrySet();
//        System.out.println("простой цикл");
//        for (int i = 0; i <entrySet.size(); i++) {
//            System.out.println(entrySet.toArray()[i]);
//        }
//        Set<String> strings = myMap.keySet();
//        for (String key: strings) {
//            System.out.println("Key " + myMap.get(key) + " value " + key);
//        }
//        Collection<Integer> values = myMap.values();
//        for (Integer val: myMap.values()){
//            System.out.println("value " + val);
//        }
    }
    private static Integer apply(Integer v1, Integer v2) {
        return v1 + v2 + 2;
    }
}
