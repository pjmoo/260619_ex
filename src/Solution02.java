import java.util.*;

public class Solution02 {
    public int[] solution(int brown, int yellow) {
//        System.out.println("brown = " + brown);
//        System.out.println("yellow = " + yellow);

        // 가로 - 세로 <= 전체 넓이
        int total = brown + yellow;
        // total = w * h
        // brown = 2w + 2h - 4
        // yellow = total - brown = w * h - 2w - 2h + 4
        // = (w - 2) * (h - 2) = brown + yellow
        // 가로 길이는 세로 길이보다 크거나 같다
        int w = 0;
        int h = 0;
//        int[] answer = new int[2];
//        for (int i = 1; i <= total; i++) {
//        for (int i = total; i > 0; i--) {
        for (int i = total / 3; i > 0; i--) { // 높이 h가 정의상 최소 3이상 이기 때문에 (w도 3이상 -> 역방향으로 가니까 큰 의미 없음)
            w = i;
            if (total % w != 0) {
                continue;
            }
            h = total / i; // 정수

//            System.out.println("w = " + w);
//            System.out.println("h = " + h);
            boolean condition = brown == w * 2 + h * 2 - 4;
            if (condition) {
                break;
            }
        }

        int[] answer = {w, h};
        return answer;
    }

    public static void main(String[] args) {
        Solution02 sol = new Solution02();

        // 테스트 케이스 1
        int brown1 = 10;
        int yellow1 = 2;
        String answer1 = Arrays.toString(sol.solution(brown1, yellow1));
        System.out.println(answer1); // 정답 예시: [4, 3]

        // 테스트 케이스 2
        int brown2 = 8;
        int yellow2 = 1;
        String answer2 = Arrays.toString(sol.solution(brown2, yellow2));
        System.out.println(answer2); // 정답 예시: [3, 3]

        // 테스트 케이스 3
        int brown3 = 24;
        int yellow3 = 24;
        String answer3 = Arrays.toString(sol.solution(brown3, yellow3));
        System.out.println(answer3); // 정답 예시: [8, 6]
    }
}