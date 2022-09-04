package HW1;

import util.Grid;

public class HW1P1 {
    public static long solution(int n) {
        Grid grid = new Grid(n + 2);
        grid.put(2, 2, 1);
        for (int i = 2; i < n + 2; i++) {
            for (int j = 2; j < n + 2; j++) {
                if (i == 2 && j == 2) continue;
                grid.put(i, j, grid.get(i - 2, j - 1) + grid.get(i - 1, j - 2));
            }
        }
//        System.out.println(grid);
        return grid.get(n + 1, n + 1);
    }

    public static void main(String[] args) {
        for (int i = 21; i < 60; i++) {
            System.out.println("=============");
//            System.out.println(String.format("DP table when n is %s: ", i));
            System.out.println(String.format("Answer when n is %s: %s", i, solution(i)));
        }
    }
}
