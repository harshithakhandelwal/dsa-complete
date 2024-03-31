# **Questions**

### **Easy**

1. **largestElementInAnArray**( int[]{1, 2, 5, 7, 9},5);  
   Brute - Iterate and compare if an element is larger than all elements in the array. O(n2)  
   Better - Sort the array and pick the last element  O(nlogn)  
   Optimal - Take first element as largest and update largest only if current element is larger than it. O(N)  
    </br>
2. **secondLargestElementInAnArray**( int[]{5,1,3,2,1},5);  
    Brute - Sort the array and then pick n-2 element from array.  
    Optimal - Take two pointers largest and secondLargest,   
    if an element is larger than current largest update largest to it and the current largest to secondLargest,   
    if an element is larger than current second largest but not largest, then update second largest. O(N)   
   </br>  
3. **checkIfArrayIsSorted**( int[]{1,3,6,8,9},5);  
    Brute - Sort the array and compare. O(nlogn)  
    Optimal - if its sorted, an element i-1 will be less than current element i. and if it's not then directly exit the loop. O(N)  
   </br>
4. **removeDuplicatesFromSortedArray**( int[]{1,2,2,4,4,5,6,6},8);  
    Brute - store count of each element and make another array with only 1 count. o(nlogn)  
    Optimal - since its sorted, if an element is found in index and i + 1 then I won't consider the element.  
    and maintain a current index that increments only for unique elements and rewrite it in array. O(N)  
   </br>
5. **leftRotateAnArrayBy1Place**( int[]{1,2,3,4,5},5);  
    Optimal - store the left most element in a variable and move the rest and then add back the left most element at the last. O(N)  
   </br>
6. **leftRotateAnArrayByDPlaces**( int[]{1,2,3,4,5},5,10);  
    Optimal - find the k as mod of N, store the left most elements in an array and move the rest and then add back the left most elements at the last. o(N)  
   </br>
7. **moveZerosToEnd**( int[]{1,2,0,3,0,4,0}, 7);  
    Optimal - similar to removing duplicates and appending zeros at the end for remaining spaces. O(N)  
   </br>
8. **linearSearch**( int[]{1,2,4,8,9,3,6}, 7, 8);  
    Optimal - traverse entire array to find the element. O(N)  
   </br>
9. **unionOfTwoArrays**( int[]{1,2,3,5}, int[]{5,4,2,8},4,4);  
    Brute - compare each element in both arrays and add into the  array.
    Optimal - add all elements from both to a hashset. O (M+N)  
   </br>
10. **intersectionOfTwoArrays**( int[]{1,2,3,5}, int[]{5,4,2,8},4,4);  
    Brute - compare each element in both arrays and add into the  array if it exists in array 2.
    Optimal - add all elements of array 1 in hashset then check if it exists in array 2. if yes then add to final result. O(M+N)  
    </br>
11. **findMissingElement**( int[]{1,3,4,5,6,7}, 6);  
    Optimal - calculate expected sum and actual sum, subtract it to get missing element. O(N)  
    </br>
12. **findNumberThatAppearsOnce**( int[]{1,1,2,2,3,4,4,5,5}, 9);  
    Brute - count occurrences and store in a map. output the ones appearing once.
    Optimal - XOR all elements and final answer is the number that appears once since in xor (element^element) will give zero and (element^0) will give element. O(N)  
    </br>
13. **findMaximumConsecutiveOnes**( int[]{1,2,4,5,1,1,2,4,1,1},10);  
    Brute - generate all subarrays that have 1 and take maximum of it.
    Optimal - keep a current max when encountered with 1, increment it if another one is found subsequently, 
    otherwise set counter back to 0 and take maximum of elements. O(N)  
    </br>
14. **longestSubArrayWithSumKPositives**( int[]{2,3,5,1,9},10);   
    Brute - generate all subarrays and take the sum and compare with k.  
    Optimal - take prefix sum and compare if its less than k then increment, if its  equal to k , take the max and reset counters,   
    if it's greater than k then reset counters. O(N)  
    </br>
