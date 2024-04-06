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

  public void upperBound(int[] arr, int k) {
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

  public void lastOccurrenceOfElement(int[] arr, int k) {
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

  public void occurrencesOfANumber(int[] arr, int k) {
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

  public void searchInRotatedSortedArray(int[] arr, int k) {
    System.out.println(Arrays.toString(arr));
    int low = 0;
    int high = arr.length - 1;
    int sindex = -1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] == k) {
        sindex = mid + 1;
        break;
      }
      if (arr[low] <= arr[mid]) {
        if (arr[low] <= k && k <= arr[mid])
          high = mid - 1;
        else
          low = mid + 1;
      } else {
        if (arr[mid] >= k && k < arr[high])
          low = mid - 1;
        else
          high = mid - 1;
      }
    }
    System.out.println(sindex);
  }

  public void searchInRotatedSortedArrayWithDuplicates(int[] arr, int k) {
    System.out.println(Arrays.toString(arr));
    int low = 0;
    int high = arr.length - 1;
    boolean flag = false;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] == k) {
        flag = true;
        break;
      }
      if (arr[mid] == arr[low] && arr[mid] == arr[high]) {
        low++;
        high--;
        continue;
      }
      if (arr[low] <= arr[mid]) {
        if (arr[low] <= k && k <= arr[mid])
          high = mid - 1;
        else
          low = mid + 1;
      } else {
        if (arr[mid] >= k && k < arr[high])
          low = mid - 1;
        else
          high = mid - 1;
      }
    }
    System.out.println(flag);

  }

  public void minimumInRotatedSortedArray(int[] arr) {
    int low = 0;
    int high = arr.length - 1;
    int min = Integer.MAX_VALUE;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[low] < arr[high]) {
        min = Math.min(arr[low], min);
        break;
      }
      if (arr[low] <= arr[mid] && arr[low] > arr[high]) {
        low = mid + 1;
        min = Math.min(min, arr[low]);
      } else {
        high = mid - 1;
        min = Math.min(min, arr[mid]);
      }
    }
    System.out.println(min);
  }

  public void findNumberOfRotationsOfSortedArray(int[] arr) {
    int low = 0;
    int high = arr.length - 1;
    int min = Integer.MAX_VALUE;
    int minIndex = -1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[low] < arr[high]) {
        minIndex = low;
        break;
      }
      if (arr[low] <= arr[mid] && arr[low] > arr[high]) {
        if (arr[low] < min) {
          minIndex = low;
          min = arr[low];
        }
        low = mid + 1;
      } else {
        if (arr[mid] < min) {
          minIndex = mid;
          min = arr[mid];
        }
        high = mid - 1;
      }
    }
    System.out.println(arr.length - minIndex);
  }

  public void searchSingleElementInSortedArray(int[] arr) {
    //better would be to xor whole array with t(n) complexity. best is using binary search with log n time complexity
    System.out.println(Arrays.toString(arr));
    int low = 1;
    int high = arr.length - 2;
    int ele = 0;
    if (arr.length < 2)
      System.out.println(arr[0]);
    if (arr[0] != arr[1])
      System.out.println(arr[0]);
    if (arr[arr.length - 1] != arr[arr.length - 2])
      System.out.println(arr[arr.length - 1]);

    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]){
        ele = arr[mid];
        break;
        }
      if (mid % 2 == 0 && arr[mid] == arr[mid + 1] || mid % 2 == 1 && arr[mid] == arr[mid - 1])
        low = mid + 1;
      else
        high = mid - 1;
    }
    System.out.println(ele);
  }

  public void findPeakElement(int[] arr){
    System.out.println("Find peak element"+Arrays.toString(arr));
    int low = 1;
    int high = arr.length -2;
    if(arr.length==1)
      System.out.println(arr[0]);
    if(arr[0]>arr[1])
      System.out.println(arr[0]);
    if(arr[arr.length-1]>arr[arr.length-2])
      System.out.println(arr[arr.length-1]);
    while (low<=high){
      int mid = (low+high)/2;
      if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
        System.out.println(arr[mid]);
      if(arr[mid]>arr[mid-1])
        low = mid+1;
      else
        high = mid-1;
    }
  }
}
