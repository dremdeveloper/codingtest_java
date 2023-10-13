//############################################################
// | cafe       | http://cafe.naver.com/dremdelover          |
// | Q&A        | https://open.kakao.com/o/gX0WnTCf          |
// | business   | ultrasuperrok@gmail.com                    |
//############################################################
// 1. Union-Find 알고리즘의 개념:
// Union-Find는 원소들의 집합을 표현하는 자료구조로, 두 원소가 같은 집합에 속해 있는지 판별하거나,
// 두 집합을 합치는 연산을 효율적으로 수행하기 위해 사용됩니다.

// 2. 입력과 출력:
// - union(a, b): 원소 a, b를 포함하는 두 집합을 합칩니다. 반환값은 없습니다.
// - find(a): 원소 a가 속한 집합의 대표 원소(루트 노드)를 반환합니다.

// 3. 시간 복잡도:
// - union: O(log N), N은 원소의 개수입니다.
// - find: O(log N), N은 원소의 개수입니다.
// 경로 압축(Path Compression)과 유니온-바이-랭크(Union-by-Rank) 최적화 기법을 사용하여
// 시간 복잡도를 상당히 줄일 수 있습니다.

// 4. 문제 예시:
// - 네트워크 연결 상태 확인: 컴퓨터 네트워크에서 두 컴퓨터가 연결되어 있는지 확인하는 문제
// - 사이클 판별: 그래프 내에 사이클이 존재하는지 확인하는 문제

// Step 1: 초기화
// 각 원소는 자신만을 원소로 가진 집합의 대표입니다.
// [0] [1] [2] [3] [4]

// Step 2: uf.union(0, 1);
// 원소 0과 1이 속한 집합을 합칩니다. 이제 0과 1은 같은 집합에 속해 있습니다.
// [0, 1] [2] [3] [4]

// Step 3: uf.union(2, 3);
// 원소 2와 3이 속한 집합을 합칩니다. 이제 2와 3은 같은 집합에 속해 있습니다.
// [0, 1] [2, 3] [4]

// Step 4: uf.union(1, 4);
// 원소 1과 4가 속한 집합을 합칩니다. 이제 1, 0, 4는 같은 집합에 속해 있습니다.
// [0, 1, 4] [2, 3]

// Step 5: uf.find(0) == uf.find(4);
// 원소 0과 4는 같은 집합에 속해 있습니다. 따라서 find(0) == find(4)는 true를 반환합니다.

// Step 6: uf.find(0) == uf.find(2);
// 원소 0과 2는 다른 집합에 속해 있습니다. 따라서 find(0) == find(2)는 false를 반환합니다.


public class UnionFind {
    private int[] parent;  // 각 원소의 부모 노드 정보를 저장하는 배열
    private int[] rank;    // 각 루트 노드가 대표하는 트리의 높이를 저장하는 배열

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];

        // 초기화: 모든 원소는 각각 자신만을 원소로 가진 집합의 대표입니다.
        for (int i = 0; i < size; i++) {
            parent[i] = i;  // 각 원소의 부모는 자기 자신입니다.
            rank[i] = 0;    // 각 트리의 높이는 0으로 초기화합니다.
        }
    }

    // find 연산: 원소 x를 포함하는 집합의 대표 원소를 찾습니다.
    public int find(int x) {
        // x의 부모가 x와 같다면, x는 루트 노드입니다.
        if (parent[x] == x) {
            return x;
        } else {
            // 경로 압축: x의 부모를 x의 루트 노드로 바로 연결합니다.
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }

    // union 연산: 원소 x, y를 포함하는 두 집합을 합칩니다.
    public void union(int x, int y) {
        int rootX = find(x);  // x의 루트 노드를 찾습니다.
        int rootY = find(y);  // y의 루트 노드를 찾습니다.

        // 두 원소가 이미 같은 집합에 속해 있다면, 아무 것도 하지 않습니다.
        if (rootX == rootY) {
            return;
        }

        // 두 트리를 합칠 때, 높이가 더 낮은 트리를 높이가 더 높은 트리에 붙입니다.
        // 이렇게 하면 트리의 높이가 최대한 작게 유지됩니다.
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;  // 두 트리의 높이가 같을 때만 높이가 1 증가합니다.
        }
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(5);  // 5개의 원소를 가진 Union-Find 자료구조를 생성합니다.

        uf.union(0, 1);  // 원소 0, 1이 속한 집합을 합칩니다.
        uf.union(2, 3);  // 원소 2, 3이 속한 집합을 합칩니다.
        uf.union(1, 4);  // 원소 1, 4가 속한 집합을 합칩니다.

        // 원소 0, 4는 같은 집합에 속해 있습니다.
        System.out.println("0과 4는 같은 집합에 속해 있나요? " + (uf.find(0) == uf.find(4)));  // 출력: true

        // 원소 0, 2는 다른 집합에 속해 있습니다.
        System.out.println("0과 2는 같은 집합에 속해 있나요? " + (uf.find(0) == uf.find(2)));  // 출력: false

    }
}
