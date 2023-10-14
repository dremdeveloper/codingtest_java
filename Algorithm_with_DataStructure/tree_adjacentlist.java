  // 루트 노드를 가지는 트리 클래스입니다.
/*
트리의 특성과 인접 리스트를 사용한 트리의 표현:
- 트리는 계층적인 구조를 갖고 있으며, 루트 노드에서 시작합니다.
- 트리의 각 노드는 자식 노드를 가질 수 있습니다.
- 인접 리스트로 표현된 트리에서 각 노드는 자식 노드들의 리스트를 갖고 있습니다.
- 사용 시점: 노드의 계층적인 관계를 명확히 표현하고 싶을 때, 노드에 동적으로 자식을 추가하고 싶을 때 사용합니다.

도식화 예:
    0
   /|\
  1 2 3
     |
     4

위 그래프의 표현:
Node 0 -> [Node 1, Node 2, Node 3]
Node 3 -> [Node 4]
*/


import java.util.*;

public class Tree {
    // 각 노드를 표현하는 클래스입니다.
    static class Node {
        int id;
        List<Node> children;
        Node(int id) {
            this.id = id;
            this.children = new ArrayList<>();
        }
    }

  
    Node root;
    
    public Tree(int rootId) {
        this.root = new Node(rootId);
    }
    
    // 주어진 부모 노드에 새로운 자식 노드를 추가합니다.
    public void addChild(Node parent, int childId) {
        Node child = new Node(childId);
        parent.children.add(child);
    }
    
    // 주어진 노드와 그 자식 노드들을 출력합니다.
    public void printChildren(Node node) {
        System.out.print("Node " + node.id + " -> ");
        for(Node child : node.children) {
            System.out.print(child.id + " ");
        }
        System.out.println();
    }

    // 예제 코드를 위한 메인 함수입니다.
    public static void main(String[] args) {
        Tree tree = new Tree(0);  // 루트 노드는 0입니다.
        
        tree.addChild(tree.root, 1);  // 루트 노드에 자식 노드 1을 추가합니다.
        tree.addChild(tree.root, 2);  // 루트 노드에 자식 노드 2을 추가합니다.
        tree.addChild(tree.root, 3);  // 루트 노드에 자식 노드 3을 추가합니다.

        Node node3 = tree.root.children.get(2);  // 루트 노드의 세 번째 자식 노드(노드 3)를 가져옵니다.
        tree.addChild(node3, 4);  // 노드 3에 자식 노드 4를 추가합니다.

        // 각 노드와 그 자식들을 출력합니다.
        tree.printChildren(tree.root);
        tree.printChildren(node3);
    }
}
