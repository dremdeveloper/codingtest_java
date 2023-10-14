public class BinaryTreeArray {
// 트리를 배열로 구현합니다.
// 배열의 인덱스가 노드의 번호가 되고, 각 요소는 노드의 값을 저장합니다.

/*
트리를 배열로 구현하는 방법:
- 배열의 각 인덱스를 노드로 간주하여, 특정 규칙에 따라 노드의 자식을 배열의 다른 인덱스에 배치합니다.
- 흔히, i 인덱스의 노드에 대해 왼쪽 자식은 2i, 오른쪽 자식은 2i + 1 인덱스에 위치시키는 규칙을 따릅니다.


도식화 예:
트리 (노드 번호와 값이 동일하다고 가정):
     1
   /   \
  2     3
 / \   / \
4   5 6   7

배열: [0, 1, 2, 3, 4, 5, 6, 7] (0번 인덱스는 사용하지 않습니다.)
*/

    int[] arr;
    int lastUsedIndex;
    
    // 생성자에서 트리의 크기(배열의 크기)를 지정합니다.
    public BinaryTreeArray(int size) {
        arr = new int[size + 1];
        lastUsedIndex = 0;
        System.out.println("Blank Tree of size " + size + " has been created !");
    }

    // 노드를 트리에 추가합니다.
    public void insert(int value) {
        if (lastUsedIndex == arr.length - 1) {
            System.out.println("The tree is full!");
            return;
        }
        arr[++lastUsedIndex] = value;
        System.out.println(value + " has been inserted");
    }
    
    // 특정 노드의 왼쪽 자식의 값을 반환합니다.
    public int getLeftChild(int index) {
        int leftChildIndex = 2 * index;
        if (leftChildIndex > lastUsedIndex || index <= 0) {
            System.out.println("No left child!");
            return -1;
        }
        return arr[leftChildIndex];
    }
    
    // 특정 노드의 오른쪽 자식의 값을 반환합니다.
    public int getRightChild(int index) {
        int rightChildIndex = 2 * index + 1;
        if (rightChildIndex > lastUsedIndex || index <= 0) {
            System.out.println("No right child!");
            return -1;
        }
        return arr[rightChildIndex];
    }

    // 트리의 모든 노드 값을 순서대로 출력합니다.
    public void display() {
        for (int i = 1; i <= lastUsedIndex; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        BinaryTreeArray tree = new BinaryTreeArray(7);
        
        for (int i = 1; i <= 7; i++) {
            tree.insert(i);
        }

        tree.display();
        System.out.println("Left child of node 3: " + tree.getLeftChild(3));
        System.out.println("Right child of node 3: " + tree.getRightChild(3));
    }
}
