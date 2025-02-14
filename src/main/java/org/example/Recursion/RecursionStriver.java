package org.example.Recursion;

import java.util.*;
import java.util.jar.JarEntry;

public class RecursionStriver {

  int mod = (int) 1e9 + 7;

  public void stringToIntegerAtoi(String s) {
    int count = 0;
    int res = 0;
    while (count < s.length() && s.charAt(count) == ' ') {
      count++;
    }
    int sign = 1;
    if (s.charAt(count) == '-') {
      sign = -1;
      count++;
    } else if (s.charAt(count) == '+') {
      count++;
    }
    while (count < s.length()) {
      if (Character.isDigit(s.charAt(count))) {
        res = res * 10 + (s.charAt(count) - '0');
        if (res > Integer.MAX_VALUE && sign == -1)
          System.out.println(Integer.MIN_VALUE);
        else if (res > Integer.MAX_VALUE && sign == 1)
          System.out.println(Integer.MAX_VALUE);
        count++;
      } else {
        System.out.println(res * sign);
        return;
      }
    }
    res = res * sign;
    System.out.println(res);
  }

  public void generateAllBinaryStringsWithoutConsecutive1s(int k) {
    ArrayList<String> binaryStrings = generateStrings(k);
    for (String s : binaryStrings) {
      System.out.print(s + " ");
    }
  }

  private ArrayList<String> generateStrings(int k) {
    if (k == 0) {
      ArrayList<String> emptylist = new ArrayList<>();
      emptylist.add("");
      return emptylist;
    }
    if (k == 1) {
      ArrayList<String> list = new ArrayList<>();
      list.add("0");
      list.add("1");
      return list;
    }
    ArrayList<String> result = new ArrayList<>();
    ArrayList<String> prevList = generateStrings(k - 1);
    for (String s : prevList) {
      result.add(s + "0");
      if (s.charAt(s.length() - 1) != '1') {
        result.add(s + "1");
      }
    }
    return result;
  }

  public void powerOfANumber(double x, int n) {
    double res = 1.0;
    long nn = n;
    if (nn < 0)
      nn = -1 * nn;
    while (nn > 0) {
      if (nn % 2 == 1) {
        res = res * x;
        nn = nn - 1;
      } else {
        x = x * x;
        nn = nn / 2;
      }
    }
    if (n < 0) res = 1.0 / res;
    System.out.println(res);
//    if (n == 0) {
//      return 1;
//    }
//    // If the exponent is negative, invert the base and make the exponent positive
//    if (n < 0) {
//      return 1.0 / powerOfANumber(x, -n);
//    }
//    // Recursive case: multiply base by the result of base raised to the power of (exponent - 1)
//    return x * powerOfANumber(x, n - 1);
  }

  public void countGoodNumbers(long n) {
    long first = (n % 2 == 0 ? n / 2 : (n / 2) + 1);
    long second = n / 2;
    long mul1 = power(5, first) % mod;
    long mul2 = power(4, second) % mod;
    long ans = 1;
    ans = mul1 * ans;
    ans = (second != 0 ? (ans * mul2) % mod : ans);
    System.out.println((int) ans % mod);
  }

  private long power(long x, long i) {
    long temp;
    if (i == 0)
      return 1;
    temp = power(x, i / 2);
    if (i % 2 == 0) return (temp * temp) % mod;
    else return (x * temp * temp) % mod;
  }

  public void sortStackUsingRecursion() {
    Stack<Integer> stack = new Stack<>();
    stack.add(1);
    stack.add(2);
    stack.add(4);
    stack.add(7);
    stack.add(3);
    stack.add(6);
    System.out.println(stack);
    sortStack(stack);
    System.out.println(stack);
  }

  private void sortStack(Stack<Integer> stack) {
    if (!stack.isEmpty()) {
      int top = stack.pop();
      sortStack(stack);
      insertSorted(stack, top);
    }
  }

  private void insertSorted(Stack<Integer> stack, int top) {
    if (stack.isEmpty()) {
      stack.push(top);
    } else {
      int element = stack.pop();
      insertSorted(stack, top);
      stack.push(element);
    }
  }

  public void reverseStackUsingRecursion() {
    Stack<Integer> stack = new Stack<>();
    stack.add(1);
    stack.add(2);
    stack.add(3);
    stack.add(4);
    stack.add(5);
    stack.add(6);
    System.out.println(stack);
    reverseStack(stack);
    System.out.println(stack);
  }

