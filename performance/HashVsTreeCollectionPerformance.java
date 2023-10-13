//############################################################
// | cafe       | http://cafe.naver.com/dremdelover          |
// | Q&A        | https://open.kakao.com/o/gX0WnTCf          |
// | business   | ultrasuperrok@gmail.com                    |
//############################################################

/*
본 코드는 해시 기반과 트리 기반의 셋 및 맵의 성능을 비교하기 위한 것입니다.

주요 내용:
1. 해시 기반(HashSet, HashMap):
   - add, contains, remove 연산은 평균적으로 O(1)의 시간 복잡도를 가집니다.
   - 하지만 최악의 경우, 충돌이 발생하면 성능이 떨어질 수 있습니다.
2. 트리 기반(TreeSet, TreeMap):
   - add, contains, remove 연산은 O(log n)의 시간 복잡도를 가집니다.
*/

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int size = 100000;
        Integer target = size - 1; // 찾고자 하는 값

        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        // HashSet add 시간 측정
        long start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            hashSet.add(i);
        }
        long end = System.nanoTime();
        System.out.println("HashSet Add Time: " + (end - start) + " nanoseconds"); // 49335159 nano

        // TreeSet add 시간 측정
        start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            treeSet.add(i);
        }
        end = System.nanoTime();
        System.out.println("TreeSet Add Time: " + (end - start) + " nanoseconds"); // 64292811 nano

        // HashSet contains 시간 측정
        start = System.nanoTime();
        hashSet.contains(target);
        end = System.nanoTime();
        System.out.println("HashSet Contains Time: " + (end - start) + " nanoseconds"); // 25256 nano

        // TreeSet contains 시간 측정
        start = System.nanoTime();
        treeSet.contains(target);
        end = System.nanoTime();
        System.out.println("TreeSet Contains Time: " + (end - start) + " nanoseconds"); // 63243 nano

        // HashSet remove 시간 측정
        start = System.nanoTime();
        hashSet.remove(target);
        end = System.nanoTime();
        System.out.println("HashSet Remove Time: " + (end - start) + " nanoseconds"); // 21275 nano

        // TreeSet remove 시간 측정
        start = System.nanoTime();
        treeSet.remove(target);
        end = System.nanoTime();
        System.out.println("TreeSet Remove Time: " + (end - start) + " nanoseconds"); // 18865 nano
    }
}
