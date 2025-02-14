package org.example.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class DPgfg {

  public void longestCommonSubsequence(String s1, String s2) {
    int m = s1.length();
    int n = s2.length();
    int[][] memo = new int[m + 1][n + 1];

    for (int i = 0; i <= m; i++) {
      Arrays.fill(memo[i], -1);
    }

    System.out.println(lcsMemoization(m, n, memo, s1, s2));

    System.out.println(lcsDp(s1, s2));
  }

  private int lcsMemoization(int m, int n, int[][] memo, String s1, String s2) {

    if (m == 0 || n == 0)
      return 0;

    if (memo[m][n] != -1)
      return memo[m][n];


    if (s1.charAt(m - 1) == s2.charAt(n - 1))
      return 1 + lcsMemoization(m - 1, n - 1, memo, s1, s2);


    memo[m][n] = Math.max(lcsMemoization(m, n - 1, memo, s1, s2), lcsMemoization(m - 1, n, memo, s1, s2));

    return memo[m][n];
  }

  private int lcsDp(String s1, String s2) {

    int[][] dp = new int[s1.length() + 1][s2.length() + 1];
    for (int i = 1; i <= s1.length(); i++) {
      for (int j = 1; j <= s2.length(); j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1))
          dp[i][j] = 1 + dp[i - 1][j - 1];
        else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }

      }
    }
    return dp[s1.length()][s2.length()];
  }

  public void longestIncreasingSubsequence(int[] arr) {
    int n = arr.length;

    int max = 1;
    int[] memo = new int[n];
    Arrays.fill(memo, -1);
    int sum = Arrays.stream(arr).sum();
    System.out.println(sum);

    for (int i = 1; i < n; i++) {
      max = Math.max(max, lisMemoization(n, arr, memo));
    }
    System.out.println(max);

    lisDp(n, arr);
  }

  private void lisDp(int n, int[] arr) {
    int dp[] = new int[n];
    Arrays.fill(dp, 1);


    for (int i = 0; i < n; i++) {
      for (int prev = 0; prev < i; prev++) {
        if (arr[i] > arr[prev] && dp[i] < dp[prev] + 1)
          dp[i] = dp[prev] + 1;
      }
    }
    int max = 1;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, dp[i]);
    }
  }

  private int lisMemoization(int n, int[] arr, int[] memo) {
    if (n == 0)
      return 1;

    if (memo[n] != -1)
      return memo[n];

    int max = 1;
    for (int prev = 0; prev < n; prev++) {
      if (arr[prev] < arr[n])
        max = Math.max(max, lisMemoization(n, arr, memo) + 1);
    }

    memo[n] = max;

    return memo[n];
  }

  public void editDistance(String s1, String s2) {

    int m = s1.length();
    int n = s2.length();

    int[][] memo = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        memo[i][j] = -1;
      }
    }
    System.out.println(editDistanceMemoization(s1, s2, m, n, memo));
    System.out.println(editDistanceDp(s1, s2));
  }

  private int editDistanceMemoization(String s1, String s2, int m, int n, int[][] memo) {
    if (m == 0) return n;

    if (n == 0) return m;

    if (memo[m][n] != -1) return memo[m][n];

    if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
      memo[m][n] = editDistanceMemoization(s1, s2, m - 1, n - 1, memo);
    } else {

      int insert = editDistanceMemoization(s1, s2, m, n - 1, memo);    // Insert
      int remove = editDistanceMemoization(s1, s2, m - 1, n, memo);    // Remove
      int replace = editDistanceMemoization(s1, s2, m - 1, n - 1, memo); // Replace
      memo[m][n] = 1 + Math.min(insert, Math.min(remove, replace));
    }
    return memo[m][n];
  }

  private int editDistanceDp(String s1, String s2) {
    int m = s1.length();
    int n = s2.length();
    int[][] dp = new int[m + 1][n + 1];


    for (int i = 0; i <= m; i++)
      dp[i][0] = i;
    for (int j = 0; j <= n; j++)
      dp[0][j] = j;

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1))
          dp[i][j] = dp[i - 1][j - 1];
        else
          dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
      }
    }

    return dp[m][n];
  }

  public void partitionSetIntoSubset(ArrayList<Integer> arr){
    int sumTotal = 0;
    for(int num : arr){
      sumTotal += num;
    }

    int[][] memo = new int[arr.size()  + 1][sumTotal +1];

    for(int[] row: memo){
      Arrays.fill(row,-1);
    }
    System.out.println(partitionIntoSubsetMemoization(arr,arr.size(), 0 , sumTotal,memo));
    System.out.println(partitionIntoSubsetDp(arr));


  }

  private int partitionIntoSubsetMemoization(ArrayList<Integer> arr, int n, int sumTillNow, int sumTotal, int[][] memo) {
    if(n == 0){
      return  Math.abs((sumTotal - sumTillNow)-sumTillNow);
    }

    if(memo[n][sumTillNow] !=-1)
      return memo[n][sumTillNow];
    //include
    int include = partitionIntoSubsetMemoization(arr,n-1,sumTillNow+arr.get(n-1),sumTotal,memo);
    //exclude
    int exclude = partitionIntoSubsetMemoization(arr,n-1,sumTillNow,sumTotal,memo);

    memo[n][sumTillNow] = Math.min(include,exclude);
    return memo[n][sumTillNow];
  }

  private int partitionIntoSubsetDp(ArrayList<Integer> arr) {
    int sumTotal = 0;
    int n = arr.size();
    for(int num : arr){
      sumTotal += num;
    }

    boolean[][] dp = new boolean[n  + 1][sumTotal +1];

    dp[0][0] = true;

    for(int i = 1; i<=n; i++){
      for(int j = 0; j<= sumTotal; j++){
        dp[i][j] = dp[i-1][j];

        if(j>=arr.get(i-1)) {
          dp[i][j] = dp[i][j] || dp [i-1][j - arr.get(i-1)];
        }
      }
    }

    return 1;
  }

  public void countNumberOfWaysToCoverDistance(int dist){
    int[] memo = new int[dist + 1]; // Initialize memoization array with 0s
    Arrays.fill(memo, -1);
    int count = countDistanceMemoization(dist,memo);
    System.out.println(count);

  }

  private int countDistanceMemoization(int dist,int[] memo) {
    if(dist<0)
      return 0;
    if(dist==0)
      return 1;

    if(memo[dist]!=-1)
      return memo[dist];

    int count =  countDistanceMemoization(dist-1,memo)
            +countDistanceMemoization(dist-2,memo)
            +countDistanceMemoization(dist-3,memo);

    memo[dist] = count;
    return memo[dist];
  }

  private int countDistanceDp(int dist){

    int []dp = new int[dist+1];
    dp[0] =1;
    if(dist>=1)
      dp[1] = 1;
    if(dist>=2)
      dp[2] = 2;

    for(int i = 3;i<=dist;i++){
      dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
    }
    return dp[dist];
  }

  private int countDistanceDpOptimized(int dist){

    int []dp = new int[3];
    dp[0] =1;
      dp[1] = 1;
      dp[2] = 2;

    for(int i = 3;i<=dist;i++){
      dp[i%3] = dp[(i-1)%3]+dp[(i-2)%3]+dp[(i-3)%3];
    }
    return dp[dist%3];
  }

  public void longestPathInMatrix(int[][] matrix){
    int ans = 0;
    for(int i = 0; i< matrix.length; i++){
      for(int j = 0; j<matrix[0].length;j++){
        int val = longestPathInMatrixDFS(i,j,matrix);
        ans = Math.max(ans,val);
      }
    }
    System.out.println(ans);

    int[][] memo = new int[matrix.length][matrix[0].length];
    for(int[] row:memo)
      Arrays.fill(row,-1);
  }

  private int longestPathInMatrixDFS(int i, int j, int[][] matrix) {
    int ans = 1;
    int[][] directions = { {-1,0},{1,0},{0,-1},{0,1}};
    for(int[] d: directions){
      int x = i+d[0];
      int y = j+d[1];

      if(x>=0 && x<matrix.length && y>=0 && y<matrix[0].length
      && matrix[x][y] == matrix[i][j]+1) {
        ans = Math.max(ans,1+longestPathInMatrixDFS(x,y,matrix));
      }
    }
    return ans;
  }

  private int longestPathInMatrixMemoization(int i, int j, int[][] matrix,int[][] memo) {
    if(memo[i][j]!=-1)
      return memo[i][j];

    int ans = 1;
    int[][] directions = { {-1,0},{1,0},{0,-1},{0,1}};
    for(int[] d: directions){
      int x = i+d[0];
      int y = j+d[1];

      if(x>=0 && x<matrix.length && y>=0 && y<matrix[0].length
              && matrix[x][y] == matrix[i][j]+1) {
        ans = Math.max(ans,1+longestPathInMatrixDFS(x,y,matrix));
      }
    }

    memo[i][j] = ans;
    return memo[i][j];
  }

  public void subsetSum(int[] arr){

    int sum = Arrays.stream(arr).sum();
    int n = arr.length;
    int[][] memo = new int[n + 1][sum + 1];
    for (int[] row : memo) {
      Arrays.fill(row, -1);
    }
    boolean possible =  subsetSumMemoization(arr, n, sum, memo);
    System.out.println(possible);
  }

  private boolean subsetSumMemoization(int[] arr, int n, int sum, int[][] memo) {
    if (sum == 0) {
      return true;
    }

    if (n <= 0) {
      return false;
    }

    if (memo[n][sum] != -1) {
      return memo[n][sum] == 1;
    }


    if (arr[n - 1] > sum) {
      memo[n][sum] = subsetSumMemoization(arr, n - 1, sum, memo)
              ? 1 : 0;
    }
    else {

      memo[n][sum] = (subsetSumMemoization(arr, n - 1, sum, memo)
              || subsetSumMemoization(arr, n - 1, sum - arr[n - 1], memo))
              ? 1 : 0;
    }

    return memo[n][sum] == 1;
  }

  private boolean subsetSumMemoization(int[] arr,int sum){
    int n = arr.length;

    boolean[][] dp = new boolean[n + 1][sum + 1];

    for (int i = 0; i <= n; i++) {
      dp[i][0] = true;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= sum; j++) {
        if (j < arr[i - 1]) {

          dp[i][j] = dp[i - 1][j];
        }
        else {

          dp[i][j] = dp[i - 1][j]
                  || dp[i - 1][j - arr[i - 1]];
        }
      }
    }

    return dp[n][sum];
  }

  public void optimalStrategyForGame(int[] arr){

    int n = arr.length;

    int[][] memo = new int[n][n];
    for (int[] row : memo) {
      Arrays.fill(row, -1);
    }

    int res = optimalStrategyMemoization(0, n - 1, arr, memo);

  }

  private int optimalStrategyMemoization(int i, int j, int[] arr, int[][] memo) {
    if(i<j)
      return 0;
    if(memo[i][j]!=-1)
      return memo[i][j];

    int takeFirst = arr[i]+Math.min(optimalStrategyMemoization(i+2,j,arr,memo),optimalStrategyMemoization(i+1,j-1,arr,memo));
    int takeLast = arr[i]+Math.min(optimalStrategyMemoization(i,j-2,arr,memo),optimalStrategyMemoization(i+1,j-1,arr,memo));

    return memo[i][j] = Math.max(takeFirst,takeLast);
  }

  private int optimalStrategyDp(int[] arr){
    int n = arr.length;

    int[][] dp = new int[n][n];


return 1;
  }

}



