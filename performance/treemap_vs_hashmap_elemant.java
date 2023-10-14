import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
이 코드의 목적은 HashMap과 TreeMap의 검색 성능을 비교하는 것입니다.

HashMap은 내부적으로 해시 테이블을 사용하여 데이터를 저장합니다.
해시 테이블은 키를 해시 함수를 이용하여 인덱스로 변환하고, 이 인덱스를 사용하여 데이터를 빠르게 찾습니다.
이러한 특징 때문에, 일반적인 경우에, HashMap의 get 연산은 상수 시간 복잡도 O(1)을 갖습니다.
하지만, 해시 충돌이 발생할 경우 이 복잡도는 다르게 나타날 수 있습니다.

반면, TreeMap은 레드-블랙 트리 데이터 구조를 사용하여 키를 정렬된 순서로 저장합니다.
이 데이터 구조는 로그 시간 복잡도 O(log N)의 검색, 삽입, 삭제 연산을 보장합니다.
레드-블랙 트리는 균형 이진 검색 트리의 한 종류로, 각 연산이 로그 시간에 이루어지도록 트리의 균형을 유지합니다.

*/
        
public class Main {
    public static void main(String[] args) {
        int size = 1_000_000;
        
        // 데이터 준비
        Map<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> treeMap = new TreeMap<>();
        for (int i = 0; i < size; i++) {
            hashMap.put(i, "value" + i);
            treeMap.put(i, "value" + i);
        }
        
        // HashMap 검색 시간 측정
        long startTime = System.nanoTime();
        String valueFromHashMap = hashMap.get(size / 2);
        long endTime = System.nanoTime();
        System.out.println("HashMap retrieval time: " + (endTime - startTime) + "ns"); // 249439ns
        
        // TreeMap 검색 시간 측정
        startTime = System.nanoTime();
        String valueFromTreeMap = treeMap.get(size / 2);
        endTime = System.nanoTime();
        System.out.println("TreeMap retrieval time: " + (endTime - startTime) + "ns"); //86678ns
    }
}
