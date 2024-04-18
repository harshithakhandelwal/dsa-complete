# **Binary search**

## **easy**

1. binarySearch( {1, 4, 5, 8, 9, 10, 15, 23, 45, 89, 90}, 45); intuition - on a sorted array make comparisons in such a
   way that, the search eliminates spaces in which the element is guaranteed to not be found. if any element is less
   than current then eliminate right half.
2. lowerBound( {1, 4, 5, 8, 9, 10, 15, 19, 23, 89, 90}, 45); - intuition - to find an element which is just either
   greater than or equal to of the search element. if such an element is found then we search further lesser if another
   smaller place can be found.
3. upperBound( {3, 5, 8, 9, 15, 19}, 9); intuition - intuition - to find an element which is just either greater than
   the search element. if such an element is found then we search further lesser if another smaller greater element can
   be found.****
4. searchIndexPosition( {3, 5, 8, 9, 15, 19}, 7); intuition - insert at greater or equal to position just like lower
   bound.
5. findFloorAndCeil( {3, 4, 4, 7, 8, 10}, 8); - intuition find the lower bound for ceil and upperbound opposite(<=)  for
   floor.
6. lastOccurrenceOfElement( {3, 4, 13, 13, 13, 20, 40}, 13); intuition - if an occurrence is found, search in the right
   to find another occurrence.
7. occurrencesOfANumber( {2, 2, 3, 3, 3, 4}, 3); intuition - find the first by searching further left and last occurance
   by searching further right and subtract the answer to get no of occurances.
8. searchInRotatedSortedArray( {4, 5, 6, 7, 0, 1, 2, 3}, 3); intuition - one half will always be sorted, we need to
   identify that half and check in it by using low, high mid comparisons then comapre with target in it or eliminate
   that space.
9. searchInRotatedSortedArrayWithDuplicates( {7, 8, 1, 2, 3, 3, 3, 4, 5, 6}, 3); intuition - excluding a few exception
   cases like low=mid=high (handle by moving low and high), approach is similar to above one.
10. minimumInRotatedSortedArray( {4, 5, 6, 7, 8, 9, 1, 2, 3}); intuition - the element that is the left most of the
    sorted array will be our minimum, we need to find the low of leftmost array.
11. findNumberOfRotationsOfSortedArray( {4, 5, 6, 7, 8, 9, 0, 1, 2, 3}); intuition - no of rotations can be found by
    using the minimum element and subtracting it from total number of elements.
12. searchSingleElementInSortedArray( {1, 1, 2, 2, 3, 3, 5, 5, 6, 6, 7, 8, 8, 9, 9}); intuition - better approach is to
    XOR but we can optimize it by using binay search, we check if the mid element is not equal to its previous and next
    elements. THE edge cases would be to check if element is at low or high end extremes.
13. findPeakElement( {1, 2, 1, 3, 5, 6, 4}); intuition - the peak element would be such that it will be greater than
    element before and after it, and if an element is in increasing iwe look further right and if tis decreasing we look
    left. and we handle edge cases seperately.

## **On Answers**

1. findSquareRootOfANumberUsingBinarySearch(28); intuition - square root is found by checking square of each number and
   if its less or equal to the number.
2. findNthRootOfANumber(4,256); intuition - power it n times to check if its Nth root of the number or reduce search
   space by eliminating the halves.
3. kokoEatingBananas2({30,11,23,4,20},5); intuition - find min and max, then see if piles/numer fits the hours
   constraint, if it does, find further left for optimal value, else find it in right.
4. minimumDaysToMakeBouquets(8, {7,7,7,7,13,11,12,7},2,3); intuition - find min days and max days, then check if we can
   make bouque on each day in the min max arrange, if yes, increment days and once size of bouque reached, increment
   bouque, then comapre if bouque is greater or equal to required, if yes.. then find further small day towards left
   else find towards right.
6. smallestDivisorGivenThreshold( {8,4,2,3},10); intuition -
7. capacityToShipWithinDDays({5,4,5,2,3,4,5,6},5); intuition -
8. aggressiveCows({4,2,1,3,6}, 5, 2); intuition -
9. allocationOfBooks({12,34,67,90},2); intuition -
10. splitArrayLargestSum({1,2,3,4,5},3); intuition -
11. painterPartitionProblem({5,5,5,5},2); intuition -
12. ff
13. ff
14. ff

## **2D Array**

1. rowWithMax1In2DArray( {{1,1,1},{0,0,1},{0,0,0}}, 3, 3); intuition - optimize the counting without visiting each
   element - by using first occurance and subtraction from row length.
2. searchInA2DMatrix( {{1,2,3,4},{5,6,7,8},{9,10,11,12}}, 3, 4, 8); - intuition - apply binary search by considering it
   as a 1d matrix by converting single coordinate into row n column using element/m and element%m
3. findElementIn2DRowWiseColumnWiseSortedMatrix(
   {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},19); intuition - consider row end or
   column end corner, if an element equals it, great, otherwise, if element is lesser than target then increment the row
   or decrement the column otherwise.
4. findPeakElementIn2DArray( {{1,2,3},{4,5,6},{7,8,9}}); intuition - for every mid element find the maximum element then
   compare left to right to see if tis peak, if its end then use -1 for comparison.
5. findMedianIn2DArray( {{1, 3, 8}, {2, 3, 4}, {1, 2, 5}}); intuition - for every median there will some elements <= to
   half of the array, we need to find such an element using binary search, if element is found, we move further right to
   see if there is another element, and we count all elements less than by using biinary search and returning the low
   index at end.