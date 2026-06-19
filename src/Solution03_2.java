public class Solution03_2 {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 1; // 숙련도 1가 최소
        int left = 1;
        int right = 100_000;
        while (left <= right) { // left > right
            int mid = (left + right) / 2; // 중점을 구함
//        for (int i = 1; i <= 100_000; i++) { // 0번째는 생략
//            if (check(diffs, times, limit, i)) {
//            System.out.println("left = " + left);
//            System.out.println("right = " + right);
//            System.out.println("mid = " + mid);
            if (check(diffs, times, limit, mid)) {
                answer = mid; // 임시로 mid를 답을 잡음
                right = mid - 1;
            } else  {
                left = mid + 1;
            }
//            System.out.println("left = " + left);
//            System.out.println("right = " + right);

        }

        return answer;
    }

    private boolean check(int[] diffs, int[] times, long limit, int i) {
        long totalTime = times[0];
        for (int j = 1; j < diffs.length; j++) {
            long curTime = times[j]; // 0번째는 이미 넣어줌
            if (diffs[j] <= i) {
                totalTime += curTime;
            } else {
                long count = diffs[j] - i; // 반복횟수
                long prevTime = times[j - 1];
                totalTime += count * (prevTime + curTime) + curTime;
            }
            if (totalTime > limit) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution03_2 sol = new Solution03_2();

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