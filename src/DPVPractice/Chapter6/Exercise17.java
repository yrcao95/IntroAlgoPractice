package DPVPractice.Chapter6;

public class Exercise17 {
    public static boolean change(int[] coins, int value) {
        boolean[] dp = new boolean[value + 1];
        dp[0] = true;
        for (int i = 1; i <= value; i++) {
            boolean flag = false;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] > i) continue;
                flag = flag || dp[i - coins[j]];
            }
            dp[i] = flag;
        }
        return dp[value];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{5, 10};
        int value = 12;
        System.out.println(change(coins, value));
    }
}
