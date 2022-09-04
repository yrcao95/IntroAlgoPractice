package DPVPractice.Chapter6;
/*
A contiguous subsequence of a list S is a subsequence made up of consecutive
elements of S. For instance, if S is
5, 15,−30, 10,−5, 40, 10,
then 15,−30, 10 is a contiguous subsequence but 5, 15, 40 is not. Give a
linear-time algorithm for the following task:
Input: A list of numbers, a1, a2, . . . , an.
Output: The contiguous subsequence of maximum sum (a subsequence
of length zero has sum zero).
For the preceding example, the answer would be 10,−5, 40, 10, with a sum of 55.
(Hint: For each j ∈ {1, 2, . . . , n}, consider contiguous subsequences ending
exactly at position j .)
 */
public class Exercise1 {
    public static int solution(int[] arr) {
        int[] dp = new int[arr.length];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                dp[i] = arr[i];
            } else {
                if (dp[i - 1] >= 0) {
                    dp[i] = dp[i - 1] + arr[i];
                } else {
                    dp[i] = arr[i];
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution(arr));
    }
}
