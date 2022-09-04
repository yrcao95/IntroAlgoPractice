package DPVPractice.Chapter6;

import java.util.Arrays;

public class Exercise3 {

    public static int solution(int[] locations, int[] profits, int k) {
        int[] dp = new int[locations.length];
        int ans = 0;
        for (int i = 1; i < locations.length; i++) {
            int currMax = profits[i];
            for (int j = 1; j < i; j++) {
                if (locations[i] - locations[j] < k) continue;
                currMax = Math.max(currMax, dp[j] + profits[i]);
            }
            dp[i] = currMax;
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return ans;
    }

    public static void main(String[] args) {
        int[] locations = new int[]{0, 20, 40};
        int[] profits = new int[]{0, 500, 600};
        int k = 30;
        System.out.println(solution(locations, profits, k));
    }
}
