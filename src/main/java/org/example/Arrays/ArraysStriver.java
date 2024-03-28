package org.example.Arrays;

import org.example.CompanyInterviews.BigBasket;
import org.example.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import static org.example.CompanyInterviews.BigBasket.reverse;

public class ArraysStriver {
  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void reverseArray(int[] arr, int i, int j) {
    while (i <= j) {
      swap(arr, i, j);
      i++;
      j--;
    }
  }

  public void largestElementInAnArray(int[] arr, int n) {
    System.out.println("Largest element in an array!");
    System.out.println(Arrays.toString(arr));
    int largest = arr[0];
    if (n > 1) {
      for (int i = 1; i < n; i++) {
        if (arr[i] > largest)
          largest = arr[i];
      }
    }
    System.out.println("Largest=" + largest);
  }

  public void secondLargestElementInAnArray(int[] arr, int n) {
    System.out.println("Second Largest element in an array!");
    System.out.println(Arrays.toString(arr));
    int large = Integer.MIN_VALUE;
    int slarge = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      if (arr[i] > large) {
        slarge = large;
        large = arr[i];
      } else if (arr[i] > slarge && arr[i] != large)
        slarge = arr[i];
    }
    if (slarge == Integer.MIN_VALUE)
      slarge = -1;
    System.out.println("Second largest=" + slarge);
  }

  public void checkIfArrayIsSorted(int[] arr, int n) {
    System.out.println("Check if an array is sorted!");
    System.out.println(Arrays.toString(arr));
    boolean isSorted = true;
    for (int i = 0; i < n - 1; i++) {
      if (arr[i] > arr[i + 1]) {
        isSorted = false;
        break;
      }
    }
    System.out.println("Array is sorted?=" + isSorted);
  }

  public void removeDuplicatesFromSortedArray(int[] arr, int n) {
    System.out.println("Remove duplicates from an array!");
    System.out.println(Arrays.toString(arr));
    int index = 0;
    for (int i = 1; i < n; i++) {
      if (arr[index] != arr[i]) {
        index++;
        arr[index] = arr[i];
      }
    }
    System.out.println("New Array is=" + Arrays.toString(arr));
    System.out.println("Number of unique elements=" + (index + 1));
  }

  public void leftRotateAnArrayBy1Place(int[] arr, int n) {
    System.out.println("Rotate an array by 1 place!");
    int temp = arr[0];
    for (int i = 0; i < n - 1; i++) {
      arr[i] = arr[i + 1];
    }
    arr[n - 1] = temp;
    System.out.println(Arrays.toString(arr));
  }

  public void leftRotateAnArrayByDPlaces(int[] arr, int n, int d) {
    System.out.println("Rotate an array by D places!");
    if (n == 0)
      return;
    d = d % n;
    if (d > n)
      return;
    int[] temp = new int[d];
    System.arraycopy(arr, 0, temp, 0, d);
    for (int i = 0; i < n - d; i++)
      arr[i] = arr[i + d];
    if (n - (n - d) >= 0) System.arraycopy(temp, -d + d, arr, n - d, n - (n - d));
    System.out.println(Arrays.toString(arr));
  }

  public void moveZerosToEnd(int[] arr, int n) {
    System.out.println("Moved Array with Zeros at the end!");
    int index = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] != 0) {
        arr[index] = arr[i];
        index++;
      }
    }
    for (int i = index + 1; i < n; i++)
      arr[i] = 0;
    System.out.println(Arrays.toString(arr));
  }

  public void linearSearch(int[] arr, int n, int k) {
    for (int i = 0; i < n; i++) {
      if (arr[i] == k)
        System.out.println("Element found at index " + i);
    }
  }

  public void unionOfTwoArrays(int[] arr1, int[] arr2, int m, int n) {
    System.out.println("Union of two arrays!");
    HashSet<Integer> arrayList = new HashSet<>();
    for (int i = 0; i < m; i++)
      arrayList.add(arr1[i]);
    for (int i = 0; i < n; i++)
      arrayList.add(arr2[i]);
    System.out.println(arrayList);
  }

  public void intersectionOfTwoArrays(int[] arr1, int[] arr2, int m, int n) {
    System.out.println("Intersection of two arrays!");
    ArrayList<Integer> arrayList = new ArrayList<>();
    HashSet<Integer> h = new HashSet<>();
    for (int i = 0; i < m; i++)
      h.add(arr1[i]);
    for (int i = 0; i < n; i++) {
      if (h.contains(arr2[i]))
        arrayList.add(arr2[i]);
    }
    System.out.println(arrayList);
  }

  public void findMissingElement(int[] arr, int n) {
    System.out.println("Find missing element!");
    if (n < 1)
      return;
    int expectedSum = 0;
    int actualSum = ((n + 1) * (n + 2)) / 2;
    for (int i = 0; i < n; i++) {
      expectedSum += arr[i];
    }
    System.out.println("Missing number is =" + (actualSum - expectedSum));
  }

  public void findNumberThatAppearsOnce(int[] arr, int n) {
    int num = 0;
    for (int i = 0; i < n; i++) {
      num ^= arr[i];
    }
    System.out.println("Number that appeared once - " + num);
  }

  public void findMaximumConsecutiveOnes(int[] arr, int n) {
    System.out.println(Arrays.toString(arr));
    int ccount = 0;
    int maximum = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] == 1) {
        ccount = ccount + 1;
        maximum = Math.max(maximum, ccount);
      } else
        ccount = 0;
    }
    System.out.println("Maximum consecutive one's are :" + maximum);
  }

  public void longestSubArrayWithSumKPositives(int[] arr, int k) {
    System.out.println(Arrays.toString(arr));
    int sum = 0;
    int count = 0;
    int maxi = 0;
    for (int j : arr) {
      sum += j;
      if (sum < k) {
        count++;
      }
      if (sum == k) {
        count++;
        maxi = Math.max(count, maxi);
        sum = 0;
        count = 0;
      } else if (sum > k) {
        sum = 0;
        count = 0;
      }
    }
    if (maxi != k)
      System.out.println("Not found!");
    else
      System.out.println("Maximum sub array whose sum = k " + maxi);
  }

  public void longestSubArrayWithSumKNegatives(int[] arr, int k) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    System.out.println(Arrays.toString(arr));
    int sum = 0;
    int max = 0;
    int end = -1;
    int start = -1;
    for (int i = 0; i < arr.length; i++) {
      sum = sum + arr[i];
      if (sum == k) {
        max = Math.max(i + 1, max);
      }
      int rem = sum - k;
      if (hashMap.containsKey(rem)) {
        int len = i - hashMap.get(rem);
        max = Math.max(max, len);
        start = hashMap.get(rem) + 1;
        end = i;
      }
      if (!hashMap.containsKey(sum)) {
        hashMap.put(sum, i);
      }
    }
    System.out.println("Maximum length sub array = " + max);
    if (start != -1) {
      for (int i = start; i <= end; i++) {
        System.out.print(" " + arr[i] + ",");
      }
      System.out.println();
    }
  }

  public void twoSum(int[] arr, int k) {
    System.out.println("Print two numbers whose sum is given K!");
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    int compliment = 0;
    int firstIndex = -1;
    int secondIndex = -1;
    if (arr.length < 2)
      return;
    for (int i = 0; i < arr.length; i++) {
      compliment = k - arr[i];
      if (hashMap.containsKey(compliment)) {
        firstIndex = hashMap.get(compliment);
        secondIndex = i;
      }
      hashMap.put(arr[i], i);
    }
    if (firstIndex != -1)
      System.out.println("Indexes are: " + firstIndex + " " + secondIndex);
    else
      System.out.println("NOt found!");

    /*
    sort the numbers and then use two pointers left and right and add them where left is 0 and right is n
     decrement the loop on right if summation is greater than target
     or increment left if summation is less than target.
     print yes or no
     */
  }

  public void sort0and1and2(int[] arr, int n) {
    /* Dutch flag algorithm */
    System.out.println("Sorted array of 0's, 1's and 2's");
    System.out.println(Arrays.toString(arr));
    int low = 0;
    int mid = 0;
    int high = n - 1;
    while (mid <= high) {
      if (arr[mid] == 0) {
        swap(arr, mid, low);
        low++;
        mid++;
      } else if (arr[mid] == 1) {
        mid++;
      } else if (arr[mid] == 2) {
        swap(arr, mid, high);
        high--;
      }
    }
    System.out.println(Arrays.toString(arr));
  }

  public void majorityElementMoreThanNby2(int[] arr, int n) {
    System.out.println("Majority element in the array!");
    /* Moore's voting algorithm */
    System.out.println(Arrays.toString(arr));
    if (n <= 1)
      return;
    int count = 1;
    int element = arr[0];
    for (int i = 1; i < n; i++) {
      if (arr[i] != element)
        count--;
      else if (count == 0)
        element = arr[i];
      else
        count++;
    }
    System.out.println("Majority element is" + element);
  }

  public void maximumSubArraySumKadene(int[] arr, int n) {
    System.out.println("Maximum subarray sum!");
    System.out.println(Arrays.toString(arr));
    int sum = 0;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      sum = sum + arr[i];
      if (sum < 0) {
        sum = 0;
      }
      max = Math.max(sum, max);
    }
    System.out.println("Max sum is " + max);
  }

  public void maximumSubArrayKadene(int[] arr, int n) {
    System.out.println("Maximum subarray!");
    System.out.println(Arrays.toString(arr));
    int sum = 0;
    int max = Integer.MIN_VALUE;
    int start = -1;
    int end = -1;
    for (int i = 0; i < n; i++) {

      sum = sum + arr[i];
      if (sum > max) {
        max = sum;
        end = i;
      }
      if (sum < 0) {
        sum = 0;
        start = i + 1;
      }
    }
    System.out.println("Array is as follows");
    for (int i = start; i <= end; i++)
      System.out.print(+arr[i] + ",");
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

  public void rotateMatrixBy90(int[][] arr, int m, int n) {
    System.out.println("Rotate a matrix by 90!");
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
    for (int i = 0; i < m; i++) {
      for (int j = i; j < n; j++) {
        if (i != j)
          BigBasket.swap(arr, i, j);
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

  public void rearrangeBySign(int[] arr, int n) {
    System.out.println("Rearrange equal elements by sign!");
    int[] solArray = new int[n];
    int posIndex = 0;
    int negIndex = 1;
    for (int i = 0; i < n; i++) {
      if (arr[i] > 0) {
        solArray[posIndex] = arr[i];
        posIndex += 2;
      } else if (arr[i] < 0) {
        solArray[negIndex] = arr[i];
        negIndex += 2;
      }
    }
    System.out.println(Arrays.toString(solArray));
  }

  public void rearrangeBySignUnequal(int[] arr, int n) {
    System.out.println("Rearrange unequal elements by sign!");
    ArrayList<Integer> pos = new ArrayList<>();
    ArrayList<Integer> neg = new ArrayList<>();
    int itrn = n;
    int flag = -1;
    for (int i = 0; i < n; i++) {
      if (arr[i] > 0) {
        pos.add(arr[i]);
      } else {
        neg.add(arr[i]);
      }
    }
    if (pos.size() < neg.size()) {
      itrn = pos.size();
    } else if (pos.size() > neg.size()) {
      itrn = neg.size();
      flag = 1;
    }

    for (int i = 0; i < itrn; i++) {
      arr[2 * i] = pos.get(i);
      arr[2 * i + 1] = neg.get(i);
    }
    //TO-D0 add separation
    System.out.println(Arrays.toString(arr));
  }

  public void nextPermutation(int[] arr, int n) {
    System.out.println("Print next permutation of" +Arrays.toString(arr));
    int breakpoint = -1;
    for (int i = n - 2; i > 0; i--) {
      if (arr[i] < arr[i + 1]) {
        breakpoint = i;
        break;
      }
    }
    if (breakpoint == -1)
      reverseArray(arr, 0, n);

    for (int i = n - 1; i > breakpoint; i--) {
      if (arr[i] > arr[breakpoint]) {
        swap(arr, breakpoint, i);
        break;
      }
    }
    reverseArray(arr, breakpoint + 1, n - 1);
    System.out.println(Arrays.toString(arr));
  }

  public void leadersInAnArray(int[] arr, int n) {
    System.out.println("Leaders in an array"+ Arrays.toString(arr));
    int cleader = arr[n - 1];
    for (int i = n - 1; i > 0; i--) {
      if (arr[i] >= cleader) {
        cleader = arr[i];
        System.out.print(cleader + " ");
      }
    }
  }

  public void lengthOfLongestConsecutiveElements(int[] arr, int n) {
    System.out.println("Length of longest consecutive elements in"+ Arrays.toString(arr));
    HashSet<Integer> hashSet = new HashSet<>();
    if(n==0)
      return;;
    int maxLen = 1;
    for (int i = 0; i < n; i++)
      hashSet.add(arr[i]);
    for (int i : hashSet) {
      if (!hashSet.contains(i- 1)) {
        int count = 1;
        int index = i;
        while (hashSet.contains(index + 1)) {
          index++;
          count++;
        }
        maxLen = Math.max(maxLen, count);
      }
    }
    System.out.println("Length"+maxLen);
  }
}


