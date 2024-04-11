package org.example.CompanyInterviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
}



