import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        // 1. LinkedList 개념 설명
        // LinkedList는 노드(Node)들의 연결로 이루어진 연결 리스트(Linked List)를 기반으로 하는 자료 구조입니다.
        // 각 노드는 데이터와 다음 노드를 가리키는 참조(주소)로 구성됩니다.
        // 이 구조 덕분에 중간에 데이터를 삽입하거나 삭제하는 것이 간단합니다.

        // Node A --> Node B --> Node C
        // (data, next)   (data, next)   (data, null)

        // 2. 자주 사용되는 메서드 사용법 및 예시 (시간복잡도 포함)
        LinkedList<String> list = new LinkedList<>();

        // add(): 요소를 리스트의 끝에 추가 (시간복잡도: O(1))
        list.add("A");
        list.add("B");
        list.add("C");

        // add(index, element): 주어진 인덱스에 요소를 삽입 (시간복잡도: O(n) in the worst case)
        list.add(1, "X"); // ["A", "X", "B", "C"]

        // get(): 주어진 인덱스의 요소를 반환 (시간복잡도: O(n) in the worst case)
        String secondElement = list.get(1); // "X"

        // remove(): 주어진 인덱스의 요소를 삭제 (시간복잡도: O(n) in the worst case)
        list.remove(1); // ["A", "B", "C"]

        // size(): 리스트의 크기를 반환 (시간복잡도: O(1))
        int size = list.size(); // 3

        // 3. 언제 사용하면 좋을지
        // LinkedList는 중간 위치에 요소를 삽입하거나 삭제할 때 유용합니다.
        // 메모리 할당의 유연성이 필요할 때, 즉 크기를 동적으로 변경해야 할 경우에도 좋습니다.

        // 4. 비효율적인 연산
        // - LinkedList는 인덱스 기반의 접근에 비효율적입니다. 중간 위치의 요소에 접근하려면 처음부터 순회해야 할 수 있습니다.
        //   빠른 임의 접근이 필요한 경우 ArrayList와 같은 동적 배열을 사용하는 것이 좋습니다.

        // 5. 도식화
        // 초기 상태: "A" --> "B" --> "C"
        // 삽입 후: "A" --> "X" --> "B" --> "C"
        // 삭제 후: "A" --> "B" --> "C"
    }
}
