package org.example.Arrays.Striver;

import java.util.Arrays;

public class BinarySearchStriver {
  public void binarySearch(int[] arr, int k) {
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] == k) {
        System.out.println("element found at" + (mid + 1));
        break;
      } else if (arr[mid] < k)
        low = mid + 1;
      else if (arr[mid] > k)
        high = mid - 1;

    }
  }

  public void lowerBound(int[] arr, int k) {
    int low = 0;
    int high = arr.length - 1;
    int lb = k;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] >= k) {
        high = mid - 1;
        lb = mid;
      } else if (arr[mid] < k)
        low = mid + 1;
    }
    System.out.println(lb);
  }

  public void higherBound(int[] arr, int k) {
    int low = 0;
    int high = arr.length - 1;
    int hb = 0;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] > k) {
        high = mid - 1;
        hb = mid;
      } else if (arr[mid] <= k)
        low = mid + 1;
    }
    System.out.println(hb);
  }

  public void searchIndexPosition(int[] arr, int k) {
    int low = 0;
    int high = arr.length - 1;
    int index = -1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] == k) {
        System.out.println("Already exists at index=" + (mid + 1));
        return;
      } else if (arr[mid] >= k) {
        high = mid - 1;
        index = mid;
      } else if (arr[mid] < k)
        low = mid + 1;
    }
    System.out.println("Insert at =" + index);
  }

  public void findFloorAndCeil(int[] arr, int k) {
    System.out.println(Arrays.toString(arr));
    int low = 0;
    int high = arr.length - 1;
    int floor = -1;
    int ceil = -1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] == k) {
        floor = mid;
        ceil = mid;
        break;
      } else if (arr[mid] > k) {
        high = mid - 1;
        ceil = mid;
      } else if (arr[mid] < k) {
        low = mid + 1;
        floor = mid;
      }
    }
    System.out.println(floor + " " + ceil);
  }

  public void lastOccuranceOfElement(int[] arr, int k) {
    int low = 0;
    int high = arr.length - 1;
    int last = -1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] == k) {
        last = mid;
        low = mid + 1;
      } else if (arr[mid] > k)
        high = mid - 1;
      else if (arr[mid] < k)
        low = mid + 1;
    }
    System.out.println("element is at index" + (last + 1));
  }

  public void occurancesOfANumber(int[] arr, int k) {
    int low = 0;
    int high = arr.length - 1;
    int count = 0;
    int first = 0;
    int last = 0;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] == k) {
        first = mid;
        high = mid - 1;
      } else if (arr[mid] > k)
        high = mid - 1;
      else if (arr[mid] < k)
        low = mid + 1;
    }
    int start = 0;
    int end = arr.length - 1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (arr[mid] == k) {
        last = mid;
        start = mid + 1;
      } else if (arr[mid] > k)
        end = mid - 1;
      else if (arr[mid] < k)
        start = mid + 1;
    }
    System.out.println((last - first + 1));
  }
}
