//############################################################
// | cafe       | http://cafe.naver.com/dremdelover          |
// | Q&A        | https://open.kakao.com/o/gX0WnTCf          |
// | business   | ultrasuperrok@gmail.com                    |
//############################################################

/*
본 코드는 배열과 링크드 리스트의 기본적인 동작의 성능을 측정하기 위한 것입니다.
1. 배열에서의 추가와 삭제
2. 링크드 리스트에서의 추가와 삭제

주요 내용:
1. 배열의 끝에서의 추가는 O(1)의 시간 복잡도를 가집니다.
2. 배열에서의 삭제는 O(n)의 시간 복잡도를 가집니다.
3. 링크드 리스트에서, 이미 위치가 주어졌을 때의 삽입과 삭제는 O(1)의 시간 복잡도를 가집니다.
*/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        int size = 100000; // 측정할 크기

        // 배열 추가 시간 측정
        List<Integer> arrayList = new ArrayList<>();
        long start = System.nanoTime();
        arrayList.add(size); // O(1) - 배열의 끝에 추가
        long end = System.nanoTime();
        System.out.println("Array Addition Time: " + (end - start) + " nanoseconds"); // 27608 nano

        // 배열 삭제 시간 측정
        start = System.nanoTime();
        arrayList.remove(arrayList.size() - 1); // O(n) - 배열의 끝에서 삭제. 
        end = System.nanoTime();
        System.out.println("Array Deletion Time: " + (end - start) + " nanoseconds"); // 13238 nano

        // 링크드 리스트 삽입 시간 측정
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(size);
        ListIterator<Integer> itr = linkedList.listIterator();
        itr.next();
        start = System.nanoTime();
        itr.add(size + 1); // O(1) - 이미 위치가 주어졌을 때의 삽입
        end = System.nanoTime();
        System.out.println("Linked List Insertion Time: " + (end - start) + " nanoseconds"); // 3339 nano

        // 링크드 리스트 삭제 시간 측정
        itr = linkedList.listIterator();
        itr.next();
        start = System.nanoTime();
        itr.remove(); // O(1) - 이미 위치가 주어졌을 때의 삭제
        end = System.nanoTime();
        System.out.println("Linked List Deletion Time: " + (end - start) + " nanoseconds"); // 11050 nano
    }
}
