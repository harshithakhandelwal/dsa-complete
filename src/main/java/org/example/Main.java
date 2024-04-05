package org.example;

import org.example.Arrays.Striver.ArraysStriver;
import org.example.Arrays.Striver.BinarySearchStriver;
import org.example.CompanyInterviews.BigBasket;
import org.example.DSAMisc.Striver.StringsStriver;

public class Main {
  public static void main(String[] args) {
    System.out.println("Let us begin!");
    //arrays();
    binarySearch();
    //bigBasket();
    //strings();

  }

  public static void arrays() {
    ArraysStriver arraysStriver = new ArraysStriver();
    //Easy
    arraysStriver.largestElementInAnArray(new int[]{1, 2, 5, 7, 9}, 5);
    arraysStriver.secondLargestElementInAnArray(new int[]{1, 1, 1, 1, 1}, 5);
    arraysStriver.checkIfArrayIsSorted(new int[]{1, 3, 6, 8, 9}, 5);
    arraysStriver.removeDuplicatesFromSortedArray(new int[]{1, 2, 2, 4, 4, 5, 6, 6}, 8);
    arraysStriver.leftRotateAnArrayBy1Place(new int[]{1, 2, 3, 4, 5}, 5);
    arraysStriver.leftRotateAnArrayByDPlaces(new int[]{1, 2, 3, 4, 5}, 5, 10);
    arraysStriver.moveZerosToEnd(new int[]{1, 2, 0, 3, 0, 4, 0}, 7);
    arraysStriver.linearSearch(new int[]{1, 2, 4, 8, 9, 3, 6}, 7, 8);
    arraysStriver.unionOfTwoArrays(new int[]{1, 2, 3, 5}, new int[]{5, 4, 2, 8}, 4, 4);
    arraysStriver.intersectionOfTwoArrays(new int[]{1, 2, 3, 5}, new int[]{5, 4, 2, 8}, 4, 4);
    arraysStriver.findMissingElement(new int[]{1, 3, 4, 5, 6, 7}, 6);
    arraysStriver.findNumberThatAppearsOnce(new int[]{1, 1, 2, 2, 3, 4, 4, 5, 5}, 9);
    arraysStriver.findMaximumConsecutiveOnes(new int[]{1, 2, 4, 5, 1, 1, 2, 4, 1, 1}, 10);
    arraysStriver.longestSubArrayWithSumKPositives(new int[]{2, 3, 5, 1, 9}, 10);
    arraysStriver.longestSubArrayWithSumKNegatives(new int[]{-3, -5, -2, -1, -7, -2, -2, 0, -1, -2, 0, 0, 0, 0, 1, 3, 5}, 1);

    //Medium
    arraysStriver.twoSum(new int[]{2, 6, 5, 8, 11}, 14);
    arraysStriver.sort0and1and2(new int[]{2, 0, 2, 1, 1, 0}, 6);
    arraysStriver.majorityElementMoreThanNby2(new int[]{4, 4, 2, 4, 3, 4, 4, 3, 2, 4}, 10);
    arraysStriver.maximumSubArraySumKadene(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 9);
    arraysStriver.maximumSubArrayKadene(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 9);
    arraysStriver.bestTimeToBuyAndSellStock(new int[]{7, 6, 3, 1, 14}, 5);
    arraysStriver.rotateMatrixBy90(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}, 4, 4);
    arraysStriver.rearrangeBySign(new int[]{1, 2, -4, -5}, 4);
    arraysStriver.rearrangeBySignUnequal(new int[]{1, 2, -5, -3, -4, -7}, 6);
    arraysStriver.nextPermutation(new int[]{2, 1, 5, 4, 3, 0, 0}, 7);
    arraysStriver.leadersInAnArray(new int[]{10, 22, 12, 3, 0, 6}, 6);
    arraysStriver.lengthOfLongestConsecutiveElements(new int[]{100, 200, 1, 3, 2, 4}, 6);
    arraysStriver.printMatrixInSpiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
    arraysStriver.countSubArraysWithSumK(new int[]{3, 1, 2, 4}, 6);

