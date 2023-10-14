import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
이 코드의 목적은 크게 두 가지입니다:
1. HashMap과 TreeMap에 동일한 데이터를 삽입하고, 동일한 범위의 키를 대상으로 데이터를 검색합니다.
2. 두 가지 데이터 구조를 사용하여 범위 기반 검색을 수행할 때의 성능 차이를 비교합니다.

HashMap은 해싱을 기반으로 한 데이터 구조로, 키를 해시 함수를 통해 변환하여 특정 버킷에 데이터를 저장합니다.
따라서 개별 키에 대한 조회, 삽입, 삭제 연산은 상수 시간 O(1)에 이루어질 수 있습니다. 하지만 범위 기반의 검색(예: x <= key < y)
에 대해서는 모든 엔트리를 순회해야 하므로 선형 시간 O(N)이 걸립니다.

반면, TreeMap은 레드-블랙 트리를 기반으로 한 데이터 구조로, 키를 정렬된 순서로 유지합니다.
개별 키에 대한 조회, 삽입, 삭제 연산은 O(log N) 시간에 이루어집니다. 또한, 주어진 범위에 대한 서브맵을
O(log N) 시간에 얻을 수 있으며, 이 서브맵 내의 엔트리를 순회하는 데에 O(k)의 시간이 걸립니다(k는 서브맵의 크기).
따라서 범위 기반 검색은 TreeMap에서 더 효율적으로 이루어집니다.
*/
        
public class Main {
    public static void main(String[] args) {
        int size = 1_000_000;

        Map<Integer, String> hashMap = new HashMap<>();
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        for (int i = 0; i < size; i++) {
            hashMap.put(i, "value" + i);
            treeMap.put(i, "value" + i);
        }

        int lowerBound = size / 2;
        int upperBound = (size / 2) + 100;

        // HashMap 범위 검색 시간 측정
        long startTime = System.nanoTime();
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            if (entry.getKey() >= lowerBound && entry.getKey() < upperBound) {
                //do nothing
            }
        }
        long endTime = System.nanoTime();
        System.out.println("HashMap range retrieval time: " + (endTime - startTime) + "ns"); //44274846 ns

        // TreeMap 범위 검색 시간 측정
        startTime = System.nanoTime();
        Map<Integer, String> subMap = treeMap.subMap(lowerBound, upperBound);
        for (Map.Entry<Integer, String> entry : subMap.entrySet()) {
           //do nothing
        }
        endTime = System.nanoTime();
        System.out.println("TreeMap range retrieval time: " + (endTime - startTime) + "ns"); //641127 ns
    }
}
