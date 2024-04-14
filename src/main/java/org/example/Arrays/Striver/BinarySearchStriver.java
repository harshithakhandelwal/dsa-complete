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
      if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]) {
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

  public void findPeakElement(int[] arr) {
    System.out.println("Find peak element" + Arrays.toString(arr));
    int low = 1;
    int high = arr.length - 2;
    if (arr.length == 1)
      System.out.println(arr[0]);
    if (arr[0] > arr[1])
      System.out.println(arr[0]);
    if (arr[arr.length - 1] > arr[arr.length - 2])
      System.out.println(arr[arr.length - 1]);
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
        System.out.println(arr[mid]);
      if (arr[mid] > arr[mid - 1])
        low = mid + 1;
      else
        high = mid - 1;
    }
  }

  public void findSquareRootOfANumberUsingBinarySearch(int n) {
    int low = 1;
    int high = n;
    int sqrt = 0;
    while (low <= high) {
      int mid = (low + high) / 2;
      int square = mid * mid;
      if (square <= n) {
        sqrt = mid;
        low = mid + 1;
      } else
        high = mid - 1;
    }
    System.out.println(sqrt);
  }

  public void findNthRootOfANumber(long n, long m) {
    long low = 1;
    long high = m;
    long root = -1;
    while (low <= high) {
      long mid = (low + high) / 2;
      long ans = (int) Math.pow(mid, n);
      if (ans == m) {
        root = mid;
        break;
      } else if (ans < m) {
        low = mid + 1;
      } else
        high = mid - 1;
    }
    System.out.println(root);
  }

