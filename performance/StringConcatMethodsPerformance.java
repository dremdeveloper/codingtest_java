//############################################################
// | cafe       | http://cafe.naver.com/dremdelover          |
// | Q&A        | https://open.kakao.com/o/gX0WnTCf          |
// | business   | ultrasuperrok@gmail.com                    |
//############################################################
public class Main {

    /*
    본 코드는 자바에서 문자열 추가를 위한 + 연산자와 String.join() 메서드의 성능을 비교하기 위한 것입니다.

    주요 내용:
    1. + 연산자: 두 문자열을 연결하기 위해 사용되는 연산자입니다. 
       하지만 여러 문자열을 연결할 때 매번 새로운 문자열 객체를 생성하기 때문에 성능상의 비효율이 발생할 수 있습니다.
       그 결과, n개의 문자열을 연결할 때 O(n^2)의 시간 복잡도를 가질 수 있습니다.
    2. String.join(): 여러 문자열을 구분자 없이 또는 구분자와 함께 연결할 때 사용되는 메서드입니다. 
       내부적으로 StringBuilder를 사용하여 문자열을 효율적으로 연결하므로 O(n)의 시간 복잡도를 가집니다.
    */

    public static void main(String[] args) {
        int count = 10000;
        String[] strings = new String[count];
        for (int i = 0; i < count; i++) {
            strings[i] = "test";
        }

        // + 연산자를 사용한 문자열 연결 시간 측정
        long start = System.nanoTime();
        String result = "";
        for (int i = 0; i < count; i++) {
            result += strings[i];
        }
        long end = System.nanoTime();
        System.out.println("+ Operator Time: " + (end - start) + " nanoseconds"); //  2155405110 nano

        // String.join()을 사용한 문자열 연결 시간 측정
        start = System.nanoTime();
        String joinedResult = String.join("", strings);
        end = System.nanoTime();
        System.out.println("String.join() Time: " + (end - start) + " nanoseconds"); //  2354403 nano
    }
}
