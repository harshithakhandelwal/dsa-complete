package org.example;

import org.example.Arrays.ArraysGFG;
import org.example.Arrays.ArraysStriver;
import org.example.Companies.BigBasket;
import org.example.Companies.Codeforces;
import org.example.Basics.StringsStriver;
import org.example.BinarySearch.BinarySearchStriver;
import org.example.DynamicProgramming.DPgfg;
import org.example.LinkedList.DesignABrowserHistory;
import org.example.LinkedList.DoubleNode;
import org.example.LinkedList.LinkedListStriver;
import org.example.LinkedList.Node;
import org.example.Mocks.MockInterview;
import org.example.Recursion.RecursionStriver;
import org.example.StacksAndQueues.Queues;
import org.example.StacksAndQueues.Stacks;
import org.example.trees.TreeNode;
import org.example.trees.Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    System.out.println("Let us begin!");
    //arrays();
    //binarySearch();
    //bigBasket();
    //strings();
    //arraysGFG();
    // linkedlist();
    //recursion();
   // stacksAndQueues();
    //trees();
   //dp();
    Mocks();
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
    arraysStriver.findMissingAndRepeatingNumber(new int[]{2, 3, 4, 6, 1, 1}, 6);
    int count = arraysStriver.countInversions(new int[]{5, 4, 3, 2, 1}, 0, 4);
    int reversepairs = arraysStriver.countReversePairs(new int[]{4, 1, 2, 3, 1}, 0, 4);
    System.out.println(count + reversepairs);
  }

  public static void binarySearch() {
    BinarySearchStriver binarySearchStriver = new BinarySearchStriver();
    binarySearchStriver.binarySearch(new int[]{1, 4, 5, 8, 9, 10, 15, 23, 45, 89, 90}, 45);
    binarySearchStriver.lowerBound(new int[]{1, 4, 5, 8, 9, 10, 15, 19, 23, 89, 90}, 45);
    binarySearchStriver.upperBound(new int[]{3, 5, 8, 9, 15, 19}, 9);
    binarySearchStriver.searchIndexPosition(new int[]{3, 5, 8, 9, 15, 19}, 7);
    binarySearchStriver.findFloorAndCeil(new int[]{3, 4, 4, 7, 8, 10}, 8);
    binarySearchStriver.lastOccurrenceOfElement(new int[]{3, 4, 13, 13, 13, 20, 40}, 13);
    binarySearchStriver.occurrencesOfANumber(new int[]{2, 2, 3, 3, 3, 4}, 3);
    binarySearchStriver.searchInRotatedSortedArray(new int[]{4, 5, 6, 7, 0, 1, 2, 3}, 3);
    binarySearchStriver.searchInRotatedSortedArrayWithDuplicates(new int[]{7, 8, 1, 2, 3, 3, 3, 4, 5, 6}, 3);
    binarySearchStriver.minimumInRotatedSortedArray(new int[]{4, 5, 6, 7, 8, 9, 1, 2, 3});
    binarySearchStriver.findNumberOfRotationsOfSortedArray(new int[]{4, 5, 6, 7, 8, 9, 0, 1, 2, 3});
    binarySearchStriver.searchSingleElementInSortedArray(new int[]{1, 1, 2, 2, 3, 3, 5, 5, 6, 6, 7, 8, 8, 9, 9});
    binarySearchStriver.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4});

    binarySearchStriver.findSquareRootOfANumberUsingBinarySearch(28);
    binarySearchStriver.findNthRootOfANumber(4, 256);
    binarySearchStriver.kokoEatingBananas2(new int[]{30, 11, 23, 4, 20}, 5);
    binarySearchStriver.minimumDaysToMakeBouquets(8, new int[]{7, 7, 7, 7, 13, 11, 12, 7}, 2, 3);
    binarySearchStriver.minimumDaysToMakeBouquets(8, new int[]{7, 7, 7, 7, 13, 11, 12, 7}, 2, 6);
    binarySearchStriver.smallestDivisorGivenThreshold(new int[]{8, 4, 2, 3}, 10);
    binarySearchStriver.capacityToShipWithinDDays(new int[]{5, 4, 5, 2, 3, 4, 5, 6}, 5);
    binarySearchStriver.aggressiveCows(new int[]{4, 2, 1, 3, 6}, 5, 2);
    binarySearchStriver.allocationOfBooks(new int[]{12, 34, 67, 90}, 2);
    binarySearchStriver.splitArrayLargestSum(new int[]{1, 2, 3, 4, 5}, 3);
    binarySearchStriver.painterPartitionProblem(new int[]{5, 5, 5, 5}, 2);
    binarySearchStriver.minimumMaximumDistanceBetweenGasStations(new int[]{1, 2, 3, 4, 5}, 4);

    binarySearchStriver.rowWithMax1In2DArray(new int[][]{{1, 1, 1}, {0, 0, 1}, {0, 0, 0}}, 3, 3);
    binarySearchStriver.searchInA2DMatrix(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}, 3, 4, 8);
    binarySearchStriver.findElementIn2DRowWiseColumnWiseSortedMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 19);
    binarySearchStriver.findPeakElementIn2DArray(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    binarySearchStriver.findMedianIn2DArray(new int[][]{{1, 3, 8}, {2, 3, 4}, {1, 2, 5}});

    //Code forces
    Codeforces codeforces = new Codeforces();
    codeforces.canISquare(2, new int[]{1, 2, 3, 4, 5, 6, 7});
    codeforces.buildingAnAquarium(7, 9, new int[]{3, 1, 2, 4, 6, 2, 5});
    codeforces.buildingAnAquarium(4, 1, new int[]{1, 4, 3, 4});
    codeforces.buildingAnAquarium(6, 1984, new int[]{2, 6, 5, 9, 1, 8});

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
    stringsStriver.isIsomorphic("ab", "ab");
    stringsStriver.rotateString("abcde", "cdeah");
    stringsStriver.anagramsOfString("CATDE", "ACTIVE");
    stringsStriver.frequencySort("tree");

  }

  public static void arraysGFG() {
    ArraysGFG arrays = new ArraysGFG();
    arrays.findLargestThreeElements(new int[]{4, 5, 7, 8, 9, 10, 15, 2, 6});
    arrays.rearrangeSuchThatEvenPositionIsGreaterThanOdd(new int[]{1, 46, 48, 1});
    arrays.rearrangeASortedArrayInMaximumMinimum(new int[]{1, 2, 3, 4, 5, 6, 7});
    arrays.segregateArrayEvenAndOddElements(new int[]{7, 2, 9, 4, 6, 1, 3, 8, 5});
    arrays.cyclicSort(new int[]{10, 7, 9, 2, 8, 3, 5, 4, 6, 1});
    arrays.countNumberOfPossibleTriangles(new int[]{10, 21, 22, 100, 101, 200, 300});
    arrays.reArrangeElementWithIndex(new int[]{-1, -1, 6, 1, 9, 3, 2, -1, 4, -1});
    arrays.reArrangeElementWithIndexInAnotherArray(new int[]{23, 12, 20, 10, 23}, new int[]{4, 0, 1, 2, 3});
    arrays.findTheSmallestMissingNumber(new int[]{0, 1, 2, 3}, 10);
    arrays.KthSumOfAContiguousArray(new int[]{20, -5, -1}, 6);
    arrays.smallestSubArrayWithSumGreaterThanKValue(new int[]{1, 4, 45, 6, 0, 19}, 51);
    arrays.smallestSubArrayWithSumGreaterThanKValue(new int[]{1, 11, 100, 1, 0, 200, 3, 2, 1, 250}, 280);
    arrays.updateArrayInRange(new int[]{10, 30, 50, 70, 90}, new int[]{1, 1, 50});
  }

  public static void linkedlist() {
    LinkedListStriver linkedListStriver = new LinkedListStriver();
    Node<Integer> head = linkedListStriver.convertArrayToLinkedList(new int[]{1, 2, 3, 4, 5});
    linkedListStriver.traverseALinkedList(head);
    linkedListStriver.lengthOfALinkedList(head);
    linkedListStriver.searchInALinkedList(head, 67);
    linkedListStriver.deleteHeadNodeOfALinkedList(head);
    linkedListStriver.deleteTailNodeOfALinkedList(head);
    linkedListStriver.deleteKPositionOfALinkedList(head, 4);
    linkedListStriver.deleteKValueOfALinkedList(head, 15);
    linkedListStriver.insertionInaLinkedList(head, 50, 6);
    linkedListStriver.reverseALinkedList(head);
    linkedListStriver.detectACycleInLinkedList();
    linkedListStriver.findStartingNodeOfaLoopInLinkedList();
    Node<Integer> newHead = linkedListStriver.reverseALinkedListUsingRecursion(head);
    linkedListStriver.traverseALinkedList(newHead);
    linkedListStriver.checkIfLinkedListIsPalindromeOrNot(head);
    linkedListStriver.removeNthNodeFromBackOfALinkedList(head, 2);
    linkedListStriver.deleteTheMiddleNodeFromLinkedList(head);
    Node<Integer> newHead1 = linkedListStriver.sortElementsLinkedListUsingMergeSort(head);
    linkedListStriver.traverseALinkedList(newHead1);
    linkedListStriver.oddEvenLinkedList(head);
    linkedListStriver.sortALinkedList(head);

    linkedListStriver.intersectionOfTwoLists();
    linkedListStriver.add1ToLinkedListNumber(head);
    Node<Integer> head1 = linkedListStriver.convertArrayToLinkedList(new int[]{9, 9, 9});
    Node<Integer> head2 = linkedListStriver.convertArrayToLinkedList(new int[]{9, 9});
    linkedListStriver.addTwoNumbersAsLinkedList(head1, head2);

    linkedListStriver.reverseALinkedListInGroupOfK(head, 3);
    linkedListStriver.rotateALinkedListByKPlaces(head, 9);

    //  DoublyLinkedList
    DoubleNode<Integer> doubleHead = linkedListStriver.convertArrayToDoublyLinkedList(new int[]{});
    linkedListStriver.traverseADoublyLinkedList(doubleHead);
    linkedListStriver.deleteInDoublyLinkedList(doubleHead);
    linkedListStriver.deleteTailInDoublyLinkedList(doubleHead);
    linkedListStriver.deleteKthPositionInDoublyLinkedList(doubleHead, 3);
    linkedListStriver.insertInDoublyLinkedList(doubleHead, 3, 3);
    linkedListStriver.reverseADoublyLinkedList(doubleHead);
    linkedListStriver.findMiddleOfADoublyLinkedList(doubleHead);
    linkedListStriver.deleteAllOccurrencesOfKeyInDLL(doubleHead, 2);
    linkedListStriver.findPairsWithGivenSumInDLL(doubleHead, 5);
    linkedListStriver.removeDuplicatesFromSortedDLL(doubleHead);
    linkedListStriver.flattenABottomLinkedList();
    linkedListStriver.cloneLLWithNextAndRandomListBrute();
    linkedListStriver.cloneWithNextAndRandomLLOptimal();

    DesignABrowserHistory browserHistory = new DesignABrowserHistory("TUF");
    browserHistory.visit("google.com");
    browserHistory.visit("instagram.com");
    browserHistory.visit("facebook.com");
    browserHistory.back(1);
    browserHistory.back(1);
    browserHistory.forward(1);
    browserHistory.visit("TUF");
    browserHistory.forward(2);
    browserHistory.back(2);
    browserHistory.back(7);
  }

  public static void recursion() {
    RecursionStriver recursionStriver = new RecursionStriver();
    recursionStriver.stringToIntegerAtoi("  -12345hb");
    recursionStriver.generateAllBinaryStringsWithoutConsecutive1s(4);
    recursionStriver.powerOfANumber(2, 4);
    recursionStriver.countGoodNumbers(6798);
    recursionStriver.sortStackUsingRecursion();
    recursionStriver.reverseStackUsingRecursion();
    recursionStriver.binarySearchUsingRecursion(new int[]{1, 2, 3, 4, 6, 7, 8, 9}, 6);
    recursionStriver.reverseStringUsingRecursion("abcde");
    recursionStriver.checkIfStringIsAPalindrome("malayalam");
    recursionStriver.generateParentheses(3);
    recursionStriver.printAllSubsequencesPowerSet("abc");
    recursionStriver.countAllSubsequencesWithSumK(new int[]{5, 2, 3, 10, 6, 8}, 10);
    recursionStriver.combinationSum(new int[]{2, 3, 6, 7}, 7);
    recursionStriver.combinationSumTwo(new int[]{1, 1, 1, 2, 2}, 4);
    recursionStriver.subsetSum(new int[]{3, 2, 1});
    recursionStriver.subsetTwo(new int[]{1, 2, 2});
    recursionStriver.combinationSumThree(4, 10);
    recursionStriver.phoneNumberCombinations("345");
    recursionStriver.generatePalindromePartitions("aab");
    recursionStriver.wordSearchOnABoard("ABCCEG");
    recursionStriver.solveNQueens(4);
    recursionStriver.ratInAMaze(4, new int[][]{{1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}});
  }

  public static void stacksAndQueues() {

    Stacks stacksStriver = new Stacks();
    Queues queueStriver = new Queues();
    stacksStriver.implementStackUsingArrays(new int[]{1, 2, 3, 4, 5});
    stacksStriver.implementStackUsingQueue();
    queueStriver.implementationOfQueueUsingArrays();
    queueStriver.implementQueueUsingStacks();
    stacksStriver.implementStackUsingLinkedList();
    queueStriver.implementQueuesUsingLinkedList();
    stacksStriver.checkParenthesis("[()]");
    stacksStriver.implementMinStack();
    stacksStriver.infixToPostfix("k+l-m*n+(o^p)*w/u/v*t+q");
    stacksStriver.prefixToInfix("*+AB-CD");
    stacksStriver.prefixTPostfix("*+AB-CD");
    stacksStriver.postfixToPrefix("AB+CD-*");
    stacksStriver.postfixToInfix("AB+CD-*");
    stacksStriver.nextGreaterElement(new int[]{3, 4, 5, 1, 2, 7, 9, 11});
    stacksStriver.nextSmallestElement(new int[]{1, 6, 8, 2, 3, 7, 9, 2});
    stacksStriver.asteroidCollision(new int[]{10, 2, -5});
  }

  public static void trees(){
    // Creating a sample binary tree
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);

    Trees trees = new Trees();
   // trees.preOrderTraversal(root,new ArrayList<>());
   // trees.postOrderTraversal(root,new ArrayList<>());
   // trees.inOrderTraversal(root,new ArrayList<>());
   /* trees.levelOrderTraversal(root);
    trees.iterativePreorderTraversal(root,new ArrayList<>());
    trees.iterativeInorderTraversal(root);
    trees.postOrderTraversalUsing2Stack(root);*/
    trees.heightOfABinaryTree(root);
    trees.checkIfTwoTreesAreIdenticalOrNot(root,root);

  }

  public static void dp(){
    DPgfg dPgfg = new DPgfg();
    dPgfg.longestCommonSubsequence("AGTAB","GXQTAB");
    dPgfg.editDistance("geek","gesek");

  }

  public static void Mocks(){
    MockInterview mockInterview = new MockInterview();
   /* mockInterview.reverseString();
    mockInterview.sumOfArrayWithoutLoop();
    mockInterview.determineHighestPeekForEach();
    mockInterview.rottingOranges();
    mockInterview.processSentences();
    mockInterview.findCommonCharacters();
    mockInterview.reverseAnInteger();
    mockInterview.binaryPrefixDivisibleByK();
    mockInterview.firstUniqueCharacterInAString();
    mockInterview.diamondMatrixSum();
    mockInterview.rotateMatrixBy90();
    mockInterview.boundarySumOfMatrix(); */
    mockInterview.spiralBoundarySumOfMatrix();
  }



}