import java.util.*;

public class Solution04 {
    public long solution(int n, int[] times) {
//        System.out.println("n = " + n);
//        System.out.println("Arrays.toString(times) = " + Arrays.toString(times));

        Arrays.sort(times); // Arrays.sort(배열) -> 오름차순
        // 순차적으로 처리하는게 있으므로...

        long left = 1;
//        long right = Long.MAX_VALUE;
        long right = (long) times[times.length - 1] * n;
        long answer = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2; // 가능성 있는 시간 중에서 새로운 시간을 검색
            long sum = 0; // mid 시간 동안 최대 몇 명을 처리 가능한가?
            // O(N)
            for (int time : times) { // 가장 속도가 빠른 사람에게 몰아줌
                sum += mid / time;
                if (sum >= n) {
                    break;
                }
            }

            if (sum >= n) { // 처리 가능한 사람 (sum) 이 처리 해야하는 사람 (n) 보다 크다
                answer = mid; // 임시 답
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution04 sol = new Solution04();

        // ==========================================
        // 테스트 케이스 1
        // ==========================================
        int n1 = 6;
        int[] times1 = {7, 10};

        long result1 = sol.solution(n1, times1);
        System.out.println(result1); // 정답 예시: 28

        // ==========================================
        // 테스트 케이스 2 (정렬되지 않은 케이스)
        // ==========================================
        int n2 = 6;
        int[] times2 = {10, 7};

        long result2 = sol.solution(n2, times2);
        System.out.println(result2); // 정답 예시: 28

        // ==========================================
        // 테스트 케이스 3 (대용량 및 오버플로우/시간 복잡도 검증 케이스)
        // ==========================================
        int n3 = 1000000000;
        int[] times3 = {1000000000, 999999999};

        long result3 = sol.solution(n3, times3);
        System.out.println(result3); // 정답 예시: 500000000000000000

        // ==========================================
        // 테스트 케이스 4 (대용량 n 및 대형 times 배열 검사 케이스)
        // ==========================================
        int n4 = 1000000000;
        int[] times4 = new int[100000];
        for (int i = 0; i < times4.length; i++) {
            times4[i] = 1000000 - i;
        }

        long result4 = sol.solution(n4, times4);
        System.out.println(result4); // 정답 예시: 9491701164
    }
}