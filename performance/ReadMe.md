# 성능비교

동작은 비슷하지만 시간복잡도가 다른 연산들의 시간 비교 입니다.

| 파일 이름 | 설명 |
|-----------|------|
| [ArraySearchPerformance.java](https://github.com/dremdeveloper/codingtest_java/blob/main/performance/ArraySearchPerformance.java) | 배열에서 선형 검색과 이진 검색의 성능을 비교합니다. 선형 검색은 O(n), 이진 검색은 O(log n)의 시간 복잡도를 가집니다. |
| [ArrayVsListPerformance.java](https://github.com/dremdeveloper/codingtest_java/blob/main/performance/ArrayVsListPerformance.java) | 배열과 링크드 리스트에서의 추가와 삭제 연산의 성능을 비교합니다. 배열은 끝에서의 추가가 O(1), 삭제가 O(n), 링크드 리스트는 삽입과 삭제가 O(1)의 시간 복잡도를 가집니다. |
| [ElementSearchInSetVsArray.java](https://github.com/dremdeveloper/codingtest_java/blob/main/performance/ElementSearchInSetVsArray.java) | Set과 배열에서 원소를 탐색하는 성능을 비교합니다. Set은 O(1), 배열은 O(n)의 시간 복잡도를 가집니다. |
| [HashVsTreeCollectionPerformance.java](https://github.com/dremdeveloper/codingtest_java/blob/main/performance/HashVsTreeCollectionPerformance.java) | 해시 기반(HashSet, HashMap)과 트리 기반(TreeSet, TreeMap)의 셋 및 맵의 성능을 비교합니다. 해시 기반은 일반적으로 O(1), 트리 기반은 O(log n)의 시간 복잡도를 가집니다. |
| [StringConcatMethodsPerformance.java](https://github.com/dremdeveloper/codingtest_java/blob/main/performance/StringConcatMethodsPerformance.java) | 문자열 추가를 위한 `+` 연산자와 `String.join()` 메서드의 성능을 비교합니다. `+` 연산자는 O(n^2), `String.join()`은 O(n)의 시간 복잡도를 가집니다. |
