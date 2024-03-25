package org.example;

import org.example.Arrays.ArraysStriver;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Let us begin!");
//        System.out.println("Choose your concept:");
//        Scanner scanner = new Scanner(System.in);
//        int choice = scanner.nextInt();
//        switch (choice) {
//            case 1:
//                System.out.println("Arrays:");
//                arrays();
//                break;
//            default: arrays();
//
//        }
        arrays();
    }

    public  static void arrays(){
        ArraysStriver arraysStriver = new ArraysStriver();
        arraysStriver.largestElementInAnArray(new int[]{1, 2, 5, 7, 9},5);
        arraysStriver.secondLargestElementInAnArray(new int[]{1,1,1,1,1},5);
        arraysStriver.checkIfArrayIsSorted(new int[]{1,3,6,8,9},5);
        arraysStriver.removeDuplicatesFromSortedArray(new int[]{1,2,2,4,4,5,6,6},8);
        arraysStriver.leftRotateAnArrayBy1Place(new int[]{1,2,3,4,5},5);
        arraysStriver.leftRotateAnArrayByDPlaces(new int[]{1,2,3,4,5},5,10);
        arraysStriver.moveZerosToEnd(new int[]{1,2,0,3,0,4,0}, 7);
        arraysStriver.linearSearch(new int[]{1,2,4,8,9,3,6}, 7, 8);
        arraysStriver.unionOfTwoArrays(new int[]{1,2,3,5},new int[]{5,4,2,8},4,4);
        arraysStriver.intersectionOfTwoArrays(new int[]{1,2,3,5},new int[]{5,4,2,8},4,4);
        arraysStriver.findMissingElement(new int[]{1,3,4,5,6,7}, 6);
        arraysStriver.findNumberThatAppearsOnce(new int[]{1,1,2,2,3,4,4,5,5}, 9);
        arraysStriver.findMaximumConsecutiveOnes(new int[]{1,2,4,5,1,1,1,1,5,1,1},11);
        arraysStriver.longestSubarrayWithSumK(new int[]{},10);
    }
}