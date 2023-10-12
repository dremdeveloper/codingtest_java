//############################################################
// | cafe       | http://cafe.naver.com/dremdelover          |
// | Q&A        | https://open.kakao.com/o/gX0WnTCf          |
// | business   | ultrasuperrok@gmail.com                    |
//############################################################
/**
 * 1. 개념:
 * 이진 탐색(Binary Search)은 정렬된 배열에서 특정한 원소를 찾기 위한 알고리즘입니다.
 * 이진 탐색은 배열의 중간에 있는 임의의 값을 선택하여 찾고자 하는 값 X와 비교합니다.
 * X가 중간 값보다 작으면 중간 값을 기준으로 좌측의 데이터들을 대상으로, X가 중간값보다 크면 배열의 우측을 대상으로 다시 탐색합니다.
 * 동일한 방법으로 X를 찾을 때까지 반복합니다.
 *
 * 2. 입력과 출력:
 * - 입력: 정렬된 배열 arr[], 찾고자 하는 값 X
 * - 출력: 값 X의 인덱스. 만약 X가 배열에 없다면 -1
 *
 * 3. 시간 복잡도:
 * - 이진 탐색의 시간 복잡도는 O(log N)입니다.
 * - 근거: 탐색 범위를 절반씩 줄여나가기 때문에 연산 횟수는 로그의 형태를 띕니다.
 *
 * 4. 문제 예시:
 * - 정렬된 배열이 있을 때, 특정한 값을 가장 빠르게 찾는 문제
 * - 예를 들어, 오름차순으로 정렬된 수열에서 특정한 값이 있는지 없는지 확인하는 문제를 풀 수 있습니다.
 *
 * 5. 알고리즘 세부 동작:
 * - 배열의 중간값을 찾습니다.
 * - 중간값과 찾고자 하는 값 X를 비교합니다.
 * - X가 중간값보다 작으면 왼쪽, 크면 오른쪽 부분 배열에서 다시 중간값을 찾아 비교하는 과정을 반복합니다.
 * - X를 찾으면 해당 인덱스를 반환하고, 찾지 못하면 -1을 반환합니다.
 *
 * 도식화:
 * - [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
 * - 찾고자 하는 값 X = 15
 * - 중간값 = 9 (인덱스 4)
 * - X > 9, 오른쪽 부분 배열 [11, 13, 15, 17, 19]에서 다시 탐색
 * - 중간값 = 15 (인덱스 7), 찾았으므로 인덱스 7 반환
 */

public class BinarySearchExample {

    public static int binarySearch(int[] arr, int X) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == X) {
                return mid;  // X를 찾았으므로 인덱스 반환
            } else if (arr[mid] < X) {
                left = mid + 1;  // 중간값보다 X가 크므로 오른쪽 탐색
            } else {
                right = mid - 1;  // 중간값보다 X가 작으므로 왼쪽 탐색
            }
        }
        return -1;  // X를 찾지 못했으므로 -1 반환
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int X = 15;

        int result = binarySearch(arr, X);

        if (result == -1) {
            System.out.println("Element not present in array");
        } else {
            System.out.println("Element found at index " + result);
        }
    }
}
