import java.util.*;

public class Solution03 {
    public int solution(int[] diffs, int[] times, long limit) {
        // n -> 제한 시간 내
        // 퍼즐 : 난이도 (diff), 현재 소요 시간 (time_cur)
        // 이전 time_prev, 숙련도 level
        // diff <= level - time_cur
        // diff > level - (diff - level) 번 틀리고
        // time_cur는 쓰이고, 이전 퍼즐 time_prev
        // limit 내 풀어야함.
        // 이 경우의 level 최소값을 구하시오. (다 양의 정수다)
//        System.out.println("Arrays.toString(diffs) = " + Arrays.toString(diffs));
//        System.out.println("Arrays.toString(times) = " + Arrays.toString(times));
//        System.out.println("limit = " + limit);

        int answer = 1; // 숙련도 1가 최소
        for (int i = 1; i <= 100_000; i++) { // 0번째는 생략
            long totalTime = times[0];
            // 이 반복 로직은 건들 수가 없음.
            // O(N)
            for (int j = 1; j < diffs.length; j++) {
                long curTime = times[j]; // 0번째는 이미 넣어줌
                if (diffs[j] <= i) {
                    totalTime += curTime;
                } else {
                    long count = diffs[j] - i; // 반복횟수
                    long prevTime = times[j - 1];
                    totalTime += count * (prevTime + curTime) + curTime;
                }
            }
            // 소요시간 <= 제한시간 -> 가장 최적화된 레벨.
            if (totalTime <= limit) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution03 sol = new Solution03();

        // ==========================================
        // 테스트 케이스 1
        // ==========================================
        int[] diffs1 = {1, 5, 3};
        int[] times1 = {2, 4, 7};
        long limit1 = 30L;

        int result1 = sol.solution(diffs1, times1, limit1);
        System.out.println(result1); // 정답 예시: 3


        // ==========================================
        // 테스트 케이스 2
        // ==========================================
        int[] diffs2 = {1, 4, 4, 2};
        int[] times2 = {6, 3, 8, 2};
        long limit2 = 59L;

        int result2 = sol.solution(diffs2, times2, limit2);
        System.out.println(result2); // 정답 예시: 2


        // ==========================================
        // 테스트 케이스 3
        // ==========================================
        int[] diffs3 = {1, 328, 467, 209, 54};
        int[] times3 = {2, 7, 1, 4, 3};
        long limit3 = 1723L;

        int result3 = sol.solution(diffs3, times3, limit3);
        System.out.println(result3); // 정답 예시: 294


        // ==========================================
        // 테스트 케이스 4
        // ==========================================
        int[] diffs4 = {1, 99999, 100000, 99995};
        int[] times4 = {9999, 9001, 9999, 9001};
        long limit4 = 3456789012L;

        int result4 = sol.solution(diffs4, times4, limit4);
        System.out.println(result4); // 정답 예시: 39354
    }
}