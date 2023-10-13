//############################################################
// | cafe       | http://cafe.naver.com/dremdelover          |
// | Q&A        | https://open.kakao.com/o/gX0WnTCf          |
// | business   | ultrasuperrok@gmail.com                    |
//############################################################
// 1. 개념:
// 순열(Permutation)은 n개의 원소 중에서 r개의 원소를 순서 있게 나열한 것을 말합니다.
// 예를 들어, {A, B, C} 3개의 원소 중에서 2개를 나열하는 순열은 {A, B}, {A, C}, {B, A}, {B, C}, {C, A}, {C, B} 입니다.

// 2. 입력과 출력:
// 입력: 원소 배열(arr)과 선택할 원소의 개수(r)
// 출력: 모든 가능한 r개의 원소를 가진 순열

// 3. 시간 복잡도:
// 순열의 시간 복잡도는 O(nPr)입니다. nPr은 n! / (n-r)!로 계산됩니다.
// 이는 모든 가능한 순열을 생성해야 하기 때문입니다.

// 4. 문제 예시:
// - 암호 생성: 주어진 문자들로 만들 수 있는 모든 암호를 생성합니다.
// - 경로 탐색: 여러 도시를 방문하는 모든 가능한 경로를 찾습니다.

import java.util.ArrayList;
import java.util.List;

public class Permutation {


    public static void main(String[] args) {
        String[] arr = {"A", "B", "C"};
        int r = 2;
        List<String> perm = new ArrayList<>();
        boolean[] visited = new boolean[arr.length];
        permutation(arr, perm, visited, r);
    }

    // 5. 세부 동작과 6, 7. 주석 및 도식화:
    static void permutation(String[] arr, List<String> perm, boolean[] visited, int r) {
        // 기저 조건: r개의 원소를 모두 선택했을 때 출력하고 반환합니다.
        if (perm.size() == r) {
            System.out.println(perm);
            return;
        }

        // 재귀 호출: 모든 원소에 대해 선택하거나 선택하지 않거나 두 가지 경우를 고려합니다.
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;  // 원소를 선택합니다.
                perm.add(arr[i]);
                permutation(arr, perm, visited, r);  // 선택한 경우
                visited[i] = false;  // 원소를 다시 되돌립니다.
                perm.remove(perm.size() - 1);  // 선택하지 않은 경우
                
                permutation(["A", "B", "C"], [], [F, F, F], 2)
                /*
                │
                ├─> Add "A" to permutation
                │   permutation(["A", "B", "C"], ["A"], [T, F, F], 2)
                │   │
                │   ├─> Add "B" to permutation
                │   │   permutation(["A", "B", "C"], ["A", "B"], [T, T, F], 2)
                │   │   │
                │   │   └─> Print ["A", "B"] and return (r=2)
                │   │
                │   └─> Add "C" to permutation
                │       permutation(["A", "B", "C"], ["A", "C"], [T, F, T], 2)
                │       │
                │       └─> Print ["A", "C"] and return (r=2)
                │
                ├─> Add "B" to permutation
                │   permutation(["A", "B", "C"], ["B"], [F, T, F], 2)
                │   │
                │   ├─> Add "A" to permutation
                │   │   permutation(["A", "B", "C"], ["B", "A"], [T, T, F], 2)
                │   │   │
                │   │   └─> Print ["B", "A"] and return (r=2)
                │   │
                │   └─> Add "C" to permutation
                │       permutation(["A", "B", "C"], ["B", "C"], [F, T, T], 2)
                │       │
                │       └─> Print ["B", "C"] and return (r=2)
                │
                └─> Add "C" to permutation
                    permutation(["A", "B", "C"], ["C"], [F, F, T], 2)
                    │
                    ├─> Add "A" to permutation
                    │   permutation(["A", "B", "C"], ["C", "A"], [T, F, T], 2)
                    │   │
                    │   └─> Print ["C", "A"] and return (r=2)
                    │
                    └─> Add "B" to permutation
                        permutation(["A", "B", "C"], ["C", "B"], [F, T, T], 2)
                        │
                        └─> Print ["C", "B"] and return (r=2)

                */
            }
        }
    }
}
