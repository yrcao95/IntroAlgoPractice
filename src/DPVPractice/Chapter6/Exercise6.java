package DPVPractice.Chapter6;

public class Exercise6 {
    public static boolean solution(String s) {
        int n = s.length();
        boolean[][][] dp = new boolean[n][n][3];
        for (int i = 0; i < n - 1; i++) {
            char multiplicationResult = multiple(s.charAt(i), s.charAt(i + 1));
            dp[i][i + 1][0] = multiplicationResult == 'a';
            dp[i][i + 1][1] = multiplicationResult == 'b';
            dp[i][i + 1][2] = multiplicationResult == 'c';
        }
        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    boolean trimLeft = false;
                    boolean trimRight = false;
                    if (k == 0) {
                        if (s.charAt(i) == 'a') {
                            trimLeft = dp[i + 1][j][2];
                        } else if (s.charAt(i) == 'b') {
                            trimLeft = dp[i + 1][j][2];
                        } else if (s.charAt(i) == 'c') {
                            trimLeft = dp[i + 1][j][0];
                        }
                        if (s.charAt(j) == 'a') {
                            trimRight = dp[i][j - 1][2];
                        } else if (s.charAt(j) == 'b') {
                            trimRight = false;
                        } else if (s.charAt(j) == 'c') {
                            trimRight = dp[i][j - 1][0] || dp[i][j - 1][1];
                        }
                    } else if (k == 1) {
                        if (s.charAt(i) == 'a') {
                            trimLeft = dp[i + 1][j][0] || dp[i + 1][j][1];
                        } else if (s.charAt(i) == 'b') {
                            trimLeft = dp[i + 1][j][1];
                        } else if (s.charAt(i) == 'c') {
                            trimLeft = false;
                        }
                        if (s.charAt(j) == 'a') {
                            trimRight = dp[i][j - 1][0];
                        } else if (s.charAt(j) == 'b') {
                            trimRight = dp[i][j - 1][0] || dp[i][j - 1][1];
                        } else if (s.charAt(j) == 'c') {
                            trimRight = false;
                        }
                    } else {
                        if (s.charAt(i) == 'a') {
                            trimLeft = false;
                        } else if (s.charAt(i) == 'b') {
                            trimLeft = dp[i + 1][j][0];
                        } else if (s.charAt(i) == 'c') {
                            trimLeft = dp[i + 1][j][1] || dp[i + 1][j][2];
                        }
                        if (s.charAt(j) == 'a') {
                            trimRight = dp[i][j - 1][1];
                        } else if (s.charAt(j) == 'b') {
                            trimRight = dp[i][j - 1][2];
                        } else if (s.charAt(j) == 'c') {
                            trimRight = dp[i][j - 1][2];
                        }
                    }
                    dp[i][j][k] = trimLeft || trimRight;
                }
            }
        }
        return dp[0][n - 1][0];
    }


    private static char multiple(char x, char y) {
        char[][] table = new char[][]{{'b', 'b', 'a'}, {'c', 'b', 'a'}, {'a', 'c', 'c'}};
        return table[x - 'a'][y - 'a'];
    }

    public static void main(String[] args) {
        String s = "bbbbac";
        System.out.println(solution(s));
    }
}
