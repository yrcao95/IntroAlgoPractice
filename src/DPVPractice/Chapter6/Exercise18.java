package DPVPractice.Chapter6;

public class Exercise18 {
    public static boolean changeII(int[] coins, int value) {
        int n = coins.length;
        boolean[][] dp = new boolean[n + 1][value + 1];
        for (int j = 1; j < value + 1; j++) {
            dp[0][j] = false;
        }
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= value; j++) {
                if (j >= coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j - coins[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][value];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 5,10,20};
        int value = 40;
        System.out.println(changeII(coins, value));
    }
}
