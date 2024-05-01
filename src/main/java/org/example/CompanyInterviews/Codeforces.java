package org.example.CompanyInterviews;

import java.util.*;

public class Codeforces {

  public void theGreatEquilizer() {
//  import java.util.*;
//
//  public final class Solution {
//    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCases = scanner.nextInt();

    for (int i = 0; i < testCases; i++) {
      int n = scanner.nextInt();
      {
        Integer[] arr = new Integer[n];
        for (int j = 0; j < n; j++) {
          arr[j] = scanner.nextInt();
        }
        int q = scanner.nextInt();
        for (int op = 0; op < q; op++) {
          int elementpos = scanner.nextInt();
          int testreplace = scanner.nextInt();
          arr[elementpos - 1] = testreplace;
          ArrayList<Integer> unique = new ArrayList<>(List.of(arr));
          Collections.sort(unique);
          int index = 0;
          for (int k = 1; k < unique.size(); k++) {
            if (unique.get(k) != unique.get(index)) {
              index++;
              unique.set(index, unique.get(k));
            }
          }
          if (unique.stream().distinct().count() == 1) {
            System.out.println(unique);
            break;
          } else {
            for (int l = 0; l < unique.size(); l++) {
              unique.set(l, (unique.get(l) + (unique.size() - l)));
            }
            System.out.println(unique);
          }
        }
      }
    }
  }

  public void canISquare(int n, int[] arr) {
    System.out.println(Arrays.toString(arr));
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum = sum + arr[i];
    }
    int low = 1;
    int high = sum / 2;
    while (low <= high) {
      int mid = (low + high) / 2;
      int square = mid * mid;
      if (square == sum)
        System.out.println("yes");
      if (square < sum) {
        low = mid + 1;
      } else
        high = mid - 1;
    }
    System.out.println("no");
  }

  public void buildingAnAquarium(int columns, int waterCap, int[] coralHeight) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int j : coralHeight) {
      max = Math.max(max, j);
      min = Math.min(min, j);
    }
    if(max*columns<waterCap)
      max=waterCap;
    while (min <= max) {
      int actualSum = 0;
      int mid = (min + max) / 2;
      for (int i : coralHeight) {
        int height = Math.min(mid, i);
        actualSum += height;
      }
      int matrixsum = mid * columns;
      if (matrixsum - actualSum <= waterCap) {
        min = mid + 1;
      } else {
        max = mid - 1;
      }
    }
    System.out.println(max);
  }
}



