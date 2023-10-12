//############################################################
// | cafe       | http://cafe.naver.com/dremdelover          |
// | Q&A        | https://open.kakao.com/o/gX0WnTCf          |
// | business   | ultrasuperrok@gmail.com                    |
//############################################################
public class LCS {

    // 1. 개념:
    // LCS(Longest Common Subsequence)는 두 문자열에서 순서를 유지하며 동일하게 나타나는 부분 문자열 중 가장 긴 것을 찾는 문제입니다.
    // 예를 들어, "ABCBDAB"와 "BDCAB"의 LCS는 "BCAB"입니다.

    // 2. 입력과 출력:
    // 입력: 두 문자열 X, Y
    // 출력: 두 문자열의 LCS의 길이 및 LCS 문자열

    // 3. 시간 복잡도:
    // LCS 알고리즘의 시간 복잡도는 O(mn)입니다. 여기서 m과 n은 각각 두 입력 문자열의 길이입니다.
    // 이는 2차원 배열을 사용하여 각 문자열의 모든 부분 문자열에 대해 LCS를 계산하기 때문입니다.

    // 4. 문제 예시:
    // - DNA 서열 정렬: 두 DNA 서열 간의 유사성을 찾습니다.
    // - 파일 비교: 두 파일의 유사한 줄을 찾아내어 차이를 표시합니다.

    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCAB";
        int[][] lcsLength = lcsLength(X, Y);
        System.out.println("Length of LCS: " + lcsLength[X.length()][Y.length()]);
        System.out.println("LCS: " + buildLCS(lcsLength, X, X.length(), Y.length()));
    }

static int[][] lcsLength(String X, String Y) {
    int m = X.length();
    int n = Y.length();
    int[][] c = new int[m + 1][n + 1];

    // 5. 세부 동작과 6, 7. 주석 및 도식화:
    // i와 j는 각각 X와 Y의 인덱스를 나타냅니다.
    // c[i][j]는 X의 i번째 문자와 Y의 j번째 문자까지의 LCS의 길이를 저장합니다.
    // c 배열은 다음과 같이 채워집니다:
    //
    //   |   | B | D | C | A | B |
    //   |---|---|---|---|---|---|
    //   |   | 0 | 0 | 0 | 0 | 0 |
    //   | A | 0 | 0 | 0 | 1 | 1 |
    //   | B | 0 | 1 | 1 | 1 | 2 |
    //   | C | 0 | 1 | 2 | 2 | 2 |
    //   | B | 0 | 1 | 2 | 2 | 3 |
    //   | D | 0 | 2 | 2 | 2 | 3 |
    //   | A | 0 | 2 | 2 | 3 | 3 |
    //   | B | 0 | 2 | 2 | 3 | 4 |
    //
    // 각 셀은 다음과 같이 계산됩니다:
    // - X[i] == Y[j]: c[i][j] = c[i-1][j-1] + 1
    // - X[i] != Y[j]: c[i][j] = max(c[i-1][j], c[i][j-1])
    //
    // 이렇게 계산된 c 배열은 X와 Y의 LCS의 길이를 c[m][n]에 저장하고 있습니다.

    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                c[i][j] = c[i - 1][j - 1] + 1;
            } else {
                c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
            }
        }
    }
    return c;
}


    static String buildLCS(int[][] c, String X, int i, int j) {
        // c 배열을 사용하여 LCS를 구축합니다.
        if (i == 0 || j == 0) {
            return "";
        } else if (X.charAt(i - 1) == X.charAt(j - 1)) {
            return buildLCS(c, X, i - 1, j - 1) + X.charAt(i - 1);
        } else {
            if (c[i - 1][j] > c[i][j - 1]) {
                return buildLCS(c, X, i - 1, j);
            } else {
                return buildLCS(c, X, i, j - 1);
            }
        }
    }
}
