public class StringExample {
    public static void main(String[] args) {
        // 1. String 개념 설명
        // String은 문자의 시퀀스를 나타내는 불변(immutable) 자료 구조입니다.
        // String 객체의 내용은 변경될 수 없기 때문에, 문자열 연산을 수행하면 항상 새로운 String 객체가 생성됩니다.

        // "HELLO"
        //  ^   ^
        //  |   |
        // 0   4 (인덱스)

        // 2. 자주 사용되는 메서드 사용법 및 예시 (시간복잡도 포함)
        String str = "HELLO";

        // length(): 문자열의 길이를 반환 (시간복잡도: O(1))
        int len = str.length(); // 5

        // charAt(): 주어진 인덱스의 문자를 반환 (시간복잡도: O(1))
        char ch = str.charAt(1); // 'E'

        // substring(): 시작 인덱스와 끝 인덱스 사이의 문자열을 반환 (시간복잡도: O(n))
        String sub = str.substring(1, 4); // "ELL"

        // contains(): 해당 문자열이 포함되어 있는지 확인 (시간복잡도: O(n))
        boolean contains = str.contains("EL"); // true

        // + 연산: 문자열을 연결 (시간복잡도: O(n + m), n과 m은 각 문자열의 길이)
        String combined = str + " WORLD"; // "HELLO WORLD"

        // join(): 주어진 문자열로 문자열들을 연결 (시간복잡도: O(n))
        String joined = String.join("-", "A", "B", "C"); // "A-B-C"

        // 3. 언제 사용하면 좋을지
        // 문자열 조작, 검색, 비교 등 문자 기반의 연산이 필요한 경우에 사용합니다.

        // 4. 도식화
        // 문자열: "HELLO"
        // 연결: "HELLO" + " WORLD" = "HELLO WORLD"
        // 조인: ["A", "B", "C"] -> "A-B-C"
    }
}
