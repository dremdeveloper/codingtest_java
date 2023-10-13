import java.util.Arrays;

public class BinarySearchExample {
    public static void main(String[] args) {
        // 1. BinarySearch 개념 설명
        // Binary Search(이진 탐색)은 정렬된 배열에서 특정 원소를 빠르게 찾는 탐색 알고리즘입니다.
        // 중간 위치의 원소를 확인하고, 찾는 값과 비교하여 대상 범위를 절반으로 줄여나갑니다.

        //  예시 배열: [1, 3, 5, 7, 9]
        //  찾는 값: 5
        //  중간값: 5 (찾았습니다!)

        // 2. 자주 사용되는 메서드 사용법 및 예시 (시간복잡도 포함)
        int[] arr = {1, 3, 5, 7, 9};

        // binarySearch(): 주어진 배열에서 특정 값을 이진 탐색으로 찾아 인덱스를 반환합니다.
        // 성공 시: 해당 값의 인덱스, 실패 시: 음수 값 반환 (시간복잡도: O(log n))
        int index = Arrays.binarySearch(arr, 5); // 2

        // 3. 언제 사용하면 좋을지
        // BinarySearch는 정렬된 배열에서 원소를 빠르게 찾아야 할 때 사용하면 좋습니다.
        // 배열의 크기가 클수록 선형 검색에 비해 훨씬 빠른 성능을 보입니다.
        
        // 4. 도식화
        // 초기 배열: | 1 | 3 | 5 | 7 | 9 |
        // 찾는 값: 5
        // 첫 번째 스텝: 중간값 = 5 --> 찾았습니다! (인덱스 2 반환)
    }
}
