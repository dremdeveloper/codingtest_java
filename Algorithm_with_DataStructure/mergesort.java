    /*
    mergeSort 함수와 merge 함수에 대한 설명은 위 주석에 있습니다.

    상세한 병합 정렬 작동 과정:

    1. 주어진 배열을 반으로 나누어 각각을 정렬하고 병합하는 과정을 재귀적으로 수행합니다.
    예) arr = [12, 11, 13, 5, 6, 7]
    첫 번째 호출: left = 0, right = 5, mid = 2
    배열: [12, 11, 13], [5, 6, 7]

    2. [12, 11, 13] 배열은 다시 두 부분으로 나뉘어집니다: [12], [11, 13]
    이 배열들도 정렬과 병합을 수행합니다. 하지만 [12]는 하나의 요소만 있으므로 병합 정렬하지 않아도 됩니다.

    3. [11, 13]는 다시 [11], [13]으로 나뉘고, 각각 정렬 후 병합되어 [11, 13]이 됩니다.
    이제 [12]와 [11, 13]을 병합하여 [11, 12, 13]을 얻습니다.

    4. 이제 원래 배열의 오른쪽 부분 [5, 6, 7]에 대해서도 같은 과정을 반복합니다.
    [5, 6, 7] => [5], [6, 7] => [5], [6], [7] => [5, 6, 7]

    5. 마지막으로 [11, 12, 13]과 [5, 6, 7]을 병합하여 [5, 6, 7, 11, 12, 13]을 얻습니다.
   
    실제 호출과정은 아래와 같습니다.

    mergeSort(arr, 0, 5)
    mergeSort(arr, 0, 2)
        mergeSort(arr, 0, 1)
            mergeSort(arr, 0, 0)  --> 종료조건 (left == right)
            mergeSort(arr, 1, 1)  --> 종료조건 (left == right)
            merge(arr, 0, 0, 1)   --> [12, 11]을 병합
        mergeSort(arr, 2, 2)      --> 종료조건 (left == right)
        merge(arr, 0, 1, 2)       --> [11, 12, 13]을 병합
    mergeSort(arr, 3, 5)
        mergeSort(arr, 3, 4)
            mergeSort(arr, 3, 3)  --> 종료조건 (left == right)
            mergeSort(arr, 4, 4)  --> 종료조건 (left == right)
            merge(arr, 3, 3, 4)   --> [5, 6]을 병합
        mergeSort(arr, 5, 5)      --> 종료조건 (left == right)
        merge(arr, 3, 4, 5)       --> [5, 6, 7]을 병합
    merge(arr, 0, 2, 5)           --> [11, 12, 13, 5, 6, 7]을 병합, 결과: [5, 6, 7, 11, 12, 13]

    */

public class MergeSort {
    // 병합 정렬 메서드
    static void mergeSort(int[] arr, int left, int right) {
        // 왼쪽 인덱스가 오른쪽 인덱스보다 작은 경우에만 재귀 호출을 계속합니다.
        if (left < right) {
            // 중간 인덱스를 계산합니다.
            int mid = (left + right) / 2;
            
            // 배열의 왼쪽 부분을 정렬합니다.
            mergeSort(arr, left, mid);
            // 배열의 오른쪽 부분을 정렬합니다.
            mergeSort(arr, mid + 1, right);
            // 두 부분을 병합합니다.
            merge(arr, left, mid, right);
        }
    }

    // 병합 메서드
    static void merge(int[] arr, int left, int mid, int right) {
        // 두 서브배열의 크기를 계산합니다.
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        // 임시 배열을 생성하고 데이터를 복사합니다.
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        // i, j는 각각 왼쪽 및 오른쪽 서브배열의 인덱스를, k는 병합된 배열의 인덱스를 나타냅니다.
        int i = 0, j = 0;
        int k = left;

        // 두 서브배열을 비교하여 병합합니다.
        while (i < n1 && j < n2) {
            // 두 서브배열의 현재 원소를 비교하여, 더 작은 원소를 결과 배열에 복사합니다.
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        // 왼쪽 서브배열에 남아있는 원소가 있으면 결과 배열에 복사합니다.
        while (i < n1) {
            arr[k++] = L[i++];
        }
        // 오른쪽 서브배열에 남아있는 원소가 있으면 결과 배열에 복사합니다.
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    public static void main(String[] args) {
        // 정렬할 배열을 초기화합니다.
        int[] arr = {12, 11, 13, 5, 6, 7};
        // 병합 정렬 메서드를 호출합니다. 시작 인덱스는 0, 끝 인덱스는 배열의 길이 - 1입니다.
        mergeSort(arr, 0, arr.length - 1);

        // 정렬된 배열을 출력합니다.
        System.out.print("Sorted array: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}
