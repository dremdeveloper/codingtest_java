//############################################################
// | cafe       | http://cafe.naver.com/dremdelover          |
// | Q&A        | https://open.kakao.com/o/gX0WnTCf          |
// | business   | ultrasuperrok@gmail.com                    |
//############################################################

/**
 * 1. 개념:
 * 백트래킹(Backtracking)은 해를 찾는 도중에 '막히면' (즉, 해가 아니면) 되돌아가서 다시 해를 찾는 기법입니다.
 * 가지치기(Pruning)를 통해 불필요한 경로를 차단합니다.
 * 일반적으로 DFS(깊이 우선 탐색)을 기반으로 하며, 문제의 조건에 따라 Pruning을 추가하여 불필요한 탐색을 줄입니다.
 *
 * 2. 입력과 출력:
 * - 입력: 없음 (예제에서는 숫자 N을 사용하여 N-Queens 문제를 해결합니다.)
 * - 출력: 모든 가능한 해 (N-Queens 문제의 경우, 모든 퀸이 서로 공격할 수 없는 위치의 집합)
 *
 * 3. 시간 복잡도:
 * - 최악의 경우, O(N!) (N-Queens 문제에서 모든 가능한 배치를 고려해야 할 때)
 * - 가지치기를 통해 실제로는 모든 경우를 탐색하지 않고 문제를 해결할 수 있습니다.
 *
 * 4. 문제 예시:
 * - N-Queens 문제: N x N 체스판에 N개의 퀸을 배치하는데, 퀸들이 서로를 공격할 수 없도록 배치해야 합니다.
 *
 * 5. 알고리즘 세부 동작:
 * - 체스판의 각 행에 퀸을 배치하면서 진행합니다.
 * - 퀸을 배치할 때마다 현재 배치가 유효한지(즉, 퀸들이 서로 공격할 수 없는지) 확인합니다.
 * - 만약 유효하지 않다면, 이전 행으로 돌아가서 다른 위치에 퀸을 배치합니다.
 * - 모든 행에 퀸을 배치하면 하나의 해를 찾은 것입니다.
 *
  * 도식화:
 * - 백트래킹 알고리즘은 트리 형태로 도식화할 수 있습니다. 여기서 각 노드는 하나의 상태(퀸의 배치)를 나타내고, 
 *   각 에지는 상태 변환(다음 행으로의 이동)을 나타냅니다.
 * - 예를 들어, 4-Queens 문제에서 첫 번째 행에 퀸을 배치한 상태를 루트 노드로 하고, 
 *   그 자식 노드들은 두 번째 행의 각 열에 퀸을 배치한 상태를 나타냅니다.
 * 
 * 예시:
 * 
 * Level 1: 
 * [Q . . .]  <- 루트 노드 (첫 번째 행에 퀸 배치)
 * [. . . .]
 * [. . . .]
 * [. . . .]
 * 
 * Level 2: 
 * [Q . . .]  <- 부모 노드
 * [. . . .]
 * [. . . .]
 * [. . . .]
 * 
 * 자식 노드들:
 * [Q . . .]  [Q . . .]  [Q . . .]  [Q . . .]
 * [. Q . .]  [. . Q .]  [. . . Q]  [. . . Q]
 * [. . . .]  [. . . .]  [. . . .]  [. . . .]
 * [. . . .]  [. . . .]  [. . . .]  [. . . .]
 * 
 * - 루트 노드에서 자식 노드로 이동하면서, 각각의 자식 노드에서도 같은 방식으로 다음 행에 퀸을 배치합니다.
 * - 만약 어떤 노드에서 유효하지 않은 상태(퀸들이 서로 공격할 수 있는 상태)가 발생하면, 그 노드에서는 더 이상 자식 노드를 생성하지 않고, 
 *   백트래킹하여 이전 노드(부모 노드)로 돌아갑니다.
 * - 이러한 과정을 반복하면서, 모든 행에 퀸을 배치할 수 있는 상태(리프 노드)를 찾으면, 그 상태를 하나의 해로 저장합니다.
 */


/**
 * isSafe 메서드에서 왼쪽 대각선과 오른쪽 대각선의 퀸의 배치를 확인하는 로직에 대한 설명입니다.
 *
 * 왼쪽 대각선 확인:
 * - 왼쪽 대각선은 행과 열의 인덱스가 동시에 감소하는 방향입니다.
 * - 예를 들어, (3, 3) 위치에 퀸이 있다면, (2, 2), (1, 1), (0, 0) 등의 위치는 왼쪽 대각선 상에 있습니다.
 * - 따라서, 현재 위치에서 왼쪽 위 대각선을 확인하려면 행과 열의 인덱스를 동시에 감소시키면서 이동하며 확인합니다.
 *
 * 오른쪽 대각선 확인:
 * - 오른쪽 대각선은 행의 인덱스는 감소하고, 열의 인덱스는 증가하는 방향입니다.
 * - 예를 들어, (3, 1) 위치에 퀸이 있다면, (2, 2), (1, 3) 등의 위치는 오른쪽 대각선 상에 있습니다.
 * - 따라서, 현재 위치에서 오른쪽 위 대각선을 확인하려면 행의 인덱스는 감소시키고, 열의 인덱스는 증가시키면서 이동하며 확인합니다.
 *
 * 이러한 원리를 바탕으로 isSafe 메서드에서는 현재 배치하려는 퀸의 위치와 기존에 배치된 퀸들이 대각선 상에 있는지를 확인하여
 * 퀸들이 서로 공격할 수 없는 위치에 배치되도록 합니다.
 */

import java.util.ArrayList;
import java.util.List;

public class BacktrackingExample {
    static int N = 4;  // 체스판의 크기 및 퀸의 수
    static List<List<String>> solutions = new ArrayList<>();

    public static boolean isSafe(char[][] board, int row, int col) {
        // 같은 열에 퀸이 있는지 확인
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 왼쪽 대각선에 퀸이 있는지 확인
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 오른쪽 대각선에 퀸이 있는지 확인
        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void solveNQueens(char[][] board, int row) {
        if (row == N) {
            // 하나의 해를 찾았으므로 결과 리스트에 추가
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                solution.add(new String(board[i]));
            }
            solutions.add(solution);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 'Q';  // 퀸 배치
                solveNQueens(board, row + 1);  // 다음 행으로 이동
                board[row][i] = '.';  // 백트래킹 (퀸 제거)
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(board[i], '.');
        }

        solveNQueens(board, 0);

        // 결과 출력
        System.out.println("One of the solutions is:");
        for (String row : solutions.get(0)) {
            System.out.println(row);
        }
    }
}