//  public void kokoEatingBananas(int[] piles, int h) {
//    int min = piles[0];
//    int max = piles[piles.length-1];
//    for(int i=0;i<piles.length;i++){
//      if(piles[i]<min)
//        min = piles[i];
//      else if(piles[i]>max)
//        max = piles[i];
//    }
//    double k = min;
//    while(k<=max){
//      double totaltime = 0;
//
//      for (double j : piles) {
//        totaltime +=  Math.ceil(j/k);
//      }
//      if(totaltime<=h) {
//        break;
//      }
//      else {
//        k++;
//      }
//      }
//    System.out.println(k);
//  }

  public void kokoEatingBananas2(int[] piles, int h) {
    int min = piles[0];
    int max = piles[piles.length - 1];
    int k = Integer.MAX_VALUE;
    for (int i = 0; i < piles.length; i++) {
      if (piles[i] < min)
        min = piles[i];
      else if (piles[i] > max)
        max = piles[i];
    }
    while (min <= max) {
      int mid = (min + max) / 2;
      double totaltime = 0;
      for (double j : piles) {
        totaltime += Math.ceil(j / mid);
      }
      if (totaltime <= h) {
        k = Math.min(k, mid);
        max = mid - 1;
      } else if (totaltime > h)
        min = mid + 1;
    }
    System.out.println(k);
  }

  public void minimumDaysToMakeBouquets(int n, int[] day, int m, int k) {
    int min = day[0];
    int max = day[n - 1];
    if (n < (m * k)) {
      System.out.println(-1);
    }
    int mindays = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      if (day[i] < min)
        min = day[i];
      else if (day[i] > max)
        max = day[i];
    }
    while (min < max) {
      int count = 0;
      int bouquet = 0;
      int mid = (min + max) / 2;
      for (int i = 0; i < n; i++) {
        if (day[i] <= mid && count < k)
          count++;
        if (count == k && bouquet <= m) {
          count = 0;
          bouquet++;
        }
      }
      if (bouquet >= m) {
        max = mid - 1;
        mindays = mid;
      } else
        min = mid + 1;
    }
    System.out.println(mindays);
  }

  public void smallestDivisorGivenThreshold(int[] arr, int limit) {
    int min = 1;
    int max = 2;
    int divisor = -1;
    for (int j : arr) {
      if (j > max)
        max = j;
    }
    while (min < max) {
      double sum = 0;
      int mid = (min + max) / 2;
      for (int i = 0; i < arr.length; i++) {
        double ele = Math.ceil((double) arr[i] / (double) mid);
        sum += ele;
      }
      if (sum <= limit) {
        max = mid - 1;
        divisor = mid;
      } else
        min = mid + 1;
    }
    System.out.println(divisor);
  }

  public void capacityToShipWithinDDays(int[] weights, int days) {
    int min = weights[0];
    int max = 0;
    for (int i = 0; i < weights.length; i++) {
      if (weights[i] > min)
        min = weights[i];
      max += weights[i];
    }
    while (min <= max) {
      int load = 0;
      int actdays = 1;
      for (int i = 0; i < weights.length; i++) {
        if ((load + weights[i]) <= min) {
          load += weights[i];
        } else if ((load + weights[i]) > min) {
          load = weights[i];
          actdays++;
        }
      }
      if (actdays <= days) {
        System.out.println(min);
        break;
      }
      min++;
    }
  }

  public void aggressiveCows(int[] stalls, int n, int cows) {
    Arrays.sort(stalls);
    int max = stalls[stalls.length - 1] - stalls[0];
    int min = 1;
    int minmaxdist = Integer.MIN_VALUE;
    while (min <= max) {
      int mid = (max+min)/2;
      if (canWePlace(stalls, mid, cows)) {
        minmaxdist = Math.max(max,minmaxdist);
        min=mid+1;
      }
      else max = mid-1;
    }
    System.out.println(minmaxdist);
  }

  public boolean canWePlace(int[] stalls, int dist, int cows) {
    int placeLast = stalls[0];
    int cntcows = 1;
    for (int i = 1; i < stalls.length; i++) {
      if (stalls[i] - placeLast >= dist) {
        cntcows++;
        placeLast = stalls[i];
      }
      if (cntcows >= cows) return true;
    }
    return false;
  }

  public void allocationOfBooks(int[] pages, int students){
    int noOfBooks = pages.length;
    int sum = 0;
    int min = Integer.MIN_VALUE;
    if(students> noOfBooks)
      System.out.println(-1);
    for (int page : pages) {
      if(page>min)
        min = page;
      sum += page;
    }
    for(int maxpage = 112; maxpage<sum;maxpage++){
      if(countStudents(pages,maxpage)==students) {
        System.out.println(maxpage);
        break;
      }
    }
  }
  public int countStudents(int[] pages, int maxpages){
    int count = 1;
    int pagestudent = 0;
    for (int page : pages) {
      if (page + pagestudent <= maxpages)
        pagestudent = pagestudent + page;
      else {
        count++;
        pagestudent = page;
      }
    }
    return count;
  }

  public void rowWithMax1In2DArray(int[][] matrix,int n, int m){
    int countmax = 0;
    int index = -1;
    for(int i= 0; i<n;i++){
      int curcount = 0;
      for(int j = 0; j<m;j++){
          curcount = curcount+matrix[i][j];
      }
      if(curcount>countmax){
        countmax=curcount;
        index = i;
      }
    }
    System.out.println(index);
  }

  public void searchInA2DMatrix(int[][] matrix, int n, int m,int target) {
    int low = 0;
    int high = (n*m)-1;
    while(low<=high){
      int mid = (low+high)/2;
      int i = mid/m;
      int j = mid%m;
      if(matrix[i][j] == target)
        System.out.println(i+ "" +j);
      if(matrix[i][j]<target)
        low=mid+1;
      else
        high=mid-1;
    }
  }

  public void findPeakElementIn2DArray(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    int low = 0;
    int high = m - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      int max = 0;
      int row = 0;
      for (int i = 0; i < n; i++) {
        if (matrix[i][mid] > max) {
          row = i;
        }
      }
      int left = mid - 1 >= 0 ? matrix[row][mid - 1] : -1;
      int right = mid + 1 < m ? matrix[row][mid + 1] : -1;
      if (left < matrix[row][mid] && matrix[row][mid] > right) {
        System.out.println(matrix[row][mid]);
        break;
      }
      else if (left > matrix[row][mid])
        high = mid - 1;
      else
        low = mid + 1;
    }
  }

  public void findMedianIn2DArray(int[][] matrix){
    /*min and max is in 1st and last column
    mid
            reqmedian
    countallelementslessequalthanmid using binary search and upper bound -
            checkifitslessthanequaltorequired
    if its less than required,  our element lies on the right
    else it lies on the left
            */
    int n = matrix.length;
    int m = matrix[0].length;
    int low = Integer.MAX_VALUE;
    int high = Integer.MIN_VALUE;
    for(int i = 0;i<n;i++)
    {
      low = Math.min(low,matrix[i][0]);
      high = Math.max(high,matrix[i][m-1]);
    }
    int requiredCount = (n*m)/2;
    while(low<=high){
      int count = 0;
      int mid = (low+high)/2;
      for(int i = 0; i<n;i++){
        count += countelementslessthanequaltomid(matrix[i],mid,m);
      }
      if(count<=requiredCount)
        low=mid+1;
      else
        high = mid-1;
    }
    System.out.println("Meidan is " + low);
  }

  private int countelementslessthanequaltomid(int[] matrix, int mid, int m) {
    int low = 0;
    int high = m - 1;
    while (low <= high) {
      int center = (low + high) / 2;
      if (matrix[center] > mid) {
        high = center - 1;
      } else
        low = center + 1;
    }
    return low;
  }

}