  private void reverseStack(Stack<Integer> stack) {
    if (!stack.isEmpty()) {
      int top = stack.pop();
      reverseStack(stack);
      insertSorted(stack, top);
    }
  }

  public void binarySearchUsingRecursion(int[] arr, int key) {
    int low = 0;
    int high = arr.length - 1;
    boolean ans = binarySearch(arr, low, high, key);
    if (ans)
      System.out.println("found");
    else
      System.out.println("not found");
  }

  private boolean binarySearch(int[] arr, int low, int high, int key) {
    if (low > high)
      return false;
    int mid = (low + high) / 2;
    if (arr[mid] == key)
      return true;
    else if (arr[mid] < key)
      return binarySearch(arr, mid + 1, high, key);
    else
      return binarySearch(arr, low, mid - 1, key);
  }

  public void reverseStringUsingRecursion(String s) {
    StringBuilder newS = new StringBuilder();
    String res = reverseStringBrute(s, 0, newS);
    char[] newChar = s.toCharArray();
    reverseStringOptimal(newChar, 0, newChar.length - 1);
    System.out.println(res);
    String reverse = new String(newChar);
    System.out.println(reverse);
  }

  private void reverseStringOptimal(char[] arr, int i, int j) {
    if (i > j)
      return;
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
    reverseStringOptimal(arr, i + 1, j - 1);
  }

  private String reverseStringBrute(String s, int position, StringBuilder newString) {
    if (position == s.length())
      return "";
    reverseStringBrute(s, position + 1, newString);
    return newString.append(s.charAt(position)).toString();
  }

  public void checkIfStringIsAPalindrome(String s) {
    char[] newChar = s.toCharArray();
    reverseStringOptimal(newChar, 0, newChar.length - 1);
    String reverse = new String(newChar);
    if (reverse.equalsIgnoreCase(s))
      System.out.println("Its a palindrome");
    else System.out.println("Not a palindrome");
  }

  public void generateParentheses(int n) {
    List<String> res = new ArrayList<>();
    recurseParenthesis(res, 0, 0, "", n);
    System.out.println(res);
  }

  private void recurseParenthesis(List<String> res, int left, int right, String s, int n) {
    if (s.length() == n * 2) {
      res.add(s);
      return;
    }
    if (left < n) {
      recurseParenthesis(res, left + 1, right, s + "(", n);
    }
    if (right < left) {
      recurseParenthesis(res, left, right + 1, s + ")", n);
    }
  }

  public void printAllSubsequencesPowerSet(String s) {
    generateSubstrings("", 0, s.toCharArray());
    List<List<Integer>> result = new ArrayList<>();
    generateSubsetsUsingRecursion(new int[]{1, 2, 3}, 0, new ArrayList<>(), result);
    System.out.println(result);
  }

  private void generateSubsetsUsingRecursion(int[] nums, int start, List<Integer> currentSubset, List<List<Integer>> result) {
    if (start == nums.length) {
      result.add(new ArrayList<>(currentSubset));
      return;
    }
    currentSubset.add(nums[start]);
    generateSubsetsUsingRecursion(nums, start + 1, currentSubset, result);
    currentSubset.remove(currentSubset.size() - 1);
    generateSubsetsUsingRecursion(nums, start + 1, currentSubset, result);
  }

  private void generateSubstrings(String s, int count, char[] input) {
    if (count == input.length) {
      System.out.println(s);
      return;
    }
    if (count < input.length) {
      generateSubstrings(s + input[count], count + 1, input);
    }
    generateSubstrings(s, count + 1, input);
  }

  public void countAllSubsequencesWithSumK(int[] nums, int key) {
    int total = subsequencesWithSumK(nums, key, 0, 0);
    System.out.println(total);
  }

  private int subsequencesWithSumK(int[] nums, int key, int start, int sum) {
    if (start == nums.length)
      return (sum == key) ? 1 : 0;
    int include = subsequencesWithSumK(nums, key, start + 1, sum + nums[start]) % mod;
    int exclude = subsequencesWithSumK(nums, key, start + 1, sum) % mod;
    return (include + exclude) % mod;
  }

