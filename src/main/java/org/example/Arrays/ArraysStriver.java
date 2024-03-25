package org.example.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ArraysStriver {
  public void largestElementInAnArray(int[] arr, int n){
    System.out.println("Largest element in an array!");
    System.out.println(Arrays.toString(arr));
    int largest = arr[0];
    if(n>1) {
      for (int i = 1; i < n; i++) {
        if (arr[i] > largest)
          largest = arr[i];
      }
    }
    System.out.println("Largest="+largest);
  }

  public void secondLargestElementInAnArray(int[] arr, int n){
    System.out.println("Second Largest element in an array!");
    System.out.println(Arrays.toString(arr));
    int large = Integer.MIN_VALUE;
    int slarge = Integer.MIN_VALUE;
    for(int i = 0; i<n;i++) {
      if (arr[i] > large) {
        slarge = large;
        large = arr[i];
      } else if (arr[i]>slarge && arr[i]!=large)
        slarge = arr[i];
    }
    if(slarge==Integer.MIN_VALUE)
      slarge = -1;
    System.out.println("Second largest="+slarge);
  }

  public void checkIfArrayIsSorted(int[] arr, int n){
    System.out.println("Check if an array is sorted!");
    System.out.println(Arrays.toString(arr));
    boolean isSorted = true;
    for(int i = 0; i<n-1;i++){
      if(arr[i]>arr[i+1])
        isSorted = false;
    }
    System.out.println("Array is sorted?="+isSorted);
  }

  public void removeDuplicatesFromSortedArray(int[] arr, int n){
    System.out.println("Remove duplicates from an array!");
    System.out.println(Arrays.toString(arr));
    int index = 0;
    for(int i = 1; i<n; i++){
      if(arr[index]!=arr[i]) {
        index++;
        arr[index] = arr[i];
      }
    }
    System.out.println("New Array is="+ Arrays.toString(arr));
    System.out.println("Number of unique elements="+ (index+1));
  }

  public void leftRotateAnArrayBy1Place(int[] arr, int n){
    System.out.println("Rotate an array by 1 place!");
    int temp = arr[0];
    for(int i = 0; i<n-1;i++){
      arr[i]= arr[i+1];
    }
    arr[n-1]= temp;
    System.out.println(Arrays.toString(arr));
  }
  public void leftRotateAnArrayByDPlaces(int[] arr, int n,int d){
    System.out.println("Rotate an array by D places!");
    if(n == 0)
      return;
    d = d % n;
    if(d>n)
      return;
    int[] temp = new int[d];
    for (int i = 0; i < d; i++)
      temp[i] = arr[i];
    for(int i = 0; i<n-d;i++)
      arr[i] = arr[i+d];
    for(int i = n-d; i<n; i++)
      arr[i] = temp[i-n+d];
    System.out.println(Arrays.toString(arr));
  }

  public void moveZerosToEnd(int[] arr, int n){
    System.out.println("Moved Array with Zeros at the end!");
    int index = 0;
    for(int i = 0; i<n;i++){
      if(arr[i]!=0) {
        arr[index] = arr[i];
        index++;
      }
    }
    for(int i = index+1;i<n;i++)
      arr[i] = 0;
    System.out.println(Arrays.toString(arr));
  }

  public void linearSearch(int[] arr, int n, int k) {
    for(int i = 0; i< n; i++){
      if(arr[i]==k)
        System.out.println("Element found at index " +  i);
    }
  }

  public void unionOfTwoArrays(int[] arr1, int[] arr2, int m, int n) {
    System.out.println("Union of two arrays!");
    HashSet<Integer> arrayList = new HashSet<>();
    for(int i = 0;i<m;i++)
      arrayList.add(arr1[i]);
    for(int i = 0; i<n;i++)
      arrayList.add(arr2[i]);
    System.out.println(arrayList);
  }

  public void intersectionOfTwoArrays(int[] arr1, int[] arr2, int m, int n) {
    System.out.println("Intersection of two arrays!");
    ArrayList<Integer> arrayList = new ArrayList<>();
    HashSet<Integer> h = new HashSet<>();
    for(int i=0; i<m;i++)
      h.add(arr1[i]);
    for(int i=0;i<n;i++) {
      if (h.contains(arr2[i]))
        arrayList.add(arr2[i]);
    }
    System.out.println(arrayList);
  }


  public void findMissingElement(int[] arr, int n) {
    System.out.println("Find missing element!");
    if(n<1)
      return;
    int expectedSum = 0;
    int actualSum = ((n+1)*(n+2))/2;
    for(int i = 0; i<n;i++){
      expectedSum += arr[i];
    }
    System.out.println("Missing number is ="+ (actualSum-expectedSum));
  }

  public void findNumberThatAppearsOnce(int[] arr, int n) {
    int num = 0;
    for(int i =0;i<n;i++){
      num ^= arr[i];
    }
    System.out.println("Number that appeared once - "+num);
  }




  public void findMaximumConsecutiveOnes(int[] arr, int n) {

  }


  public void longestSubarrayWithSumK(int[] arr, int k) {
  }
}
