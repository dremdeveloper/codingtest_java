import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        // 1. Queue 개념 설명
        // Queue는 FIFO(First-In-First-Out) 원칙에 따라 동작하는 자료 구조입니다.
        // 즉, 먼저 들어온 요소가 먼저 나가게 됩니다.
        // 자바에서는 Queue 인터페이스를 통해 여러 종류의 큐를 사용할 수 있습니다. LinkedList, ArrayDeque 등이 해당됩니다.

        // [Front] A -> B -> C [Rear]

        // 2. 자주 사용되는 메서드 사용법 및 예시 (시간복잡도 포함)
        Queue<String> queue = new LinkedList<>();

        // offer(): 큐의 끝에 요소 추가 (시간복잡도: O(1))
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");

        // peek(): 큐의 시작 부분의 요소를 조회하지만 제거하지는 않음 (시간복잡도: O(1))
        String frontElement = queue.peek(); // "A"

        // poll(): 큐의 시작 부분의 요소를 조회하고 제거 (시간복잡도: O(1))
        String removedElement = queue.poll(); // "A"

        // size(): 큐의 크기를 반환 (시간복잡도: O(1) for LinkedList)
        int size = queue.size(); // 2

        // 3. 언제 사용하면 좋을지
        // 큐는 순차적인 처리가 필요한 경우나, 먼저 들어온 요소를 먼저 처리해야하는 상황에 사용하면 좋습니다.
        // 예를 들면, 작업 스케줄링, 데이터 버퍼링 등에서 사용됩니다.

        // 4. 비효율적인 연산
        // - LinkedList를 사용하는 경우 중간 요소의 접근 및 수정이 O(n)으로 비효율적입니다.
        //   해당 연산이 필요하다면 ArrayList나 ArrayDeque를 고려할 수 있습니다.
        // - 큐의 모든 요소에 순차적으로 접근이 필요한 경우에는 리스트를 사용하는 것이 더 적합합니다.

        // 5. 도식화
        // 초기: [Front] A -> B -> C [Rear]
        // A 제거 후: [Front] B -> C [Rear]
    }
}