    //Hard
    arraysStriver.threeSumProblem(new int[]{-1, 0, 1, 2, -1, -4}, 6);
    arraysStriver.fourSumProblem(new int[]{0, 0, 1, 3, 2, -1}, 6, 3);
    arraysStriver.pascalsTriangle(6);
    arraysStriver.majorityElementN3(new int[]{11, 33, 33, 11, 33, 11}, 6);
    arraysStriver.longestSubArrayWithSumZero(new int[]{1, 2, -2, 4, -4});
    arraysStriver.maximumProductSubArray(new int[]{-3, -1, -1, -4, -5}, 5);
    arraysStriver.countSubarraysWithXORK(new int[]{4, 2, 2, 6, 4}, 5, 6);
    arraysStriver.mergeOverlappingIntervals(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    arraysStriver.mergeSortedArraysUsingThirdArray(new int[]{1, 2, 3, 5}, new int[]{0, 2, 3, 5, 7, 8, 9});
    arraysStriver.mergeSortedArraysWithoutUsingThirdArray(new int[]{1, 2, 3, 5}, new int[]{0, 2, 3, 5, 7, 8, 9});
    arraysStriver.findMissingAndRepeatingNumber(new int[]{2,3,4,6,1,1},6);
    int count = arraysStriver.countInversions(new int[]{5,4,3,2,1},0,4);
    int reversepairs = arraysStriver.countReversePairs(new int[]{4,1,2,3,1}, 0,4);
    System.out.println(count+reversepairs);
  }

  public static void binarySearch(){
    BinarySearchStriver binarySearchStriver = new BinarySearchStriver();
    binarySearchStriver.binarySearch(new int[]{1,4,5,8,9,10,15,23,45,89,90},45);
    binarySearchStriver.lowerBound(new int[]{1,4,5,8,9,10,15,19,23,89,90},45);
    binarySearchStriver.upperBound(new int[]{3, 5, 8, 9, 15, 19},9);
    binarySearchStriver.searchIndexPosition(new int[]{3, 5, 8, 9, 15, 19},7);
    binarySearchStriver.findFloorAndCeil(new int[]{3,4,4,7,8,10},8);
    binarySearchStriver.lastOccurrenceOfElement(new int[]{3,4,13,13,13,20,40},13);
    binarySearchStriver.occurrencesOfANumber(new int[]{2, 2 , 3 , 3 , 3 , 4},3);
    binarySearchStriver.searchInRotatedSortedArray(new int[]{4,5,6,7,0,1,2,3},3);
    binarySearchStriver.searchInRotatedSortedArrayWithDuplicates(new int[]{7, 8, 1, 2, 3, 3, 3, 4, 5, 6},3);
    binarySearchStriver.minimumInRotatedSortedArray(new int[]{4,5,6,7,8,9,1,2,3});
    binarySearchStriver.findNumberOfRotationsOfSortedArray(new int[]{4,5,6,7,8,9,0,1,2,3});
  }

  public static void bigBasket() {
    BigBasket bigBasket = new BigBasket();
    bigBasket.findMinAndMaxOfAnArray(new int[]{1, 1, 1, 1, 1}, 5);
    bigBasket.bestTimeToBuyAndSellStock(new int[]{7, 6, 3, 1, 14}, 5);
    bigBasket.moveAllZerosToRight(new int[]{1, 2, 0, 0, 5, 7, 0, 0}, 8);
    bigBasket.removeAnElement(new int[]{1, 2, 3, 3, 5, 7, 3, 0}, 8, 3);
    bigBasket.makeAllElementsOfArrayEqual(new int[]{1, 5, 7, 10}, 4);
    bigBasket.rotateMatrixBy90(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}, 4, 4);
    bigBasket.longestSubStringWithUniqueCharacters("abcabcbb");
  }

  public static void strings() {
    StringsStriver stringsStriver = new StringsStriver();
    //Easy
    stringsStriver.removeOuterMostParenthesis("(()())(())((())())");
    stringsStriver.reverseWordsInString("the sky is blue");
    stringsStriver.largestOddNumberInString("35427");
    stringsStriver.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
  }
}