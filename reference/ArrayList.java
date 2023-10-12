import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        // 1. ArrayList 개념 설명
        // ArrayList는 자바의 List 인터페이스를 구현하는 동적 배열입니다.
        // 내부적으로 데이터를 배열로 관리하며, 배열이 꽉 차면 크기를 자동으로 늘립니다.
        // 순차적인 접근에 뛰어난 성능을 보이지만, 중간 데이터의 추가나 삭제에는 비효율적입니다.

        // ┌───┬───┬───┐
        // │ 0 │ 1 │ 2 │ <- 인덱스
        // └───┴───┴───┘
        //   │   │   │
        //   A   B   C   <- 값

        ArrayList<String> list = new ArrayList<>();

        // 2. 자주 사용되는 메서드 사용법 및 예시 (시간복잡도 포함)
        // add(): 리스트의 끝에 요소 추가 (시간복잡도: O(1), 최악의 경우 O(n) - 배열의 확장 필요 시)
        list.add("A");
        list.add("B");
        list.add("C");

        // add(index, element): 지정한 위치에 요소 추가 (시간복잡도: O(n) - 중간 요소를 이동해야 할 경우)
        list.add(1, "X"); // 1번 위치에 "X"를 추가. [A, X, B, C]

        // get(index): 지정한 위치의 요소를 반환 (시간복잡도: O(1))
        String elementAt1 = list.get(1); // "X"

        // remove(index): 지정한 위치의 요소를 제거 (시간복잡도: O(n) - 중간 요소를 이동해야 할 경우)
        list.remove(1); // 1번 위치의 "X" 제거. [A, B, C]

        // size(): 리스트의 크기 반환 (시간복잡도: O(1))
        int size = list.size(); // 3

        // contains(Object): 리스트가 특정 요소를 포함하는지 확인 (시간복잡도: O(n))
        boolean containsA = list.contains("A"); // true

        // 3. 언제 사용하면 좋을지
        // 순차적인 접근이 필요하거나, 크기가 동적으로 변경될 수 있는 상황에서 사용하면 좋습니다.
        // 배열과 달리 크기를 미리 지정할 필요가 없습니다.

        // 4. 비효율적인 연산
        // - 중간 위치에 데이터를 추가/삭제하는 연산은 비효율적입니다. LinkedList를 사용하면 이러한 연산의 시간복잡도를 개선할 수 있습니다.
        // - 크기가 고정된 상황에서는 단순 배열을 사용하는 것이 메모리 효율성이 더 좋을 수 있습니다.

        // 5. 도식화
        // 초기: [A, B, C]
        // 1번 위치에 X 추가 후: [A, X, B, C]
        // 1번 위치의 X 제거 후: [A, B, C]
    }
}
