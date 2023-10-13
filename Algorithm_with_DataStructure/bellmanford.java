//############################################################
// | cafe       | http://cafe.naver.com/dremdelover          |
// | Q&A        | https://open.kakao.com/o/gX0WnTCf          |
// | business   | ultrasuperrok@gmail.com                    |
//############################################################
// 1. 벨만-포드 알고리즘의 개념:
// 벨만-포드 알고리즘은 그래프 내의 한 정점에서 다른 모든 정점으로의 최단 경로를 찾는 알고리즘입니다.
// 음의 가중치를 가진 간선도 처리할 수 있으며, 음의 가중치 사이클도 감지할 수 있습니다.

// 2. 입력과 출력:
// 입력: 그래프(정점과 간선의 정보 포함)
// 출력: 시작 정점으로부터 모든 다른 정점까지의 최단 거리

// 3. 시간 복잡도:
// O(VE), V는 정점의 수, E는 간선의 수입니다.
// 각 정점에 대해, 모든 간선을 E번 검사하므로 VE 시간이 소요됩니다.

// 4. 문제 예시:
// 한 도시에서 다른 도시로 가는 버스 노선이 주어졌을 때, 최소 비용으로 도시를 이동하는 방법을 찾는 문제

// 5. 알고리즘의 세부 동작:
// - 모든 정점까지의 거리를 무한대로 초기화합니다(시작 정점은 0으로 초기화).
// - 시작 정점에서 도달할 수 있는 모든 정점에 대해, 간선을 통해 도달할 수 있는 정점의 거리를 업데이트합니다.
// - 이 과정을 V-1번 반복합니다.
// - 마지막으로, 음의 가중치 사이클이 있는지 확인합니다.

/*
간선 정보:
0 -> 1 (-1)
0 -> 2 (4)
1 -> 2 (3)
1 -> 3 (2)
1 -> 4 (2)
3 -> 2 (5)
3 -> 1 (1)
4 -> 3 (-3)

벨만-포드 알고리즘 동작 과정:
1. 모든 정점까지의 거리를 무한대로 초기화하고, 시작 정점의 거리는 0으로 초기화합니다.
   dist[] = [0, INF, INF, INF, INF]

2. 시작 정점에서 도달할 수 있는 모든 정점의 거리를 업데이트합니다. 이 과정을 V-1번 반복합니다.
   - 첫 번째 반복에서:
     dist[] = [0, -1, 4, INF, INF]
   - 두 번째 반복에서:
     dist[] = [0, -1, 2, 1, 1]
   - 세 번째 반복에서:
     dist[] = [0, -1, 2, -2, 1]
   - 네 번째 반복에서:
     dist[] = [0, -1, 2, -2, 1]

3. 음의 가중치 사이클이 있는지 확인합니다. 만약 V번째 반복에서도 값이 업데이트 된다면, 그래프에 음의 사이클이 존재합니다.
   이 예시에서는 업데이트되지 않으므로 음의 사이클은 없습니다.

결과:
정점까지의 거리:
0       0
1       -1
2       2
3       -2
4       1
*/

import java.util.Arrays;

public class BellmanFordAlgorithm {

    // 그래프의 간선을 표현하기 위한 클래스
    static class Edge {
        int src, dest, weight;
        Edge() {
            src = dest = weight = 0;
        }
    };

    // 그래프를 표현하기 위한 클래스
    static class Graph {
        int V, E;
        Edge edge[];

        // V개의 정점과 E개의 간선을 가진 그래프를 생성
        Graph(int v, int e) {
            V = v;
            E = e;
            edge = new Edge[E];
            for (int i = 0; i < e; ++i)
                edge[i] = new Edge();
        }
    }

    // 벨만-포드 알고리즘 구현
    void BellmanFord(Graph graph, int src) {
        int V = graph.V, E = graph.E;
        int dist[] = new int[V];

        // 모든 거리를 무한대로 초기화하고, 시작 정점의 거리는 0으로 초기화합니다.
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // 시작 정점에서 도달할 수 있는 모든 정점의 거리를 업데이트합니다.
        // 이 과정을 V-1번 반복합니다.
        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                int weight = graph.edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        // 음의 가중치 사이클이 있는지 확인합니다.
        for (int j = 0; j < E; ++j) {
            int u = graph.edge[j].src;
            int v = graph.edge[j].dest;
            int weight = graph.edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("그래프에 음의 가중치 사이클이 포함되어 있습니다.");
                return;
            }
        }

        // 결과를 출력합니다.
        printArr(dist, V);
    }

    // 거리 배열을 출력하는 함수
    void printArr(int dist[], int V) {
        System.out.println("정점까지의 거리:");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }

    // 메인 함수
    public static void main(String[] args) {
        int V = 5; // 정점의 수
        int E = 8; // 간선의 수

        Graph graph = new Graph(V, E);

        // 간선 정보를 추가합니다. (src, dest, weight)
        // 예: graph.edge[0].src = 0, graph.edge[0].dest = 1, graph.edge[0].weight = -1 은
        // 정점 0에서 정점 1로의 가중치가 -1인 간선을 의미합니다.
        // 아래의 간선 정보를 바탕으로 그래프를 구성해보세요.

        // 예시 코드:
        // 간선 정보를 추가합니다. (src, dest, weight)
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;

        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;

        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;

        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;

        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;

        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;

        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;

        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;

        BellmanFordAlgorithm algo = new BellmanFordAlgorithm();
        algo.BellmanFord(graph, 0); // 0번 정점을 시작 정점으로 알고리즘을 실행합니다.

    }
}
