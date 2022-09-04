package DPVPractice.Chapter6;

public class Exercise2 {
    public static int solution(int[] arr) {
        assert arr.length >= 1 : "Incorrect arr length!";
        assert arr[0] == 0 : "arr must begin with 0!";
        int[] dp = new int[arr.length];
        dp[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            int ans = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                ans = Math.min(ans, penalty(arr[i], arr[j]) + dp[j]);
            }
            dp[i] = ans;
        }
        return dp[arr.length - 1];
    }

    private static int penalty(int x1, int x2) {
        int diff = Math.abs(x1 - x2);
        return (200 - diff) * (200 - diff);
    }

    public static void main(String[] args) {
        int[] hotels = new int[]{0, 20};
        System.out.println(solution(hotels));
    }
}
