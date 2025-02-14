package org.example.Mocks;

import java.util.*;

public class MockInterview {

    public void reverseString(){
        String s = "1504200";

        StringBuilder r = new StringBuilder(s.length());
        boolean flag = true;
        for(int i = s.length()-1; i>=0; i--){
            if(s.charAt(i)!='0') {
                flag = false;
            }
            if(!flag)
                r.append(s.charAt(i));
        }
        System.out.println(r);
    }


    public void sumOfArrayWithoutLoop(){
        int[] arr = {1,2,3,4,5,6};

        int sum = sumRecursion(arr,arr.length-1);
        System.out.println(sum);
    }

    private int sumRecursion(int[] arr, int i) {
        if(i<0)
            return 0;
        return arr[i] + sumRecursion(arr,i-1);
    }

    public void determineHighestPeekForEach(){
        int[] arr = {73,74,75,71,69,72,76,73};
        Stack<Integer> stack = new Stack<>();

        int[] res = new int[arr.length];
        Arrays.fill(res,0);
        int n = arr.length;
        for(int i = n-1; i>=0;i--)
        {
            while (!stack.empty() && arr[stack.peek()]<=arr[i]){
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res[i] = stack.peek()-i;
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(res));
    }

    public void rottingOranges() {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};

        int minutes = dfsRottenOranges(grid);
        System.out.println(minutes);

    }

    private int dfsRottenOranges(int[][] grid) {
        boolean hasFresh = false;
        int time = 0;
        int m = grid.length;
        int n = grid[0].length;

        while(true) {
            boolean changed = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2)
                        changed = changed || rotAdjacent(grid, i, j);
                    if (grid[i][j] == 1)
                        hasFresh = true;
                }
            }
            if (!changed)
                break;

            time++;
            System.out.println(Arrays.deepToString(grid));
        }
        return hasFresh? -1: time;
    }

    private boolean rotAdjacent(int[][] grid, int i, int j) {
        boolean changed = false;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int[] d: dir){
            int ni = i+d[0];
            int nj = j+d[1];

            if(ni>=0 && ni<grid.length && nj>=0 && nj<grid[0].length && grid[ni][nj]==1) {
                grid[ni][nj] = 2;
                changed = true;
            }
        }
    return changed;
    }
}
