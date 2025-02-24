package org.example.Mocks;

import java.util.*;
import java.util.stream.Collectors;

public class MockInterview {

    public void reverseString() {
        String s = "1504200";

        StringBuilder r = new StringBuilder(s.length());
        boolean flag = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                flag = false;
            }
            if (!flag)
                r.append(s.charAt(i));
        }
        System.out.println(r);
    }


    public void sumOfArrayWithoutLoop() {
        int[] arr = {1, 2, 3, 4, 5, 6};

        int sum = sumRecursion(arr, arr.length - 1);
        System.out.println(sum);
    }

    private int sumRecursion(int[] arr, int i) {
        if (i < 0)
            return 0;
        return arr[i] + sumRecursion(arr, i - 1);
    }

    public void determineHighestPeekForEach() {
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        Stack<Integer> stack = new Stack<>();

        int[] res = new int[arr.length];
        Arrays.fill(res, 0);
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.empty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res[i] = stack.peek() - i;
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

        while (true) {
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
        return hasFresh ? -1 : time;
    }

    private boolean rotAdjacent(int[][] grid, int i, int j) {
        boolean changed = false;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] d : dir) {
            int ni = i + d[0];
            int nj = j + d[1];

            if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && grid[ni][nj] == 1) {
                grid[ni][nj] = 2;
                changed = true;
            }
        }
        return changed;
    }

    public void processSentences() {

        List<String> sentences = Arrays.asList(
                "This is a sample sentence",
                "Another example with different words",
                "Sorting and grouping words is fun"
        );

        Map<Character, List<String>> result =
                sentences.stream()
                        .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                        .filter(word -> word.length() > 3)
                        .collect(Collectors.groupingBy(word -> Character.toLowerCase(word.charAt(0)), Collectors.toList()));
        System.out.println(result);

        System.out.println(new TreeMap<>(result));

    }

    public void findCommonCharactersBrute() {
        String[] words = {"cool", "lock", "loft"};
        HashSet<Character> hashSet = new HashSet<>();
        List<Character> chars = new ArrayList<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int minFreq = Integer.MAX_VALUE;

            for (String word : words) {
                int count = 0;
                for (char c : word.toCharArray()) {
                    if (c == ch)
                        count++;
                }
                minFreq = Math.min(count, minFreq);
            }
            for (int i = 0; i < minFreq; i++) {
                hashSet.add(ch);
                chars.add(ch);
            }
        }
        System.out.println(hashSet);
        System.out.println(chars);
    }

    public void findCommonCharacters() {
        String[] words = {"cool", "lock", "loft"};
        HashSet<Character> hashSet = new HashSet<>();

        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);

        for (String word : words) {
            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }
        }

        for (int i = 0; i < 26; i++) {
            if (minFreq[i] != 0)
                hashSet.add((char) (i + 'a'));
        }
        System.out.println(hashSet);
    }

    public void reverseAnInteger() {
        int a = 1233;
        long r = 0;

        while (a != 0) {
            int digit = a % 10;
            r = r * 10 + digit;
            a = a / 10;
        }
        if (r > Integer.MAX_VALUE)
            System.out.println(-1);
        System.out.println(r);
    }

    public void binaryPrefixDivisibleByK() {
        String s = "011";
        int k = 5;
        int num = 0;
        boolean[] ans = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            num = num * 2 + (ch - '0');
            if (num % k == 0)
                ans[i] = true;
            else ans[i] = false;
        }
        System.out.println(Arrays.toString(ans));
    }

    public void firstUniqueCharacterInAString() {
        String s = "loveleetcode";
        int index = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                index = i;
                break;
            }

        }
        System.out.println(index);
    }

    public void diamondMatrixBoundarySum() {
        int[][] mat = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        int n = mat.length;
        if (n == 1) {
            System.out.println(mat[0][0]);
        }
        int sum = 0;
        int mid = n / 2;
        for (int i = 0; i < n; i++) {
            int left = Math.abs(mid - i);
            int right = n - left - 1;

            if (left == right) {
                sum += mat[i][left];
            } else {
                sum += mat[i][right] + mat[i][left];

            }
        }
        System.out.println(sum);
    }

    public void diamondMatrixSum() {
        int[][] mat = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        int n = mat.length;
        if (n == 1) {
            System.out.println(mat[0][0]);
        }
        int sum = 0;
        int mid = n / 2;
        for (int i = 0; i < n; i++) {
            int left = Math.abs(mid - i);
            int right = n - left - 1;
            for (int j = left; j <= right; j++) {
                System.out.print(mat[i][j] + " ");
                sum += mat[i][j];
            }
        }
        System.out.println(sum);
    }

    public void rotateMatrixBy90() {
        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int m = mat.length;
        int n = mat[0].length;
        System.out.println("arrray given");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("after transposing");
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                if (i != j) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = temp;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();

        }

        System.out.println("after reversing");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][n - 1 - j];
                mat[i][n - 1 - j] = temp;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();

        }
    }


    public void rotateMatrixByAnyDegree() {

    }

    public void boundarySumOfMatrix() {

        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int n = mat.length;
        int m = mat[0].length;

        int sum = 0;
        if (n == 1) {
            sum = mat[0][0];
            System.out.println(sum);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1)
                    sum += mat[i][j];

            }
        }

        System.out.println(sum);
    }

    public void spiralBoundarySumOfMatrix() {

        int[][] mat = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        int n = mat.length;
        int m = mat[0].length;

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;

        int sum = 0;
        if (n == 1) {
            sum = mat[0][0];
            System.out.println(sum);
        }

        while (left <= right && top <= bottom) {
            for(int j = left; j <=right; j++) {
                sum += mat[top][j];
            }
            for(int i = top+1; i<=bottom; i++){
                sum+=mat[i][right];
            }
            if(top<bottom) {
                for (int j = right - 1; j >= left; j--) {
                    sum += mat[bottom][j];
                }
            }
            if(left<right)
                for(int i = bottom-1; i>top; i--){
                    sum+=mat[i][left];
                }
            top += 2;
            bottom -= 2;
            left += 2;
            right -= 2;
        }
        System.out.println(sum);
    }


}












