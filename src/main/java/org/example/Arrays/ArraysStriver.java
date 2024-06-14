package org.example.Arrays;

import org.example.Companies.BigBasket;

import java.util.*;

import static org.example.Companies.BigBasket.reverse;

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
    System.out.println("Print next permutation of" + Arrays.toString(arr));
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
    System.out.println("Leaders in an array" + Arrays.toString(arr));
    int cleader = arr[n - 1];
    for (int i = n - 1; i > 0; i--) {
      if (arr[i] >= cleader) {
        cleader = arr[i];
        System.out.print(cleader + " ");
      }
    }
  }

  public void lengthOfLongestConsecutiveElements(int[] arr, int n) {
    System.out.println("Length of longest consecutive elements in" + Arrays.toString(arr));
    HashSet<Integer> hashSet = new HashSet<>();
    if (n == 0)
      return;
    int maxLen = 1;
    for (int i = 0; i < n; i++)
      hashSet.add(arr[i]);
    for (int i : hashSet) {
      if (!hashSet.contains(i - 1)) {
        int count = 1;
        int index = i;
        while (hashSet.contains(index + 1)) {
          index++;
          count++;
        }
        maxLen = Math.max(maxLen, count);
      }
    }
    System.out.println("Length" + maxLen);
  }

  public void printMatrixInSpiralOrder(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int left = 0;
    int top = 0;
    int right = cols - 1;
    int bottom = rows - 1;
    ArrayList<Integer> ans = new ArrayList<>();
    while (left <= right && top <= bottom) {
      for (int i = left; i <= right; i++) {
        ans.add(matrix[top][i]);
      }
      top++;
      for (int i = top; i <= bottom; i++) {
        ans.add(matrix[i][right]);
      }
      right--;
      if (top <= bottom) {
        for (int i = right; i >= left; i--) {
          ans.add(matrix[bottom][i]);
        }
        bottom--;
      }
      if (left <= right) {
        for (int i = bottom; i >= top; i--) {
          ans.add(matrix[i][left]);
        }
        left++;
      }
    }
    System.out.println(ans);
  }

  public void countSubArraysWithSumK(int[] arr, int k) {
    int preSum = 0;
    int count = 0;
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    hashMap.put(0, 1);
    for (int i = 0; i < arr.length; i++) {
      preSum = preSum + arr[i];
      int rem = preSum - k;
      count = count + hashMap.getOrDefault(rem, 0);
      hashMap.put(preSum, hashMap.getOrDefault(preSum, 0) + 1);
    }
    System.out.println(count);
  }

  public void pascalsTriangle(int n) {
    ArrayList<ArrayList<Integer>> pascals = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      pascals.add(generateRow(i));
    }
    pascals.forEach(System.out::println);
  }

  public ArrayList<Integer> generateRow(int n) {
    ArrayList<Integer> row = new ArrayList<>();
    long ans = 1;
    row.add((int) ans);
    for (int i = 1; i < n; i++) {
      ans = ans * (n - i);
      ans = ans / i;
      row.add((int) ans);
    }
    return row;
  }

  public void majorityElementN3(int[] arr, int n) {
    int count1 = 0;
    int element1 = Integer.MIN_VALUE;
    int count2 = 0;
    int element2 = Integer.MIN_VALUE;
    int n3 = (n / 3);
    for (int i = 0; i < n; i++) {
      if (count1 == 0 && arr[i] != element2) {
        count1++;
        element1 = arr[i];
      } else if (count2 == 0 && arr[i] != element1) {
        count2++;
        element2 = arr[i];
      } else if (element1 == arr[i])
        count1++;
      else if (element2 == arr[i])
        count2++;
      else {
        count1--;
        count2--;
      }
    }
    int cnt1 = 0;
    int cnt2 = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] == element1)
        cnt1++;
      if (arr[i] == element2)
        cnt2++;
    }
    if (cnt1 > n3) System.out.println(element1);
    if (cnt2 > n3) System.out.println(element2);
  }

  public void longestSubArrayWithSumZero(int[] arr) {
    int preSum = 0;
    int maximum = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      preSum = preSum + arr[i];
      if (preSum == 0)
        maximum = i + 1;
      else if (map.get(preSum) != null) {
        maximum = Math.max(maximum, i - map.get(preSum));
      } else
        map.put(preSum, i);
    }
    System.out.println("Maximum is" + maximum);
  }

  public void maximumProductSubArray(int[] arr, int n) {
    int prefix = 1;
    int suffix = 1;
    int maximum = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      if (prefix == 0)
        prefix = 1;
      if (suffix == 0)
        suffix = 1;
      prefix = prefix * arr[i];
      suffix = suffix * arr[n - i - 1];
      maximum = Math.max(maximum, Math.max(prefix, suffix));
    }
    System.out.println(maximum);
  }

  public void countSubarraysWithXORK(int[] arr, int n, int k) {
    int pre = 0;
    int count = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    for (int i = 0; i < n; i++) {
      pre = pre ^ arr[i];
      int rem = pre ^ k;
      count = count + map.getOrDefault(rem, 0);
      map.put(pre, map.getOrDefault(pre, 0) + 1);
    }
    System.out.println(count);
  }

  public void mergeOverlappingIntervals(int[][] arr) {
    System.out.println(Arrays.deepToString(arr));
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

    for (int i = 0; i < arr.length; i++) {
      if (res.isEmpty() || arr[i][0] > res.get(res.size() - 1).get(1))
        res.add(Arrays.asList(arr[i][0], arr[i][1]));
      else
        res.get(res.size() - 1).set(1, Math.max(res.get(res.size() - 1).get(1), arr[i][1]));
    }
    System.out.println(res);
  }

  public void mergeSortedArraysUsingThirdArray(int[] arr1, int[] arr2) {
    System.out.println(Arrays.toString(arr1) + " " + Arrays.toString(arr2));
    long[] arr3 = new long[arr1.length + arr2.length];
    int left = 0;
    int right = 0;
    int index = 0;
    while (left < arr1.length && right < arr2.length) {
      if (arr1[left] <= arr2[right]) {
        arr3[index] = arr1[left];
        left++;
        index++;
      } else {
        arr3[index] = arr2[right];
        right++;
        index++;
      }
    }
    while (left < arr1.length)
      arr3[index++] = arr1[left++];
    while (right < arr2.length)
      arr3[index++] = arr2[right++];
    System.out.println(Arrays.toString(arr3));
  }

  public void mergeSortedArraysWithoutUsingThirdArray(int[] arr1, int[] arr2) {
    System.out.println(Arrays.toString(arr1) + " " + Arrays.toString(arr2));
    int left = arr1.length - 1;
    int right = 0;
    while (left >= 0 && right < arr2.length) {
      if (arr1[left] > arr2[right]) {
        int temp = arr1[left];
        arr1[left] = arr2[right];
        arr2[right] = temp;
        left--;
        right++;
      } else
        break;
    }
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    System.out.println(Arrays.toString(arr1) + " " + Arrays.toString(arr2));
  }

  public void threeSumProblem(int[] arr, int n) {
    //brute is to loop three times and find all combi
    //better is to use a hash for summation of two elements minus the third and keeping it in set data to get only unique sorted pairs
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(arr);
    for (int i = 0; i < n; i++) {
      if (i != 0 && arr[i] == arr[i - 1]) continue;
      int j = i + 1;
      int k = n - 1;
      while (j < k) {
        int sum = arr[i] + arr[j] + arr[k];
        if (sum < 0)
          j++;
        else if (sum > 0)
          k--;
        else {
          List<Integer> integers = Arrays.asList(arr[i], arr[j], arr[k]);
          ans.add(integers);
          j++;
          k--;
          while (j < k && arr[j] == arr[j - 1]) j++;
          while (j < k && arr[k] == arr[k + 1]) k--;
        }
      }
    }
    System.out.println(ans);
  }

  public void fourSumProblem(int[] arr, int n, int target) {
    System.out.println("Original array=" + Arrays.toString(arr));
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(arr);
    System.out.println("After sorting=" + Arrays.toString(arr));
    for (int i = 0; i < n; i++) {
      if (i != 0 && arr[i] == arr[i - 1]) continue;
      for (int j = i + 1; j < n; j++) {
        if (j != i + 1 && arr[j] == arr[j - 1]) continue;
        int k = j + 1;
        int l = n - 1;
        while (k < l) {
          int sum = arr[i] + arr[j] + arr[k];
          sum = sum + arr[l];
          if (sum < target)
            k++;
          else if (sum > target)
            l--;
          else {
            List<Integer> integers = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
            ans.add(integers);
            k++;
            l--;
            while (k < l && arr[k] == arr[k - 1]) k++;
            while (k < l && arr[l] == arr[l + 1]) l--;
          }
        }
      }
    }
    System.out.println(ans);


  }

  public void findMissingAndRepeatingNumber(int[] arr, int n) {
    int expectedSum = (n * (n + 1)) / 2;
    int expectedSquare = (n * (n + 1) * (2 * n + 1)) / 6;
    int actualSum = 0;
    int actualSquare = 0;
    for (int i = 0; i < n; i++) {
      actualSum += arr[i];
      actualSquare += arr[i] * arr[i];
    }
    int xminusy = expectedSum - actualSum;
    int x2minusy2 = expectedSquare - actualSquare;
    int xplusy = x2minusy2 / xminusy;
    int missing = (xminusy + xplusy) / 2;
    int repeating = missing - xminusy;

    System.out.println(missing + " " + repeating);
  }

  public int countInversions(int[] arr, int low, int high) {
    //application of merge sort
    int count = 0;
    if (low >= high) return count;
    int mid = (low + high) / 2;
    count += countInversions(arr, low, mid);
    count += countInversions(arr, mid + 1, high);
    count += merge(arr, low, mid, high);
    return count;
  }

  public int merge(int[] arr, int low, int mid, int high) {
    int left = low;
    int right = mid + 1;
    int count = 0;
    while (low <= mid && right <= high) {
      if (arr[left] <= arr[right])
        left++;
      else {
        count = count + (mid - left + 1);
        right++;
      }
    }
    while (left <= mid)
      left++;

    while ((right <= high))
      right++;
    return count;
  }

  public int countReversePairs(int[] arr, int low, int high) {
    //application of merge sort
    int count = 0;
    if (low >= high) return count;
    int mid = (low + high) / 2;
    count += countInversions(arr, low, mid);
    count += countInversions(arr, mid + 1, high);
    count += countPairs(arr, low, mid, high);
    reverseMerge(arr, low, mid, high);
    return count;
  }

  public void reverseMerge(int[] arr, int low, int mid, int high) {
    int left = low;
    int right = mid + 1;
    while (low <= mid && right <= high) {
      if (arr[left] <= arr[right])
        left++;
      else {
        right++;
      }
    }
    while (left <= mid)
      left++;

    while ((right <= high))
      right++;
  }

  public int countPairs(int[] arr, int low, int mid, int high) {
    int count = 0;
    int right = mid + 1;
    for (int i = low; i <= mid; i++) {
      while (right <= high && arr[i] > 2 * arr[right]) right++;
      count = count + (right - (mid + 1));
    }
    return count;
  }
}



