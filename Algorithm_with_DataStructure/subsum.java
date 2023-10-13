//############################################################
// | cafe       | http://cafe.naver.com/dremdelover          |
// | Q&A        | https://open.kakao.com/o/gX0WnTCf          |
// | business   | ultrasuperrok@gmail.com                    |
//############################################################
/*
    subsetSum 함수:
    - set: 전체 집합을 포함하는 배열입니다.
    - subset: 현재까지 고려된 부분 집합입니다.
    - sum: 현재 subset의 합입니다.
    - target: 찾고자 하는 합입니다.
    - idx: 다음으로 고려해볼 원소의 인덱스입니다.
    
    시간 복잡도:
    - 백트래킹을 이용한 부분합 문제의 최악의 경우 시간 복잡도는 O(2^n)입니다. 
    - 이는 모든 가능한 부분 집합을 고려해야 하는 경우 발생합니다.
    
    사용 경우:
    - 주어진 집합의 부분 집합 중 특정 합을 가지는 집합을 찾고자 할 때 사용합니다.
    - 모든 가능한 조합을 탐색하는 문제에서 사용하기 적합합니다.
    
    상세 동작 과정:
    1. 만약 현재 subset의 합(sum)이 목표 값(target)과 동일하다면 subset을 출력합니다.
    2. 만약 모든 원소를 고려했다면(즉, idx == set.size()이라면) 더 이상 탐색하지 않고 반환합니다.
    3. 현재 idx 위치의 원소를 subset에 추가하고, 이에 대해 재귀 호출을 합니다.
    4. idx 위치의 원소를 subset에서 제거(백트래킹)하고, idx를 증가시켜 다음 원소에 대해 재귀 호출을 합니다.

    예) set = [10, 7, 5, 18, 12, 20, 15], target = 35
    1. subset = [10], sum = 10, idx = 1
    2. subset = [10, 7], sum = 17, idx = 2
    3. subset = [10, 7, 5], sum = 22, idx = 3
    4. subset = [10, 7, 5, 18], sum = 40, idx = 4 (sum > target 이므로 이 루트는 더 이상 탐색하지 않아도 됩니다.)
    5. subset = [10, 7, 5, 12], sum = 34, idx = 5
    6. subset = [10, 7, 5, 12, 20], sum = 54, idx = 6 (sum > target)
    ... (이하 과정 생략)
    최종 결과: [10, 7, 18], [10, 5, 20] 등이 출력될 수 있습니다.
*/
import java.util.ArrayList;

public class SubsetSum {
    static void subsetSum(ArrayList<Integer> set, ArrayList<Integer> subset, int sum, int target, int idx) {
        // 기저 조건 1: 'sum'이 'target'과 같다면, 'subset'을 출력하고 리턴합니다.
        if (sum == target) {
            System.out.println(subset);
            return;
        }

        // 기저 조건 2: 'idx'가 'set'의 크기와 같다면 리턴합니다. (더 이상 확인할 요소가 없음)
        if (idx == set.size()) return;

        // 현재 idx의 요소를 subset에 추가합니다.
        subset.add(set.get(idx));
        // 재귀 호출: idx의 다음 요소와 현재까지의 합(sum + set.get(idx))를 가지고 다시 함수를 호출합니다.
        subsetSum(set, subset, sum + set.get(idx), target, idx + 1);
        // 현재 idx의 요소를 subset에서 제거합니다. (백트래킹)
        subset.remove(subset.size() - 1);
        // 재귀 호출: idx의 다음 요소와 현재까지의 합(sum)을 가지고 다시 함수를 호출합니다. 
        // 이 호출은 현재 요소를 포함하지 않고 다음 요소로 넘어갑니다.
        subsetSum(set, subset, sum, target, idx + 1);
    }

    public static void main(String[] args) {
        // 테스트를 위한 숫자 집합을 생성합니다.
        ArrayList<Integer> set = new ArrayList<>();
        set.add(10);
        set.add(7);
        set.add(5);
        set.add(18);
        set.add(12);
        set.add(20);
        set.add(15);
        // 함수를 호출하여 결과를 찾습니다. 처음 호출시 부분 집합(subset)은 비어있고, 합계(sum)은 0, 인덱스(idx)는 0입니다.
        subsetSum(set, new ArrayList<>(), 0, 35, 0);
    }
}
