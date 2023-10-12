import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExample {
    public static void main(String[] args) {
        // 1. Deque 개념 설명
        // Deque(덱)는 Double-Ended Queue의 약자로 양쪽 끝에서 추가와 제거가 모두 가능한 자료 구조입니다.
        // Deque는 Stack과 Queue의 기능을 모두 가지고 있습니다.

        // [Front] A <- B -> C [Rear]

        // 2. 자주 사용되는 메서드 사용법 및 예시 (시간복잡도 포함)
        Deque<String> deque = new ArrayDeque<>();

        // addFirst(), offerFirst(): 덱의 앞쪽에 요소 추가 (시간복잡도: O(1))
        deque.addFirst("A");
        deque.offerFirst("B"); // [Front] B -> A [Rear]

        // addLast(), offerLast(): 덱의 뒷쪽에 요소 추가 (시간복잡도: O(1))
        deque.addLast("C");
        deque.offerLast("D"); // [Front] B -> A -> C -> D [Rear]

        // peekFirst(): 덱의 앞쪽 요소를 조회하지만 제거하지는 않음 (시간복잡도: O(1))
        String firstElement = deque.peekFirst(); // "B"

        // peekLast(): 덱의 뒷쪽 요소를 조회하지만 제거하지는 않음 (시간복잡도: O(1))
        String lastElement = deque.peekLast(); // "D"

        // pollFirst(): 덱의 앞쪽 요소를 조회하고 제거 (시간복잡도: O(1))
        String removedFirst = deque.pollFirst(); // "B"

        // pollLast(): 덱의 뒷쪽 요소를 조회하고 제거 (시간복잡도: O(1))
        String removedLast = deque.pollLast(); // "D"

        // size(): 덱의 크기를 반환 (시간복잡도: O(1))
        int size = deque.size(); // 2

        // 3. 언제 사용하면 좋을지
        // 덱은 양쪽에서의 추가와 제거가 필요한 상황에서 유용합니다.
        // 예를 들면, 슬라이딩 윈도우 알고리즘 또는 특정 구간의 최대/최소 값을 빠르게 구하는 문제 등에서 사용됩니다.

        // 4. 비효율적인 연산
        // - ArrayDeque를 사용할 경우 중간 요소의 접근 및 수정이 O(n)으로 비효율적입니다.
        //   해당 연산이 필요하다면 LinkedList를 사용하거나 다른 자료 구조를 고려해야 합니다.

        // 5. 도식화
        // 초기: [Front] B -> A -> C -> D [Rear]
        // B와 D 제거 후: [Front] A -> C [Rear]
    }
}
