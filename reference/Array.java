public class ArrayExample {
    public static void main(String[] args) {
        // 1. Array 개념 설명
        // Array는 동일한 데이터 타입의 원소들로 이루어진 자료 구조입니다. 
        // 각 원소는 인덱스로 접근할 수 있습니다.
        // 배열의 크기는 선언 시에 결정되며, 변경할 수 없습니다.

        //   인덱스: 0   1   2
        // ┌──────┬──────┬──────┐
        // │  "A" │  "B" │  "C" │
        // └──────┴──────┴──────┘

        // 2. 자주 사용되는 메서드 사용법 및 예시 (시간복잡도 포함)
        String[] array = new String[3];

        // 배열에 값 할당 (시간복잡도: O(1))
        array[0] = "A";
        array[1] = "B";
        array[2] = "C";

        // 배열에서 값 가져오기 (시간복잡도: O(1))
        String firstElement = array[0]; // "A"

        // 배열의 길이 확인 (시간복잡도: O(1))
        int length = array.length; // 3

        // 3. 언제 사용하면 좋을지
        // 배열은 연속적인 메모리 공간을 필요로 할 때 사용합니다.
        // 빠른 인덱스 기반의 접근이 필요한 경우에도 배열을 사용하는 것이 좋습니다.

        // 4. 비효율적인 연산
        // - 배열의 크기는 고정되어 있으므로, 크기를 늘리거나 줄이려면 새 배열을 만들고 데이터를 복사해야 합니다. (시간복잡도: O(n))
        // - 중간에 요소를 삽입하거나 제거하는 것도 불편하며, 이 경우에도 데이터의 복사가 필요합니다. (시간복잡도: O(n))
        //   이러한 동적인 연산이 필요한 경우 ArrayList나 다른 동적 배열을 사용하는 것이 좋습니다.

        // 5. 도식화
        // 초기: ["A", "B", "C"]
        // 값 변경 후 (예: array[1] = "X"): ["A", "X", "C"]
    }
}