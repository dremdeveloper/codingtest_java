//############################################################
// | cafe       | http://cafe.naver.com/dremdelover          |
// | Q&A        | https://open.kakao.com/o/gX0WnTCf          |
// | business   | ultrasuperrok@gmail.com                    |
//############################################################
/*
    sieveOfEratosthenes 함수:
    - n까지의 모든 소수를 찾습니다.
    - prime[] 불린 배열은 인덱스가 소수인지 아닌지를 나타냅니다 (prime[i] == true => i는 소수).
    - 처음에 모든 숫자를 소수로 간주합니다 (prime[i] = true).
    - 2부터 시작하여, 현재 숫자의 모든 배수를 소수에서 제거합니다 (prime[i] = false).
    - 이 과정을 n의 제곱근까지 반복합니다.
    - 마지막으로, prime[] 배열에서 true인 인덱스를 출력합니다.

    시간 복잡도:
    - 에라토스테네스의 체의 시간 복잡도는 O(n log(log n))입니다.
    - 각 숫자의 배수를 찾는 것이 주요 연산이며, n/2 + n/3 + n/5 + ... + n/p의 합만큼의 연산이 필요합니다.

    사용 경우:
    - n까지의 모든 소수를 빠르게 찾고 싶을 때 사용합니다.
    - 이 알고리즘이 유용한 경우는 소수 판별을 여러 번 해야 하는 상황이나, 
        특정 범위 내의 모든 소수를 한 번에 찾아야 하는 문제를 해결할 때입니다.

    상세 동작 과정:
    1. boolean 배열을 만들고 모든 값을 true로 초기화합니다.
    2. 첫 소수 2부터 시작하여 n의 제곱근까지 반복문을 돌며 다음을 수행합니다:
        a. 만약 현재 수 p가 소수라면 (prime[p] == true)
        b. p의 제곱부터 시작하여 p의 모든 배수를 소수에서 제외합니다. 
            (즉, prime[p*p], prime[p*p + p], ..., prime[n]을 false로 설정합니다.)
    3. 마지막으로, 2부터 n까지 모든 소수를 출력합니다.
*/

public class SieveOfEratosthenes {

    // 주어진 n 값 이하의 모든 소수를 출력하는 함수
    static void sieveOfEratosthenes(int n) {
        // prime 배열은 각 인덱스의 숫자가 소수인지 여부를 저장합니다.
        boolean prime[] = new boolean[n + 1];
        // 처음에는 모든 숫자를 소수로 가정하고, 배열의 모든 값을 true로 초기화합니다.
        for (int i = 0; i <= n; i++)
            prime[i] = true;

        // 2부터 n의 제곱근까지 반복하면서 소수가 아닌 수를 걸러냅니다.
        for (int p = 2; p * p <= n; p++) {
            // 만약 p가 여전히 소수라면, 그 배수를 모두 소수가 아니라고 표시합니다.
            if (prime[p]) {
                // p의 제곱부터 시작하여 p만큼 증가하는 수를 모두 소수에서 제거합니다.
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }

        // 2부터 n까지 모든 수에 대하여 소수인 것을 출력합니다.
        for (int i = 2; i <= n; i++) {
            if (prime[i])
                System.out.print(i + " ");
        }
    }

    public static void main(String args[]) {
        // 소수를 찾을 최대 값인 n을 지정합니다.
        int n = 30;
        System.out.print("Prime numbers less than or equal to " + n + ": ");
        // n이하의 모든 소수를 출력하는 함수를 호출합니다.
        sieveOfEratosthenes(n);
    }

}