  public void combinationSum(int[] nums, int sum) {
    List<List<Integer>> ans = new ArrayList<>();
    allSumSubsequences(nums, sum, 0, ans, new ArrayList<>());
    System.out.println(ans);
  }

  private void allSumSubsequences(int[] nums, int sum, int index, List<List<Integer>> ans, ArrayList<Integer> current) {
    if (index == nums.length) {
      if (sum == 0)
        ans.add(new ArrayList<>(current));
      return;
    }
    if (nums[index] <= sum) {
      current.add(nums[index]);
      allSumSubsequences(nums, sum - nums[index], index, ans, current);
      current.remove(current.size() - 1);
    }
    allSumSubsequences(nums, sum, index + 1, ans, current);
  }

  public void combinationSumTwo(int[] nums, int sum) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    noduplicateSubsequences(nums, sum, 0, ans, new ArrayList<>());
    System.out.println(ans);
  }

  private void noduplicateSubsequences(int[] nums, int sum, int index, List<List<Integer>> ans, ArrayList<Integer> current) {
    if (sum == 0) {
      ans.add(new ArrayList<>(current));
      return;
    }
    for (int i = index; i < nums.length; i++) {
      if (i > index && nums[i] == nums[i - 1]) continue;
      if (nums[i] > sum)
        break;
      current.add(nums[i]);
      noduplicateSubsequences(nums, sum - nums[i], i + 1, ans, current);
      current.remove(current.size() - 1);
    }
  }

  public void subsetSum(int[] arr) {
    List<Integer> sumList = new ArrayList<>();
    generateSubsetSum(arr, sumList, 0, 0);
    Collections.sort(sumList);
    System.out.println(sumList);
  }

  private void generateSubsetSum(int[] arr, List<Integer> sumList, int index, int sum) {
    if (index == arr.length) {
      if (!sumList.contains(sum))
        sumList.add(sum);
      return;
    }
    if (index < arr.length)
      generateSubsetSum(arr, sumList, index + 1, sum + arr[index]);
    generateSubsetSum(arr, sumList, index + 1, sum);
  }

  public void subsetTwo(int[] arr) {
    HashSet<List<Integer>> ans = new HashSet<>();
    generateSubsetsUnique(arr, 0, ans, new ArrayList<>());
    System.out.println(ans);
  }

  private void generateSubsetsUnique(int[] arr, int index, HashSet<List<Integer>> ans, ArrayList<Integer> current) {
    if (index == arr.length) {
      Collections.sort(current);
      ans.add(new ArrayList<>(current));
      return;
    }
    current.add(arr[index]);
    generateSubsetsUnique(arr, index + 1, ans, current);
    current.remove(current.size() - 1);
    generateSubsetsUnique(arr, index + 1, ans, current);
  }

  public void combinationSumThree(int k, int target) {
    HashSet<List<Integer>> ans = new HashSet<>();
    generateSumForGivenTargetUsingKnumbers(1, k, target, ans, new ArrayList<>());
    System.out.println(ans);
  }

  private void generateSumForGivenTargetUsingKnumbers(int start, int k, int target, HashSet<List<Integer>> ans, ArrayList<Integer> current) {
    if (current.size() == k && target == 0) {
      Collections.sort(current);
      ans.add(new ArrayList<>(current));
      return;
    }
    for (int i = start; i <= 9; i++) {
      current.add(i);
      generateSumForGivenTargetUsingKnumbers(i + 1, k, target - i, ans, current);
      current.remove(current.size() - 1);
    }
  }

  public void phoneNumberCombinations(String digits) {
    HashMap<Integer, String> keyboard = new HashMap<>();
    keyboard.put(2, "abc");
    keyboard.put(3, "def");
    keyboard.put(4, "ghi");
    keyboard.put(5, "jkl");
    keyboard.put(6, "mno");
    keyboard.put(7, "pqrs");
    keyboard.put(8, "uvw");
    keyboard.put(9, "wxyz");

    HashSet<String> ans = new HashSet<>();

    if (digits.isEmpty())
      System.out.println(ans);
    generatePhoneNumberStrings(digits, keyboard, digits.length(), ans, new StringBuilder(), 0);
    System.out.println(ans);
  }

  private void generatePhoneNumberStrings(String digits, HashMap<Integer, String> keyboard, int length, HashSet<String> ans, StringBuilder s, int start) {
    if (start == length) {
      ans.add(s.toString());
      return;
    }

    int digit = Character.getNumericValue(digits.charAt(start));
    String letters = keyboard.get(digit);

    for (char c : letters.toCharArray()) {
      s.append(c);
      generatePhoneNumberStrings(digits, keyboard, length, ans, s, start + 1);
      s.deleteCharAt(s.length() - 1);
    }

  }

  public void generatePalindromePartitions(String s) {
    List<String> path = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();
    palidromePartitioning(s, path, res, 0);
    System.out.println(res);

  }

  private void palidromePartitioning(String s, List<String> path, List<List<String>> res, int index) {
    if (index == s.length()) {
      res.add(new ArrayList<>(path));
      return;
    }
    for (int i = index; i < s.length(); i++) {
      if (isPalindrome(s, index, i)) {
        path.add(s.substring(index, i + 1));
        palidromePartitioning(s, path, res, i + 1);
        path.remove(path.size() - 1);
      }
    }
  }

  private boolean isPalindrome(String s, int start, int end) {
    while (start <= end) {
      if (s.charAt(start++) != s.charAt(end--))
        return false;
    }
    return true;
  }

  public void wordSearchOnABoard(String word) {
    char[][] board = {{'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}};
    int m = board.length;
    int n = board[0].length;
    int index = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == word.charAt(index)) {
          if (searchNext(board, word, i, j, m, n, index)) {
            System.out.println(true);
            return;
          }
        }
      }
    }
    System.out.println(false);
  }

  private boolean searchNext(char[][] board, String word, int i, int j, int m, int n, int index) {
    if (index == word.length())
      return true;

    if (i < 0 || j < 0 || i == m || j == n || board[i][j] != word.charAt(index) || board[i][j] == '!')
      return false;

    boolean top = searchNext(board, word, i - 1, j, m, n, index + 1);
    boolean right = searchNext(board, word, i, j + 1, m, n, index + 1);
    boolean bottom = searchNext(board, word, i + 1, j, m, n, index + 1);
    boolean left = searchNext(board, word, i, j - 1, m, n, index + 1);

    return top || bottom || left || right;
  }

  public void solveNQueens(int n) {
    int[][] board = new int[n][n];
    List<List<String>> sol = new ArrayList<>();
    queenPositionsOnNBoard(n, board, 0,sol);
    System.out.println(sol);
  }

  private List<String> creationSolution(int[][] board, int n) {
    List<String> solution = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      StringBuilder s = new StringBuilder();
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 1)
          s.append('Q');
        else s.append('.');
      }
      solution.add(s.toString());
    }
    return solution;
  }

  private void queenPositionsOnNBoard(int n, int[][] board, int count,List<List<String>> solution) {
    if (count >= n) {
      solution.add(creationSolution(board,n));
      return;
    }

    for (int i = 0; i < n; i++) {
      if (isSafe(board, n, count, i)) {
        board[i][count] = 1;
        queenPositionsOnNBoard(n, board, count + 1,solution);
        board[i][count] = 0;
      }
    }
  }

  private boolean isSafe(int[][] board, int n, int count, int row) {
    for(int i = 0; i<count;i++)
      if(board[row][i] == 1)
        return false;

    for(int i = row,  j = count; i>=0 && j>=0; i--,j--)
      if(board[i][j]==1)
        return false;

    for(int i = row,  j = count; i<n && j>=0; i++,j--)
      if(board[i][j]==1)
        return false;
    return true;
  }

  public void ratInAMaze(int n, int[][] maze){
    List<String> paths = new ArrayList<>();
    pathInAMaze(n,maze,"", 0,0,paths);
    System.out.println(paths);
  }


  private void pathInAMaze(int n, int[][] maze, String s, int i, int j, List<String> paths) {
    if(i == n-1 && j == n-1) {
      paths.add(s);
      return;
    }
    if (i < 0 || j < 0 || i >= n || j >= n || maze[i][j] != 1 )
      return;

    maze[i][j] = -1;
    pathInAMaze(n,maze,s+"d",i+1,j,paths);
    pathInAMaze(n,maze,s+"r",i,j+1,paths);
    pathInAMaze(n,maze,s+"u", i-1,j,paths);
    pathInAMaze(n,maze,s+"l",i,j-1,paths);
    maze[i][j] = 1;
  }
}




