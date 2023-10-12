//############################################################
// | cafe       | http://cafe.naver.com/dremdelover          |
// | Q&A        | https://open.kakao.com/o/gX0WnTCf          |
// | business   | ultrasuperrok@gmail.com                    |
//############################################################
public class Main {

    /*
    본 코드는 배열에서 선형 검색과 이진 검색의 성능을 비교하기 위한 것입니다.
    
    주요 내용:
    1. 선형 검색(linearSearch): 배열의 각 요소를 처음부터 순서대로 확인하여 원하는 값을 찾습니다. 
       최악의 경우 전체 배열을 검색해야 하므로 시간 복잡도는 O(n)입니다.
    2. 이진 검색(binarySearch): 정렬된 배열에서 중간값을 기준으로 원하는 값이 중간값의 왼쪽에 있는지 오른쪽에 있는지를 판단하여 검색 범위를 절반으로 줄여 나갑니다.
       따라서 시간 복잡도는 O(log n)입니다.
    */

    public static void main(String[] args) {
        int size = 1000000;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }

        int target = size - 1; // 찾고자 하는 값

        // 선형 검색 시간 측정
        long start = System.nanoTime();
        linearSearch(arr, target);
        long end = System.nanoTime();
        System.out.println("Linear Search Time: " + (end - start) + " nanoseconds"); // 6439357 nano

        // 이진 검색 시간 측정
        start = System.nanoTime();
        binarySearch(arr, target);
        end = System.nanoTime();
        System.out.println("Binary Search Time: " + (end - start) + " nanoseconds"); // 16729 nano
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // 값이 배열에 없는 경우
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // 값이 배열에 없는 경우
    }
}
