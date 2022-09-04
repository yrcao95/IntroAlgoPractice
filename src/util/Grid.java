package util;

import java.util.Arrays;
import java.util.stream.Stream;

public class Grid {
    private long[][] grid;

    private int m;
    private int n;

    public Grid(int m, int n) {
        this.m = m;
        this.n = n;
        this.grid = new long[m][n];
    }

    public Grid(int n) {
        this(n, n);
    }

    public void put(int m, int n, long val) {
        this.grid[m][n] = val;
    }

    public long get(int m, int n) {
        return this.grid[m][n];
    }

    public long[] getRow(int m) {
        return grid[m];
    }

    public long[] getCol(int n) {
        return Stream.of(grid).mapToLong(a -> a[n]).toArray();
    }

    public void setRow(int m, long[] row) {
        for (int i = 0; i < n; i++) {
            grid[m][i] = row[i];
        }
    }

    public void setCol(int n, long[] col) {
        for (int i = 0; i < m; i++) {
            grid[i][n] = col[i];
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Stream.of(grid).map(a -> Arrays.toString(a) + "\n").forEach(sb::append);
        return sb.toString();
    }

    public static void main(String[] args) {
        Grid grid = new Grid(3);
        grid.setRow(0, new long[]{1, 2, 2});
        System.out.println(grid);
    }
}
