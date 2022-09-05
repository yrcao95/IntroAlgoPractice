package DPVPractice.Chapter6;

public class Exercise8 {
    public static int solution(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = s1.charAt(i) == s2.charAt(0) ? 1 : 0;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = s1.charAt(0) == s2.charAt(j) ? 1: 0;
        }
        int ans = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "OldSite:GeeksforGeeks.org";
        String s2 = "NewSite:GeeksQuiz.com";
        System.out.println(solution(s1, s2));
    }
}
