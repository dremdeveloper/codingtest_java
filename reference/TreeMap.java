import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        // 1. TreeMap 개념 설명
        // TreeMap은 키(key)와 값(value)의 쌍으로 데이터를 저장하는 자료 구조입니다.
        // 내부적으로 레드-블랙 트리(Red-Black Tree)로 구현되어 있으며, 키를 기준으로 정렬된 순서로 데이터를 저장합니다.
        // 따라서, 키의 순서에 따른 정렬이나 범위 검색이 용이합니다.

        //         "B"
        //       /     \
        //     "A"     "C"

        // 2. 자주 사용되는 메서드 사용법 및 예시 (시간복잡도 포함)
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        // put(): 키와 값을 맵에 추가 (시간복잡도: O(log n))
        treeMap.put("B", 2);
        treeMap.put("A", 1);
        treeMap.put("C", 3);

        // get(): 키를 이용하여 값을 조회 (시간복잡도: O(log n))
        int aValue = treeMap.get("A"); // 1

        // firstKey(): 가장 낮은 키를 반환 (시간복잡도: O(log n))
        String firstKey = treeMap.firstKey(); // "A"

        // lastKey(): 가장 높은 키를 반환 (시간복잡도: O(log n))
        String lastKey = treeMap.lastKey(); // "C"

        // higherKey(): 주어진 키보다 큰 가장 낮은 키를 반환 (시간복잡도: O(log n))
        String nextKey = treeMap.higherKey("A"); // "B"

        // size(): 맵의 크기를 반환 (시간복잡도: O(1))
        int size = treeMap.size(); // 3

        // 3. 언제 사용하면 좋을지
        // TreeMap은 키의 순서에 따른 정렬이나 범위 검색이 필요한 경우에 사용하면 좋습니다.
        // 예를 들면, 순서가 중요한 데이터 캐싱, 구간 별 통계 계산 등에서 사용됩니다.
        
        // 4. 도식화
        // 초기 상태:
        //        B(2)
        //      /      \
        //   A(1)     C(3)
    }
}
