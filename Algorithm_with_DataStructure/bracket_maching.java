//############################################################
// | cafe       | http://cafe.naver.com/dremdelover          |
// | Q&A        | https://open.kakao.com/o/gX0WnTCf          |
// | business   | ultrasuperrok@gmail.com                    |
//############################################################
/*
    areParenthesesBalanced 함수:
    - 문자열로 표현된 괄호의 짝이 맞는지 확인합니다.
    - 스택을 사용하여 열린 괄호를 추적하고, 닫힌 괄호를 만났을 때 스택의 top에 해당하는 열린 괄호와 짝이 맞는지 확인합니다.

    시간 복잡도:
    - O(n): n은 입력 문자열의 길이입니다. 
    - 각 문자를 한 번씩 확인하므로 선형 시간 복잡도를 가집니다.

    사용 경우:
    - 코드 편집기에서 괄호의 짝이 올바른지 확인할 때
    - 수식의 괄호가 올바르게 닫혀 있는지 확인할 때

    상세 동작 과정:
    1. 문자열을 처음부터 끝까지 순회하며 각 문자가 괄호인지 확인합니다.
    2. 열린 괄호('(', '{', '[')를 만나면 스택에 푸시합니다.
    3. 닫힌 괄호(')', '}', ']')를 만나면 스택에서 팝하여 짝이 맞는지 확인합니다.
    4. 문자열 순회가 끝난 후 스택이 비어있으면 괄호의 짝이 맞는 것으로, 스택이 비어있지 않다면 짝이 맞지 않는 것으로 판단합니다.

    예) expr = "({[()]})"
    - '(': 스택에 푸시
    - '{': 스택에 푸시
    - '[': 스택에 푸시
    - ']': 스택에서 팝 => '['
    - ')': 스택에서 팝 => '{'
    - '}': 스택에서 팝 => '('
    - 스택이 비어 있으므로 괄호의 짝이 맞습니다.
*/
   

import java.util.Stack;

public class ParenthesesChecker {
    
    // 괄호가 균형을 이루고 있는지 확인하는 함수
    static boolean areParenthesesBalanced(String expr) {
        // 스택을 선언하여 괄호들을 저장하고 추출할 것입니다.
        Stack<Character> stack = new Stack<>();
        
        // 주어진 문자열 expr에 대해 각 문자를 순회합니다.
        for (char ch : expr.toCharArray()) {
            // 여는 괄호일 경우 스택에 추가합니다.
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            // 닫는 괄호일 경우 스택에서 제거하거나 매칭 여부를 확인합니다.
            else if (ch == ')' || ch == '}' || ch == ']') {
                // 스택이 비어있다면 균형이 맞지 않습니다.
                if (stack.isEmpty()) return false;
                char match;
                
                // 현재 닫는 괄호와 매칭되는 여는 괄호를 찾습니다.
                switch (ch) {
                    case ')':
                        match = '(';
                        break;
                    case '}':
                        match = '{';
                        break;
                    case ']':
                        match = '[';
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid character: " + ch);
                }
                
                // 스택의 가장 위의 괄호와 현재 괄호가 매칭되지 않는다면 균형이 맞지 않습니다.
                if (stack.pop() != match) return false;
            }
        }
        
        // 스택이 완전히 비어있다면 괄호의 균형이 맞는 것입니다.
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // 검사할 괄호 문자열을 지정합니다.
        String expr = "({[()]})";
        
        // 괄호의 균형이 맞는지 검사하고, 그 결과를 출력합니다.
        if (areParenthesesBalanced(expr)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }
    }
}

