    /*
        함수 설명:
        - matrixChainOrder: 행렬들의 곱셈에서 최소 곱셈 연산 횟수를 반환합니다.
        
        변수 설명:
        - p[]: 행렬의 차원을 저장하는 배열. p[i-1] x p[i]는 i번째 행렬의 차원입니다.
        - m[][]: m[i][j]는 i번째부터 j번째 행렬까지의 최소 곱셈 연산 횟수입니다.
        
        시간 복잡도:
        - O(n^3): 세 개의 중첩 루프를 사용하므로입니다.
        
        사용 경우:
        - 연속된 행렬의 곱셈에서 최소 연산 횟수를 알고 싶을 때 사용합니다.

        상세 동작 과정:
        1. m[i][j]를 최소 곱셈 연산 횟수로 초기화합니다.
        2. 행렬 체인의 길이 L을 2에서 n까지 순회합니다.
        3. i는 시작 행렬을 결정하고, j는 i에서 L만큼 떨어진 행렬을 결정합니다.
        4. k는 i와 j 사이의 행렬을 순회하며 m[i][j]를 갱신합니다.
        5. m[1][n-1]이 첫 번째부터 마지막 행렬까지의 최소 곱셈 연산 횟수입니다.
        
        예) arr = {1, 2, 3, 4, 3}
        - m[1][1], m[2][2], m[3][3], m[4][4] = 0 초기화
        - L=2, i=1 -> m[1][2] 계산 -> k=1 -> q = m[1][1] + m[2][2] + p[0]*p[1]*p[2] = 0 + 0 + 1*2*3 = 6
        - 이와 같은 방식으로 나머지 m[i][j]를 계산
        - m[1][4]가 최종 결과값이 됨
    */
public class MatrixChainMultiplication {

    // 행렬 체인의 최적의 곱셈 순서를 찾는 함수
    static int matrixChainOrder(int[] p, int n) {
        // m[i][j]: 행렬 i부터 j까지의 최소 곱셈 횟수를 저장하는 이차원 배열
        int[][] m = new int[n][n];

        // 주 대각선을 0으로 초기화 (i==j일 때 곱셈 연산이 필요 없기 때문)
        for (int i = 1; i < n; i++) {
            m[i][i] = 0;
        }

        // L: 곱하려고 하는 행렬의 개수
        for (int L = 2; L < n; L++) {
            // i: 시작 행렬 인덱스
            for (int i = 1; i < n - L + 1; i++) {
                // j: 마지막 행렬 인덱스
                int j = i + L - 1;
                // m[i][j]를 최대값으로 초기화
                m[i][j] = Integer.MAX_VALUE;
                // k: 행렬을 나눌 위치 (i <= k < j)
                for (int k = i; k <= j - 1; k++) {
                    // q: 현재 i~j 범위에서의 k를 사용한 행렬 곱셈의 최소값
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    // q가 기존의 m[i][j] 값보다 작다면 업데이트
                    if (q < m[i][j]) {
                        m[i][j] = q;
                    }
                }
            }
        }
        // 1부터 n-1까지의 행렬 체인의 최소 곱셈 횟수 반환
        return m[1][n - 1];
    }

    public static void main(String[] args) {
        // 행렬의 차원을 저장하는 배열
        // arr[i-1] x arr[i] 는 i번째 행렬의 차원을 의미한다.
        int[] arr = new int[]{1, 2, 3, 4, 3};
        // 행렬의 수 + 1 (행렬 차원 배열의 길이)
        int n = arr.length;

        // 최소 곱셈 횟수를 출력
        System.out.println("Minimum number of multiplications: " + matrixChainOrder(arr, n));
    }
}
