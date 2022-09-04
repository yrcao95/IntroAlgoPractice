package HW1;

import util.TwoDimensionArrayHelper;

import java.util.Arrays;

public class HW1P2 {
    public static int solution1(int[] votes, int[] population, int target) {
        int totalVotes = Arrays.stream(votes).sum();
        int totalPopulation = Arrays.stream(population).sum();
        int limit = totalVotes - target;
        Integer[][] dp = new Integer[limit + 1][population.length + 1];
        TwoDimensionArrayHelper.initialize(dp);
        for (int j = 1; j <= votes.length; j++) {
            for (int i = 1; i <= limit; i++) {
                if (votes[j - 1] > i) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - votes[j - 1]][j - 1] + population[j - 1], dp[i][j - 1]);
                }
            }
        }
//        TwoDimensionArrayHelper.print(dp);
        int maxPopulation = dp[limit][population.length];
        return totalPopulation - maxPopulation;
    }

    public static long solution2(int[] votes, int[] population, int target) {
        Long[][] dp = new Long[target + 1][votes.length + 1];
        TwoDimensionArrayHelper.initialize(dp);
        int[] votesPreSum = preSum(votes);
        for (int i = 1; i <= target; i++) {
            dp[i][0] = Long.valueOf(Integer.MAX_VALUE);
        }
        for (int j = 1; j <= population.length; j++) {
            for (int i = 1; i <= target; i++) {
                if (votes[j - 1] >= i) {
                    dp[i][j] = Math.min(Long.valueOf(population[j - 1]), dp[i][j - 1]);
                } else if (votesPreSum[j - 1] < i) {
                    dp[i][j] = Long.valueOf(Integer.MAX_VALUE);
                } else {
                    dp[i][j] = Math.min(dp[i - votes[j - 1]][j - 1] + population[j - 1], dp[i][j - 1]);
                }
            }
        }
        return dp[target][population.length];
    }

    private static int[] preSum(int[] arr) {
        int sum = 0;
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            ans[i] = sum;
        }
        return ans;
    }

    public static void main(String[] args) {
        String commonString1 = "The answer from sol1 for votes %s, population %s, and at least %s votes is %s";
        String commonString2 = "The answer from sol2 for votes %s, population %s, and at least %s votes is %s";
        int[] votes1 = new int[]{5, 1, 2, 7, 6};
        int[] population1 = new int[]{200, 100, 30, 700, 250};
        int Z1 = 12;
//        groupCompare(commonString1, commonString2, votes1, population1, Z1);
        int[] votes2 = new int[]{10, 20, 30, 40, 50};
        int[] population2 = new int[]{200, 100, 30, 700, 250};
        int Z2 = 100;
//        groupCompare(commonString1, commonString2, votes2, population2, Z2);
        int[] votes3 = new int[]{5, 1, 2, 7};
        int[] population3 = new int[]{200, 100, 30, 700};
        int Z3 = 12;
//        groupCompare(commonString1, commonString2, votes3, population3, Z3);
        int[] votes4 = new int[]{5, 1, 2, 7, 6};
        int[] population4 = new int[]{200, 100, 30, 700, 250};
        int Z4 = 5;
//        groupCompare(commonString1, commonString2, votes4, population4, Z4);
        for (int i = 1; i<= 21; i++) {
            groupCompare(commonString1, commonString2, votes1, population1, i);
        }
    }

    private static void groupCompare(String commonString1, String commonString2, int[] votes, int[] population, int Z) {
        System.out.println(String.format(commonString1,
                Arrays.toString(votes),
                Arrays.toString(population),
                Z,
                solution1(votes, population, Z)));
        System.out.println(String.format(commonString2,
                Arrays.toString(votes),
                Arrays.toString(population),
                Z,
                solution2(votes, population, Z)));
    }
}
