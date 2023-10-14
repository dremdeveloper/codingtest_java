/*
힙 정렬(Heap Sort) 알고리즘 설명:
- 힙 정렬은 비교 기반의 정렬 알고리즘 중 하나로, 이진 힙(binary heap) 자료구조를 사용합니다.
- 힙은 부모 노드의 키 값이 자식 노드의 키 값보다 항상 큰 (또는 항상 작은) 이진 트리를 말합니다.
- 힙 정렬의 기본 아이디어는, 주어진 배열을 최대 힙의 배열로 볼 것인가, 최소 힙의 배열로 볼 것인가를 결정하는 것입니다.
- 사용 시점: 데이터의 정렬이 필요하고, 데이터의 크기가 크지 않을 때, 혹은 메모리 사용이 제한적일 때 효율적입니다.
- 시간 복잡도: O(n log n)

도식화 및 동작 과정:
예) [12, 11, 13, 5, 6, 7]
1. 최대 힙 구축: [13, 11, 12, 5, 6, 7]
2. 루트 노드(최대값)와 마지막 노드 교환 및 힙 크기 감소: [7, 11, 12, 5, 6] + [13]
3. 힙 재구축: [12, 11, 7, 5, 6] + [13]
4. 루트 노드와 마지막 노드 교환 및 힙 크기 감소: [6, 11, 7, 5] + [12, 13]
5. 힙 재구축: [11, 6, 7, 5] + [12, 13]
6. 루트 노드와 마지막 노드 교환 및 힙 크기 감소: [5, 6, 7] + [11, 12, 13]
7. 힙 재구축: [7, 6, 5] + [11, 12, 13]
8. 루트 노드와 마지막 노드 교환 및 힙 크기 감소: [5, 6] + [7, 11, 12, 13]
9. 힙 재구축: [6, 5] + [7, 11, 12, 13]
10. 루트 노드와 마지막 노드 교환 및 힙 크기 감소: [5] + [6, 7, 11, 12, 13]
11. 힙 재구축: [5] + [6, 7, 11, 12, 13]
12. 최종 결과: [5, 6, 7, 11, 12, 13]
*/
public class Main {

    public static void heapSort(int arr[]) {
        int n = arr.length;

        // 배열 arr을 최대 힙으로 만듭니다.
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 하나씩 추출하면서 힙을 재정렬합니다.
        for (int i = n - 1; i >= 0; i--) {
            // 현재 루트와 말단 노드를 교환합니다.
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 힙 크기를 줄이고, 재정렬합니다.
            heapify(arr, i, 0);
        }
    }

    // 힙을 재정렬하는 함수
    static void heapify(int arr[], int n, int i) {
        int largest = i; // 루트
        int l = 2*i + 1; // 왼쪽 자식
        int r = 2*i + 2; // 오른쪽 자식

        // 왼쪽 자식이 현재 노드보다 큰지 확인
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // 오른쪽 자식이 현재 노드보다 큰지 확인
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // largest가 현재 노드가 아니라면 교환
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // 재귀적으로 하위 트리에 대해 힙을 만듭니다.
            heapify(arr, n, largest);
        }
    }

    // 코드를 실행하기 위한 메인 함수
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};

        heapSort(arr);

        // 정렬된 배열을 출력합니다.
        System.out.print("Sorted array is: ");
        for (int el : arr) {
            System.out.print(el + " ");
        }
    }
}
