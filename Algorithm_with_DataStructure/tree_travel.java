// 정의: Node 구조체. 트리의 각 노드를 나타냅니다.
// 트리 순회의 개념: 트리의 모든 노드를 체계적으로 방문하는 것입니다.
// 사용되는 경우: 트리 구조의 모든 원소를 접근해야 할 때 사용됩니다. 예를 들어, 모든 원소를 출력하거나 합계를 구할 때 등입니다.
// 시간 복잡도: O(n). 모든 노드를 정확히 한 번씩 방문합니다.

/*
        도식화된 트리:
             1
           /   \
          2     3
         / \
        4   5
        
        전위 순회: 1 2 4 5 3
        중위 순회: 4 2 5 1 3
        후위 순회: 4 5 2 3 1
*/

/*
    printPreorder(tree.root); -> printPreorder(1)
        출력: 1
        printPreorder(1->left); -> printPreorder(2)
            출력: 2
            printPreorder(2->left); -> printPreorder(4)
                출력: 4
                printPreorder(4->left); -> printPreorder(nullptr)
                printPreorder(4->right); -> printPreorder(nullptr)
            printPreorder(2->right); -> printPreorder(5)
                출력: 5
                printPreorder(5->left); -> printPreorder(nullptr)
                printPreorder(5->right); -> printPreorder(nullptr)
        printPreorder(1->right); -> printPreorder(3)
            출력: 3
            printPreorder(3->left); -> printPreorder(nullptr)
            printPreorder(3->right); -> printPreorder(nullptr)
*/


//PostOrder 순회과정
/*
    printPostorder(tree.root); -> printPostorder(1)
        printPostorder(1->left); -> printPostorder(2)
            printPostorder(2->left); -> printPostorder(4)
                printPostorder(4->left); -> printPostorder(nullptr)
                printPostorder(4->right); -> printPostorder(nullptr)
                출력: 4
            printPostorder(2->right); -> printPostorder(5)
                printPostorder(5->left); -> printPostorder(nullptr)
                printPostorder(5->right); -> printPostorder(nullptr)
                출력: 5
            출력: 2
        printPostorder(1->right); -> printPostorder(3)
            printPostorder(3->left); -> printPostorder(nullptr)
            printPostorder(3->right); -> printPostorder(nullptr)
            출력: 3
        출력: 1
*/

//InOrder 순회과정
/*
    printInorder(tree.root); -> printInorder(1)
        printInorder(1->left); -> printInorder(2)
            printInorder(2->left); -> printInorder(4)
                printInorder(4->left); -> printInorder(nullptr)
                출력: 4
                printInorder(4->right); -> printInorder(nullptr)
            출력: 2
            printInorder(2->right); -> printInorder(5)
                printInorder(5->left); -> printInorder(nullptr)
                출력: 5
                printInorder(5->right); -> printInorder(nullptr)
        출력: 1
        printInorder(1->right); -> printInorder(3)
            printInorder(3->left); -> printInorder(nullptr)
            출력: 3
            printInorder(3->right); -> printInorder(nullptr)
*/



class Node {
    int data;
    Node left, right;
    Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    /* 
    전위 순회 (Preorder Traversal)
    - 노드를 방문하고, 재귀적으로 왼쪽 서브트리를 순회한 뒤, 오른쪽 서브트리를 순회합니다.
    - 순회 순서: 루트 -> 왼쪽 -> 오른쪽
    */
    void printPreorder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    /* 
    중위 순회 (Inorder Traversal)
    - 재귀적으로 왼쪽 서브트리를 순회하고, 노드를 방문한 뒤, 오른쪽 서브트리를 순회합니다.
    - 순회 순서: 왼쪽 -> 루트 -> 오른쪽
    */
    void printInorder(Node node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    /* 
    후위 순회 (Postorder Traversal)
    - 재귀적으로 왼쪽 서브트리를 순회하고, 오른쪽 서브트리를 순회한 뒤, 노드를 방문합니다.
    - 순회 순서: 왼쪽 -> 오른쪽 -> 루트
    */
    void printPostorder(Node node) {
        if (node == null) return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data + " ");
    }

    // 오버로딩을 사용하여 사용자가 root를 직접 지정하지 않아도 되게 합니다.
    void printPreorder()   {     printPreorder(root);   }
    void printInorder()     {     printInorder(root);   }
    void printPostorder()   {     printPostorder(root); }
}

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        
        System.out.println("Preorder traversal:");
        tree.printPreorder();

        System.out.println("\nInorder traversal:");
        tree.printInorder();

        System.out.println("\nPostorder traversal:");
        tree.printPostorder();
    }
}
