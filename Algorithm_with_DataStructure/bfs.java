//############################################################
// | cafe       | http://cafe.naver.com/dremdelover          |
// | Q&A        | https://open.kakao.com/o/gX0WnTCf          |
// | business   | ultrasuperrok@gmail.com                    |
//############################################################
import java.util.*;

/**
 * 1. 개념: 
 * BFS(Breadth-First Search, 너비 우선 탐색)는 그래프 또는 트리를 탐색하는 알고리즘 중 하나로, 시작 노드에서 시작하여 인접한 노드를 먼저 탐색하는 방법입니다.
 * 이 알고리즘은 큐(Queue)를 사용하여 구현되며, 방문한 노드를 차례대로 저장하고 꺼내서 탐색합니다.
 * 
 * 2. 입력과 출력:
 * - 입력: 그래프의 시작 노드
 * - 출력: 시작 노드로부터의 너비 우선 탐색 결과
 * 
 * 3. 시간 복잡도:
 * - BFS의 시간 복잡도는 O(V + E)입니다. 여기서 V는 노드의 수, E는 엣지의 수입니다.
 * - 근거: 모든 노드와 엣지를 한 번씩 방문하므로 이러한 복잡도를 가집니다.
 * 
 * 4. 문제 예시:
 * - 미로 찾기, 최단 경로 찾기 등의 문제에서 BFS를 사용할 수 있습니다.
 * - 예를 들어, 미로에서 시작점에서 출구까지의 최단 경로를 찾는 문제를 BFS로 해결할 수 있습니다.
 * 
 * 5. 알고리즘 세부 동작:
 * - 시작 노드를 큐에 넣고, 방문했다는 표시를 합니다.
 * - 큐에서 노드를 하나 꺼내고, 해당 노드의 인접 노드 중 방문하지 않은 노드를 모두 큐에 넣고, 방문했다는 표시를 합니다.
 * - 큐가 비어있지 않다면, 위의 과정을 반복합니다.
 * - 큐가 비어있다면, 알고리즘을 종료합니다.
 */

public class BFSExample {
    // 그래프를 인접 리스트로 표현
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    // 노드의 방문 정보를 저장하는 배열
    static boolean[] visited;

    public static void bfs(int start) {
        // 큐(Queue)의 생성
        Queue<Integer> queue = new LinkedList<>();
        // 시작 노드를 큐에 넣고 방문 처리
        queue.offer(start);
        visited[start] = true;

        // 큐가 비어있지 않는 한 계속해서 탐색
        while (!queue.isEmpty()) {
            // 큐에서 하나의 원소를 뽑아 출력
            int x = queue.poll();
            System.out.print(x + " ");

            // 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
            for (int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if (!visited[y]) {
                    queue.offer(y);
                    visited[y] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        // 그래프 초기화
        for (int i = 0; i < 8; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 노드 0에 연결된 노드 정보 저장 
        graph.get(0).add(1);
        graph.get(0).add(2);

        // 노드 1에 연결된 노드 정보 저장 
        graph.get(1).add(0);
        graph.get(1).add(3);
        graph.get(1).add(4);

        // 노드 2에 연결된 노드 정보 저장 
        graph.get(2).add(0);
        graph.get(2).add(4);

        // 노드 3에 연결된 노드 정보 저장 
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        // 노드 4에 연결된 노드 정보 저장 
        graph.get(4).add(1);
        graph.get(4).add(2);
        graph.get(4).add(3);
        graph.get(4).add(5);

        // 노드 5에 연결된 노드 정보 저장 
        graph.get(5).add(3);
        graph.get(5).add(4);

        // 방문 정보 배열 초기화
        visited = new boolean[8];

        // BFS 알고리즘 실행
        bfs(0);

/*
Graph:
0 -> [1, 2]
1 -> [0, 3, 4]
2 -> [0, 4]
3 -> [1, 4, 5]
4 -> [1, 2, 3, 5]
5 -> [3, 4]

BFS 과정:

1. 시작 노드 0을 큐에 넣고 방문 처리를 합니다.
Queue: [0]
Visited: [0]

2. 큐에서 노드 0을 꺼내고, 0과 인접하면서 아직 방문하지 않은 노드 1, 2를 큐에 넣고 방문 처리합니다.
Queue: [1, 2]
Visited: [0, 1, 2]

3. 큐에서 노드 1을 꺼내고, 1과 인접하면서 아직 방문하지 않은 노드 3, 4를 큐에 넣고 방문 처리합니다.
Queue: [2, 3, 4]
Visited: [0, 1, 2, 3, 4]

4. 큐에서 노드 2를 꺼내고, 2와 인접하면서 아직 방문하지 않은 노드가 없으므로 그대로 진행합니다.
Queue: [3, 4]
Visited: [0, 1, 2, 3, 4]

5. 큐에서 노드 3을 꺼내고, 3과 인접하면서 아직 방문하지 않은 노드 5를 큐에 넣고 방문 처리합니다.
Queue: [4, 5]
Visited: [0, 1, 2, 3, 4, 5]

6. 큐에서 노드 4를 꺼내고, 4와 인접하면서 아직 방문하지 않은 노드가 없으므로 그대로 진행합니다.
Queue: [5]
Visited: [0, 1, 2, 3, 4, 5]

7. 큐에서 노드 5를 꺼내고, 5와 인접하면서 아직 방문하지 않은 노드가 없으므로 그대로 진행합니다.
Queue: []
Visited: [0, 1, 2, 3, 4, 5]

8. 큐가 비어있으므로 BFS를 종료합니다.
*/

    }
}
