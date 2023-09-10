package cn.god23bin.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author god23bin
 * @created 2023/3/26 22:51
 */
public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(64);
        for (int i = 0; i < 64; ++i) {
            hashMap.put(i, i + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
        Set<Integer> integers = hashMap.keySet();
        new Thread(
            () -> {
              for (int i = 2; i < 13; ++i) {
                hashMap.put(i, i + 2);
                System.out.println(i + "-----");
              }
            })
        .start();
        for (Integer key : integers) {
            System.out.println(hashMap.get(key));
        }
    }
}
