import java.util.*;

public class Solution01 {
    public int solution(int[][] sizes) {
        // sizes
//        System.out.println("Arrays.toString(sizes) = " + Arrays.toString(sizes));
        System.out.println("Arrays.deepToString(sizes) = " + Arrays.deepToString(sizes));
        int maxW = 0; // size w,h 중에 큰 쪽 중 가장 큰 것
        int maxH = 0; // (...) 중에 작은 쪽 중 가장 큰 것
        for (int[] size : sizes) {
            int w = size[0];
            int h = size[1];
            System.out.println("w = " + w + ", h = " + h);
            // 회전하고
            int max = Math.max(w, h); // 2개 값 중 최대 값
            int min = Math.min(w, h); // (...) 최소 값
            // 반영하고
            maxW = Math.max(max, maxW);
            maxH = Math.max(min, maxH);
            System.out.println("maxW = " + maxW + ", maxH = " + maxH);
        }

        // 가로 길이, 세로 길이 -> 회전이 가능 -> 가로/세로 중에 긴 쪽을 한쪽으로 몰면 된다
        // 지갑의 크기를 return.
//        int answer = 0;
        int answer = maxW * maxH;
        return answer;
    }

    public static void main(String[] args) {
        Solution01 sol = new Solution01();
        int result1 = sol.solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}});
        System.out.println(result1 + " / " + 4000);
        int result2 = sol.solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}});
        System.out.println(result2 + " / " + 120);
        int result3 = sol.solution(new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}});
        System.out.println(result3 + " / " + 133);
    }
}