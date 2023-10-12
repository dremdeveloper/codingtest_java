import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        // 1. Stack 개념 설명
        // Stack은 LIFO(Last-In-First-Out) 원칙에 따라 동작하는 자료 구조입니다.
        // 즉, 가장 마지막에 들어온 요소가 가장 먼저 나가게 됩니다.
        // Stack은 연산 수행의 히스토리 저장, 알고리즘 연산 (ex. 괄호 검사), 함수 호출 및 반환 등 다양한 상황에서 활용됩니다.

        // ┌───┐ <- Top
        // │ C │
        // ├───┤
        // │ B │
        // ├───┤
        // │ A │
        // └───┘ <- Bottom

        // 2. 자주 사용되는 메서드 사용법 및 예시 (시간복잡도 포함)
        Stack<String> stack = new Stack<>();

        // push(): 스택의 맨 위에 요소 추가 (시간복잡도: O(1))
        stack.push("A");
        stack.push("B");
        stack.push("C");

        // peek(): 스택의 맨 위 요소를 조회하지만 제거하지는 않음 (시간복잡도: O(1))
        String topElement = stack.peek(); // "C"

        // pop(): 스택의 맨 위 요소를 조회하고 제거 (시간복잡도: O(1))
        String removedElement = stack.pop(); // "C"

        // size(): 스택의 크기를 반환 (시간복잡도: O(1))
        int size = stack.size(); // 2

        // empty(): 스택이 비어 있는지 확인 (시간복잡도: O(1))
        boolean isEmpty = stack.empty(); // false

        // 3. 언제 사용하면 좋을지
        // 스택은 가장 마지막에 수행된 연산을 먼저 되돌려야 하는 상황, 괄호 검사, 후위 표기법 계산 등에서 유용합니다.

        // 4. 비효율적인 연산
        // - 스택의 중간 요소에 접근하려면 전체를 순회해야 하므로 O(n)의 시간복잡도를 가집니다. 중간 요소 접근이 필요한 경우에는 리스트나 다른 자료 구조를 고려해야 합니다.

        // 5. 도식화
        // 초기: A -> B -> C (Top)
        // C 제거 후: A -> B (Top)
    }
}
