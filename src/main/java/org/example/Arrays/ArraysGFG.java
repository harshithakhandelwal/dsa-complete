package org.example.Arrays;

import java.util.Arrays;

public class ArraysGFG {
  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public void findLargestThreeElements(int[] arr) {
    int fl = Integer.MIN_VALUE;
    int sl = Integer.MIN_VALUE;
    int tl = Integer.MIN_VALUE;

    for (int j : arr) {
      if (j > fl) {
        tl = sl;
        sl = fl;
        fl = j;
      } else if (j > sl && j != fl && j != tl)
        sl = j;
      else if (j > tl && j != sl && j != fl)
        tl = j;
    }
    System.out.println("First" + fl + "second" + sl + "Third" + tl);
  }

  public void rearrangeSuchThatEvenPositionIsGreaterThanOdd(int[] arr) {
    for (int i = 0; i < arr.length; i += 2) {
      if (i > 0 && arr[i - 1] > arr[i]) {
        int temp = arr[i - 1];
        arr[i - 1] = arr[i];
        arr[i] = temp;
      }

      if (i < arr.length - 1 && arr[i + 1] > arr[i]) {
        int temp = arr[i + 1];
        arr[i + 1] = arr[i];
        arr[i] = temp;
      }
    }
    System.out.println(java.util.Arrays.toString(arr));
  }

  public void rearrangeASortedArrayInMaximumMinimum(int[] arr) {
    int n = arr.length;
    int[] sol = new int[n];
    int mini = 0;
    int maxi = n - 1;
    for (int i = 0; i < n; i++) {
      if (mini < maxi) {
        sol[2 * i] = arr[maxi];
        sol[2 * i + 1] = arr[mini];
        mini = mini + 1;
        maxi = maxi - 1;
      } else if (mini == maxi) {
        sol[2 * i] = arr[mini];
        break;
      }
    }
    System.out.println(java.util.Arrays.toString(sol));
  }

  public void segregateArrayEvenAndOddElements(int[] arr) {
    int n = arr.length;
    int oi = n - 1;
    int ei = 0;
    while (ei < oi) {
      while (arr[ei] % 2 == 0) ei++;
      while (arr[oi] % 2 != 0) oi--;
      int temp = arr[ei];
      arr[ei] = arr[oi];
      arr[oi] = temp;
      ei++;
      oi--;
    }
    System.out.println(java.util.Arrays.toString(arr));
  }

  public void cyclicSort(int[] arr) {
    int n = arr.length;
    int i = 0;
    while (i < n) {
      int actualIndex = arr[i] - 1;
      if (arr[i] != arr[actualIndex]) {
        int temp = arr[i];
        arr[i] = arr[actualIndex];
        arr[actualIndex] = temp;
      } else i++;
    }
    System.out.println(java.util.Arrays.toString(arr));
  }

  public void countNumberOfPossibleTriangles(int[] arr) {
    int n = arr.length;
    Arrays.sort(arr);
    int count = 0;
    for (int i = n - 1; i >= 1; i--) {
      int l = 0;
      int r = i - 1;
      while (l < r) {
        if (arr[l] + arr[r] > arr[i]) {
          count += r - l;
          r--;
        } else
          l++;
      }
    }
    System.out.println(count);
  }

  public void reArrangeElementWithIndex(int[] arr) {
    System.out.println(Arrays.toString(arr));
    int n = arr.length;
//    for(int i = 0;i<arr.length;i++) {
//      int actualIndex = arr[i];
//      if (actualIndex<n && actualIndex>0 && arr[i] != arr[actualIndex])
//        swap(arr,i,actualIndex);
//      else if(actualIndex==i)
//        swap(arr,i,actualIndex);
//      else arr[i] = -1;
//      }
    for (int i = 0; i < n; i++) {
      int actualIndex = arr[i];
      if (actualIndex < n && actualIndex > 0)
        swap(arr, i, actualIndex);
    }
    System.out.println(Arrays.toString(arr));
  }

  public void reArrangeElementWithIndexInAnotherArray(int[] arr, int[] index) {
    int n = arr.length;
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(index));
    for (int i = 0; i < n; i++) {
      int actualIndex = index[i];
      swap(arr, i, actualIndex);
      swap(index, i, actualIndex);
    }
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(index));
  }

  public void findTheSmallestMissingNumber(int[] arr, int m) {
    System.out.println(Arrays.toString(arr));
    int n = arr.length;
    int low = 0;
    int high = n - 1;
    int smallest = -1;
    if (n == m)
      return;
    if (arr[high] == high)
      smallest = n;
    if (arr[low] != low)
      smallest = low;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] == mid) {
        low = mid + 1;
      } else {
        high = mid - 1;
        smallest = mid;
      }
    }
    System.out.println(smallest);
  }

  public void KthSumOfAContiguousArray(int[] arr, int k) {
    System.out.println(Arrays.toString(arr));
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      int sum = 0;
      for (int index = i; index < arr.length; index++) {
        sum = sum + arr[index];
        count++;
        if (count == k) {
          System.out.println(sum);
          break;
        }
      }
    }
  }

  public void smallestSubArrayWithSumGreaterThanKValue(int[] arr, int k) {
    /*
     * arr[] = {1, 4, 45, 6, 0, 19}
     * x  =  51
     * Output: 3
     * Minimum length subarray is {4, 45, 6}
     */
    int n = arr.length;
    int psum = 0;
    int minlen = Integer.MAX_VALUE;
    int start = 0;
    for (int i = 0; i < n; i++) {
      psum = psum + arr[i];
      while (psum > k) {
        minlen = Math.min(minlen, i - start + 1);
        psum = psum - arr[start];
        start++;
      }
    }
    System.out.println(minlen);
  }

  public void updateArrayInRange(int[] arr, int[] update) {
    System.out.println(Arrays.toString(arr));
    for (int i = update[0]; i <= update[1]; i++) {
      arr[i] = arr[i] + update[2];
    }
    System.out.println(Arrays.toString(arr));
  }
}


