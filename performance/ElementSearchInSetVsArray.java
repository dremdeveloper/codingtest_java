//############################################################
// | cafe       | http://cafe.naver.com/dremdelover          |
// | Q&A        | https://open.kakao.com/o/gX0WnTCf          |
// | business   | ultrasuperrok@gmail.com                    |
//############################################################
import java.util.HashSet;
import java.util.Set;

public class ElementSearchPerformanceTest {

    /*
    본 코드는 자바에서 Set과 배열에서 원소 탐색의 성능을 비교하기 위한 것입니다.

    주요 내용:
    1. Set에서 원소 탐색:
       - Set은 내부적으로 해시 테이블을 사용하여 원소를 저장합니다. 
       - 평균적으로 원소의 존재 여부를 확인하는데 O(1)의 시간 복잡도를 가집니다.
       - 그러나 최악의 경우, 해시 충돌이 발생하면 성능이 떨어질 수 있습니다.
    2. 배열에서 원소 탐색:
       - 배열에서 원소의 존재 여부를 확인하려면 배열의 모든 원소를 검사해야 할 수 있습니다.
       - 따라서 배열에서 원소의 존재 여부를 확인하는데 O(n)의 시간 복잡도를 가집니다.
    */

    public static void main(String[] args) {
        int size = 100000;
        int target = size - 1; // 찾고자 하는 값

        Set<Integer> set = new HashSet<>();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            set.add(i);
            array[i] = i;
        }

        // Set에서 원소 탐색 시간 측정
        long start = System.nanoTime();
        boolean existsInSet = set.contains(target);
        long end = System.nanoTime();
        System.out.println("Set contains Time: " + (end - start) + " nanoseconds"); // 20718 nano

        // 배열에서 원소 탐색 시간 측정
        start = System.nanoTime();
        boolean existsInArray = contains(array, target);
        end = System.nanoTime();
        System.out.println("Array contains Time: " + (end - start) + " nanoseconds"); // 2697442 nano
    }

    public static boolean contains(int[] array, int target) {
        for (int value : array) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }
}