15. **longestSubArrayWithSumKNegatives**( int[]{-3,-5,-2,-1,-7,-2,-2,0,-1,-2,0,0,0,0,1,3,5},1);  
    Brute -
    Optimal - take prefix sum and add current element to it, if k - prefix(remaining) sum exists in hashmap, then take the count and increment it else,  
    if not add prefix sum to the hashmap. O(N)  
    </br>

### **Medium**


1. **twoSum**( int[]{2,6,5,8,11},14);  
    Brute - take sum of each pair and compare.   
    Optimal - for each element try to find if compliment of it exists in the hashmap and store its index. O(N)  
   <br>
2. **sort0and1and2**( int[]{2,0,2,1,1,0},6); (dutch flag)  
    Brute - sort the elements.  
    Better - count each element and its occurrences and then form the array.  
    Optimal - maintain three counters - low for 0, high for n-1 and mid for 0 and start sorting. if mid is larger than 1 then swap to high and decrement high,  
    if mid is less than 1 swap to low and increment low. if mid is equal to 1 then just increment mid. O(N)  
   <br>
3. **majorityElementMoreThanNby2**( int[]{4,4,2,4,3,4,4,3,2,4},10); (Moore's voting algorithm)    
    Brute - count each element and its count in a hash map and out the one greater than n/3   
    Optimal - take first element as majority and counter that increases if same number found or decreases if another one,   
    if count becomes 0, take current element as majority. o(N)  
   </br>
4. **maximumSubArraySumKadene**( int[]{-2,1,-3,4,-1,2,1,-5,4},9);  
   Optimal - maintain current sum and max sum so far, then whichever is greater thats the max sum. O(N)  
   </br>
5. **maximumSubArrayKadene**( int[]{-2,1,-3,4,-1,2,1,-5,4},9);  
   Optimal - maintain current sum and max sum so far, and indices of start to end, then whichever is greater that's the max sum and respective indices. O(N)  
   </br>
6. **bestTimeToBuyAndSellStock**( int[]{7,6,3,1,14},5);  
    Optimal - find first least element then break, then find the largest element to the right. O(N)      
   </br>
7. **rotateMatrixBy90**( int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}},4,4);  
    Optimal - transpose matrix by swapping elements others than diagonal and reverse rows. O(N*M)    
   </br>
8. **rearrangeBySign**( int[]{1,2,-4,-5},4);  
    Optimal - maintain one positive index and one negative index, if you encounter positive element increment positive index and vice versa.  
    write the positive element at 2*i and negative at 2*i+1 positions. O(N)  
   </br>
9. **rearrangeBySignUnequal**( int[]{1,2,-5,-3,-4,-7},6);  
    Optimal - keep two arrays one with positive elements and other with negative elements.  
    loop till smaller array and copy it to final answer and then add remaining elements from longer array. O(N)  
   </br>
10. **nextPermutation**( int[]{2,1,5,4,3,0,0},7);  
    Optimal - find the breaking point where the element at i is less than element at i+1 from end.  
     swap it with the next largest number to it on the right, then reverse the elements from next position. 0(N)+ O(M)   
    </br>
11. **leadersInAnArray**( int[]{10,22,12,3,0,6},6);  
    Optimal - output all elements that are larger to its rightside elements.  
    take first rightmost element as leader then compare it with others on left if you find another element larger than this then that's a leader too. O(N)  
    </br>
12. **lengthOfLongestConsecutiveElements**( int[]{100,200,1,3,2,4},6);  
    Brute - for each element check for the consecutive elements if its in incrementing or decrementing order then output the maximum no of elements.  
    Optimal - Add all the elements to hashset then check if the element - 1 exists, this ensures, this is the beginning of the subarray we need.  
    then incrementally find the subsequent elements in the hashset, if found-then check its max length and update it. O(N) + O(N)  
    </br>
13. **printMatrixInSpiralOrder**( int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});  
    Optimal - Print spiral by running four loops, one from left to right, then from top to bottom, then from right to left, lastly from bottom to top.
    in each move the pointers top, right, bottom, left.  O(N)  
    </br>
14. **countSubArraysWithSumK**( int[]{3,1,2,4},6);  
    Optimal - Similar to how you do a maximum of arrays, count the occurrences and add it in hashmap when sum equals k. O(N)  


## **Hard**





