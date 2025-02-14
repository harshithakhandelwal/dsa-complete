package org.example.Companies;

import java.util.Arrays;

public class BigBasket {
  public static void swap(int[][] arr, int i, int j) {
    int temp = arr[i][j];
    arr[i][j] = arr[j][i];
    arr[j][i] = temp;
  }

  public static void reverse(int[][] arr, int i, int j, int n) {
    int temp = arr[i][j];
    arr[i][j] = arr[i][n - 1 - j];
    arr[i][n - 1 - j] = temp;
  }

  public void findMinAndMaxOfAnArray(int[] arr, int n) {
    System.out.println(Arrays.toString(arr));
    if (n < 2)
      System.out.println("No min or max!");
    int min = arr[0];
    int max = arr[n - 1];
    for (int i = 0; i < n; i++) {
      if (arr[i] < min)
        min = arr[i];
      else if (arr[i] > max)
        max = arr[i];
    }
    System.out.println(max);
    System.out.println(min);

  }

  public void findAllSubArrayWithSumK(int[] arr, int n) {


  }

  public void removeAnElement(int[] arr, int n, int k) {
    System.out.println("Moved Array with Zeros at the end!");
    int index = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] != k) {
        arr[index] = arr[i];
        index++;
      }
    }
    for (int i = index; i < n; i++)
      arr[i] = k;
    System.out.println(Arrays.toString(arr));

  }

  public void moveAllZerosToRight(int[] arr, int n) {
    System.out.println("Moved Array with Zeros at the end!");
    int index = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] != 0) {
        arr[index] = arr[i];
        index++;
      }
    }
    for (int i = index; i < n; i++)
      arr[i] = 0;
    System.out.println(Arrays.toString(arr));
  }

  public void bestTimeToBuyAndSellStock(int[] arr, int n) {
    System.out.println("Best time to buy and sell stock!");
    if (n < 2)
      return;
    int buy = arr[0];
    int sell = 0;
    int profit = 0;
    for (int i = 1; i < n; i++) {
      if (arr[i] < buy)
        buy = arr[i];
      else if (arr[i] > sell && arr[i] > buy)
        sell = arr[i];
    }
    if (sell == 0)
      System.out.println("cannot find profits!");
    else
      System.out.println("Profit=" + (sell - buy));

  }

  public void mergeSortedArray(int[] arr1, int arr2) {

  }

  public void makeAllElementsOfArrayEqual(int[] arr, int n) {
    int mid = arr.length / 2;
    int ops = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] < arr[mid]) {
        arr[i] = arr[i] + (arr[mid] - arr[i]);
        ops++;
      } else if (arr[i] > arr[mid]) {
        arr[i] = arr[i] - (arr[i] - arr[mid]);
        ops++;
      }
    }
    System.out.println("Number of operations" + ops);
    System.out.println(Arrays.toString(arr));
  }

  public void findNoOfIncrementsTo1(int[] arr) {

  }

  public void rotateMatrixBy90(int[][] arr, int m, int n) {
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
    for (int i = 0; i < m; i++) {
      for (int j = i; j < n; j++) {
        if (i != j)
          swap(arr, i, j);
      }
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n / 2; j++) {
        reverse(arr, i, j, n);
      }
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }

  }

  public void longestSubStringWithUniqueCharacters(String s) {
    int len = 0;
    int ch = s.charAt(0);
    int maxLen = 0;

    for (int i = 1; i < s.length(); i++) {
      maxLen = Math.max(len, maxLen);
      if (s.charAt(i) == ch) {
        ch = s.charAt(i);
        len = 0;
      }
      len++;
    }
    System.out.println(len);
  }


  public void longestCommonPrefix(String s) {

  }

  public void binaryTreeMinimumDepth() {

  }

  public void printBinaryTreeDiagonally() {

  }

  public void binarySumTreeFromBST() {

  }

}
