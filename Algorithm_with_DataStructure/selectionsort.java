/*
선택 정렬(Selection Sort) 알고리즘:
- 선택 정렬은 가장 작은(또는 큰) 데이터를 선택해 맨 앞의 데이터와 바꾸고, 그 다음 작은 데이터를 선택해 그 다음 위치와 바꾸는 과정을 반복하는 정렬 알고리즘입니다.
- 사용 시점: 작은 양의 데이터에 대한 단순한 정렬이 필요할 때, 메모리가 제약적인 경우에 유용합니다.
- 시간 복잡도: O(n^2)

도식화 및 동작 과정:
예) [29, 10, 14, 37, 13]
1. 전체 데이터 중 가장 작은 데이터(10)를 맨 앞 데이터(29)와 교체: [10, 29, 14, 37, 13]
2. 두 번째 데이터부터 마지막 데이터 중 가장 작은 데이터(13)를 두 번째 데이터(29)와 교체: [10, 13, 14, 37, 29]
3. 세 번째 데이터부터 마지막 데이터 중 가장 작은 데이터(14)를 세 번째 데이터(14)와 교체: [10, 13, 14, 37, 29]
4. 네 번째 데이터부터 마지막 데이터 중 가장 작은 데이터(29)를 네 번째 데이터(37)와 교체: [10, 13, 14, 29, 37]
5. 다섯 번째 데이터(37)는 그대로 둡니다: [10, 13, 14, 29, 37]
*/
    
public class Main {

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n-1; i++) {
            // 가장 작은 원소의 인덱스를 찾습니다.
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // 가장 작은 원소와 i번째 원소를 교환합니다.
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    // 코드를 실행하기 위한 메인 함수
    public static void main(String args[]) {
        int arr[] = {29, 10, 14, 37, 13};

        selectionSort(arr);

        // 정렬된 배열을 출력합니다.
        System.out.print("Sorted array: ");
        for (int el : arr) {
            System.out.print(el + " ");
        }
    }
}
