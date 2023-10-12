import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // 1. PriorityQueue 개념 설명
        // PriorityQueue는 우선순위 큐라는 의미로, 각 요소가 우선순위를 가진 큐입니다.
        // 내부적으로 힙(Heap) 자료 구조를 사용하여 구현됩니다. 기본적으로 자바의 PriorityQueue는 최소 힙이며, 
        // 가장 낮은 우선순위의 요소가 먼저 나옵니다.

        //        [1]
        //       /   \
        //     [2]  [3]
        //    /   \
        // [4]   [5]

        // 2. 자주 사용되는 메서드 사용법 및 예시 (시간복잡도 포함)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // offer(): 요소를 추가 (시간복잡도: O(log n))
        pq.offer(4);
        pq.offer(2);
        pq.offer(5);
        pq.offer(1);
        pq.offer(3);

        // peek(): 가장 우선순위가 높은 요소를 조회하지만 제거하지 않음 (시간복잡도: O(1))
        int highestPriority = pq.peek(); // 1

        // poll(): 가장 우선순위가 높은 요소를 조회하고 제거 (시간복잡도: O(log n))
        int removed = pq.poll(); // 1

        // size(): 큐의 크기를 반환 (시간복잡도: O(1))
        int size = pq.size(); // 4

        // 3. 언제 사용하면 좋을지
        // PriorityQueue는 요소들 중에서 우선순위가 가장 높은 요소에 빠르게 접근하고 싶을 때 유용합니다.
        // 예를 들면, Dijkstra 알고리즘, 작업 스케줄링 등에서 사용됩니다.

        // 4. 비효율적인 연산
        // - PriorityQueue는 특정 요소의 삭제나 수정, 중간 요소의 접근이 O(n)으로 비효율적입니다.
        //   이러한 연산이 필요한 경우 다른 자료 구조를 고려해야 합니다.

        // 5. 도식화
        // 초기 상태: 1 -> 2 -> 3 -> 4 -> 5
        // poll() 후: 2 -> 3 -> 4 -> 5
    }
}
