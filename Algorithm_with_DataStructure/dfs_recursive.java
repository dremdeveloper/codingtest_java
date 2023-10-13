//############################################################
// | cafe       | http://cafe.naver.com/dremdelover          |
// | Q&A        | https://open.kakao.com/o/gX0WnTCf          |
// | business   | ultrasuperrok@gmail.com                    |
//############################################################
/**
 * 1. 개념:
 * DFS(Depth-First Search, 깊이 우선 탐색)는 그래프 또는 트리를 탐색하는 알고리즘 중 하나로, 시작 노드에서 시작하여
 * 가능한 깊게 노드를 탐색하는 방법입니다. DFS는 스택 또는 재귀 함수를 사용하여 구현할 수 있습니다.
 *
 * 2. 입력과 출력:
 * - 입력: 그래프의 시작 노드
 * - 출력: 시작 노드로부터의 깊이 우선 탐색 결과
 *
 * 3. 시간 복잡도:
 * - DFS의 시간 복잡도는 O(V + E)입니다. 여기서 V는 노드의 수, E는 엣지의 수입니다.
 * - 근거: 모든 노드와 엣지를 한 번씩 방문하므로 이러한 복잡도를 가집니다.
 *
 * 4. 문제 예시:
 * - 연결 요소 찾기, 사이클 찾기 등의 문제에서 DFS를 사용할 수 있습니다.
 * - 예를 들어, 그래프 내에서 서로 연결된 노드의 집합(연결 요소)을 찾는 문제를 DFS로 해결할 수 있습니다.
 *
 * 5. 알고리즘 세부 동작:
 * - 시작 노드를 방문 처리하고, 해당 노드의 인접 노드 중 방문하지 않은 노드에 대해 재귀적으로 DFS 함수를 호출합니다.
 * - 모든 인접 노드를 방문했다면 함수를 종료합니다.
 *
 * 도식화:
 * - 그래프를 도식화하여 표현하면 다음과 같습니다.
 *   [0] -- [1] -- [3]
 *    |      |      |
 *   [2] -- [4] -- [5]
 * - DFS 탐색 순서: 0 -> 1 -> 3 -> 5 -> 4 -> 2
 */

/*
Graph:
0 -> [1, 2]
1 -> [0, 3, 4]
2 -> [0, 4]
3 -> [1, 5]
4 -> [1, 2, 5]
5 -> [3, 4]

DFS 과정:

1. 시작 노드 0을 스택에 넣고 방문 처리를 합니다.
Stack: [0]
Visited: [0]

2. 스택의 최상단 노드 0과 인접하면서 아직 방문하지 않은 노드 1을 스택에 넣고 방문 처리합니다.
Stack: [0, 1]
Visited: [0, 1]

3. 스택의 최상단 노드 1과 인접하면서 아직 방문하지 않은 노드 3을 스택에 넣고 방문 처리합니다.
Stack: [0, 1, 3]
Visited: [0, 1, 3]

4. 스택의 최상단 노드 3과 인접하면서 아직 방문하지 않은 노드 5를 스택에 넣고 방문 처리합니다.
Stack: [0, 1, 3, 5]
Visited: [0, 1, 3, 5]

5. 스택의 최상단 노드 5와 인접하면서 아직 방문하지 않은 노드 4를 스택에 넣고 방문 처리합니다.
Stack: [0, 1, 3, 5, 4]
Visited: [0, 1, 3, 5, 4]

6. 스택의 최상단 노드 4와 인접하면서 아직 방문하지 않은 노드 2를 스택에 넣고 방문 처리합니다.
Stack: [0, 1, 3, 5, 4, 2]
Visited: [0, 1, 3, 5, 4, 2]

7. 스택의 최상단 노드 2와 인접하면서 아직 방문하지 않은 노드가 없으므로, 스택에서 노드 2를 제거합니다.
Stack: [0, 1, 3, 5, 4]
Visited: [0, 1, 3, 5, 4, 2]

8. 이후 스택이 빌 때까지 스택의 최상단 노드와 인접한 노드를 방문하고 스택에 넣는 과정을 반복합니다. 만약 인접한 노드가 없다면 스택에서 노드를 제거합니다.

9. 스택이 비어있으므로 DFS를 종료합니다.
*/
import java.util.*;

public class DFSExample {
    // 그래프를 인접 리스트로 표현
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    // 노드의 방문 정보를 저장하는 배열
    static boolean[] visited;

    public static void dfs(int node) {
        // 현재 노드를 방문 처리
        visited[node] = true;
        System.out.print(node + " ");

        // 인접 노드를 확인
        for (int i = 0; i < graph.get(node).size(); i++) {
            int y = graph.get(node).get(i);
            // 방문하지 않은 인접 노드가 있다면
            if (!visited[y]) {
                dfs(y);  // 재귀 호출
            }
        }
    }

    public static void main(String[] args) {
        // 그래프 초기화
        for (int i = 0; i < 6; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 그래프의 노드 연결 정보 설정
        graph.get(0).add(1); graph.get(0).add(2);
        graph.get(1).add(0); graph.get(1).add(3); graph.get(1).add(4);
        graph.get(2).add(0); graph.get(2).add(4);
        graph.get(3).add(1); graph.get(3).add(5);
        graph.get(4).add(1); graph.get(4).add(2); graph.get(4).add(5);
        graph.get(5).add(3); graph.get(5).add(4);

        // 방문 정보 배열 초기화
        visited = new boolean[6];

        // DFS 알고리즘 실행
        dfs(0);

    }
}
