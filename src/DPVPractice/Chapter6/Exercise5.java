package DPVPractice.Chapter6;

import util.ArrayHelper;

import java.util.Arrays;

/*
Pattern 0: XOOO
Pattern 1: OXOO
Pattern 2: OOXO
Pattern 3: OOOX
Pattern 4: XOXO
Pattern 5: XOOX
Pattern 6: OXOX
Pattern 7: OOOO
Compatability list:
0: 1, 2, 3, 6, 7
1: 0, 2, 3, 4, 5, 7
2: 0, 1 ,3, 5, 6, 7
3: 0, 1, 2, 4, 7
4: 1, 3, 6, 7
5: 1, 2, 7
6: 0, 2, 4, 7
7: 0, 1, 2, 3, 4, 5, 6, 7
 */
public class Exercise5 {
    public static int solution(int[][] board) {
        int n = board[0].length;
        int[][] dp = new int[n + 1][8];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < 8; j++) {
                int currCol = totalCol(board, i - 1, j);
                if (j == 0) {
                    dp[i][j] = currCol + arrayMax(new int[]{dp[i - 1][1], dp[i - 1][2], dp[i - 1][3], dp[i - 1][6], dp[i - 1][7]});
                } else if (j == 1) {
                    dp[i][j] = currCol + arrayMax(new int[]{dp[i - 1][0], dp[i - 1][2], dp[i - 1][3], dp[i - 1][4], dp[i - 1][5], dp[i - 1][7]});
                } else if (j == 2) {
                    dp[i][j] = currCol + arrayMax(new int[]{dp[i - 1][0], dp[i - 1][1], dp[i - 1][3], dp[i - 1][5], dp[i - 1][6], dp[i - 1][7]});
                } else if (j == 3) {
                    dp[i][j] = currCol + arrayMax(new int[]{dp[i - 1][0], dp[i - 1][1], dp[i - 1][2], dp[i - 1][4], dp[i - 1][7]});
                } else if (j == 4) {
                    dp[i][j] = currCol + arrayMax(new int[]{dp[i - 1][1], dp[i - 1][3], dp[i - 1][6], dp[i - 1][7]});
                } else if (j == 5) {
                    dp[i][j] = currCol + arrayMax(new int[]{dp[i - 1][1], dp[i - 1][2], dp[i - 1][7]});
                } else if (j == 6) {
                    dp[i][j] = currCol + arrayMax(new int[]{dp[i - 1][0], dp[i - 1][2], dp[i - 1][4], dp[i - 1][7]});
                } else {
                    dp[i][j] = arrayMax(new int[]{dp[i - 1][0], dp[i - 1][1], dp[i - 1][2], dp[i - 1][3], dp[i - 1][4], dp[i - 1][5], dp[i - 1][6], dp[i - 1][7]});
                }
            }
        }
        System.out.println(ArrayHelper.print(dp));
        return Arrays.stream(dp[n]).max().getAsInt();
    }

    private static int totalCol(int[][] board, int col, int pattern) {
        int ans = 0;
        switch (pattern) {
            case 0:
                ans = board[0][col];
                break;
            case 1:
                ans = board[1][col];
                break;
            case 2:
                ans = board[2][col];
                break;
            case 3:
                ans = board[3][col];
                break;
            case 4:
                ans = board[0][col] + board[2][col];
                break;
            case 5:
                ans = board[0][col] + board[3][col];
                break;
            case 6:
                ans = board[1][col] + board[3][col];
                break;
            case 7:
                ans = 0;
                break;
        }
        return ans;
    }

    private static int arrayMax(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }

    public static void main(String[] args) {
        int[][] board = ArrayHelper.random2D(4, 5, 11);
        String commonString = "Board is \n%s, \n The largest sum is %s.";
        System.out.println(String.format(commonString, ArrayHelper.print(board), solution(board)));
    }
}
