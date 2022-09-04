package util;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class TwoDimensionArrayHelper {
    public static <T> String print(T[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (T[] t : arr) {
            sb.append(Arrays.toString(t));
            sb.append(",\n");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static String print(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int[] t : arr) {
            sb.append(Arrays.toString(t));
            sb.append(",\n");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void initialize(Integer[][] arr) {
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = 0; j <= arr[0].length - 1; j++) {
                arr[i][j] = 0;
            }
        }
    }

    public static void initialize(Long[][] arr) {
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = 0; j <= arr[0].length - 1; j++) {
                arr[i][j] = 0L;
            }
        }
    }

    public static int[][] random2D(int m, int n, int k) {
        Random rd = new Random();
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = rd.nextInt(k);
            }
        }
        return ans;
    }
}
