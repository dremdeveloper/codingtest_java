import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        // 1. HashMap 개념 설명
        // HashMap은 키(key)와 값(value)의 쌍으로 데이터를 저장하는 자료 구조입니다.
        // 내부적으로 해시 테이블을 사용하여 데이터를 저장하며, 키에 대한 해시값을 계산하여 데이터의 위치를 결정합니다.
        // 따라서, 특정 키를 이용해 빠르게 데이터를 검색할 수 있습니다.

        // key: "A" | hash("A") | value: 1
        // key: "B" | hash("B") | value: 2
        // ... 

        // 2. 자주 사용되는 메서드 사용법 및 예시 (시간복잡도 포함)
        HashMap<String, Integer> map = new HashMap<>();

        // put(): 키와 값을 맵에 추가 (시간복잡도: 평균 O(1), 최악의 경우 O(n))
        map.put("A", 1);
        map.put("B", 2);

        // get(): 키를 이용하여 값을 조회 (시간복잡도: 평균 O(1), 최악의 경우 O(n))
        int aValue = map.get("A"); // 1

        // containsKey(): 키가 맵에 존재하는지 확인 (시간복잡도: 평균 O(1), 최악의 경우 O(n))
        boolean hasB = map.containsKey("B"); // true

        // remove(): 키를 이용하여 값을 제거 (시간복잡도: 평균 O(1), 최악의 경우 O(n))
        map.remove("A");

        // size(): 맵의 크기를 반환 (시간복잡도: O(1))
        int size = map.size(); // 1

        // 3. 언제 사용하면 좋을지
        // HashMap은 특정 키를 기반으로 빠르게 데이터를 검색, 추가, 제거해야 할 때 유용합니다.
        // 예를 들면, 빈도수 계산, 중복 요소 판별, 데이터 캐싱 등에서 사용됩니다.

        // 4. 비효율적인 연산
        // - 순서가 보장되지 않기 때문에, 순서에 민감한 연산을 수행하려면 TreeMap과 같은 다른 자료 구조를 사용해야 합니다.
        // - HashMap은 내부적으로 배열과 연결 리스트(또는 트리)로 구현되어 있어, 데이터가 많아질수록 충돌이 늘어나 성능 저하가 발생할 수 있습니다.

        // 5. 도식화
        // | Key | Hash | Value |
        // |-----|------|-------|
        // | "A" | ..01 | 1     |
        // | "B" | ..02 | 2     |
        // (후에 "A"는 제거됨)
    }
}
