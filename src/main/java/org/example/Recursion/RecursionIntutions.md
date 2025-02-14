# Recursion main problems 

## Basics
1. **stringToIntegerAtoi("-12345hb");**—perform basic operations to increment whitespaces, boolesn to check sign, then calculate te digit by multiplying by 10 and adding the digit.
2. **generateAllBinaryStringsWithoutConsecutive1s(4);** - for a given K, if its 0 - add empty string, if its 1 add 0 and 1. for the k>1 call recursively k-1 and append the 0 and 1 accordingly ensuring prev char is not 1.
3. **powerOfANumber(2,4);**—for negative divide ans by 1. to calculate, if odd N power, then multiply res * x and decrement N. If even power N, multiply x*x* and divide n by 2.
4. **countGoodNumbers(6798);**—for a given N find the good numbers and its count, for even index—its 5(0,2,4,6,8),for odd index its prime 4(2,3,5,7). if even then raise to the power of 5. if odd raise to power of 4.   
5. **sortStackUsingRecursion();** - pop the top element if present, sort the stack and insert element. in inserting, if stack is empty push the top if not pop the element then insert the last popped and top.
6. **reverseStackUsingRecursion();**—reverse stack by calling it recursively and inserting it back.
7. **binarySearchUsingRecursion**(new int[]{1,2,3,4,6,7,8,9},6);—recursively break the search space in binary search fashion.
8. **reverseStringUsingRecursion**("abcde");—in brute force, reach till end of string and then start appending, in optimal recursively reverse 0 and n-1 positions.
9. **checkIfStringIsAPalindrome("malayalam");**—based on reversed string check if its palindrome.
10. **generateParentheses(3);** - for a given number n , if total string length is n*2, we stop, otherwise if left bracket is less than n, we recursively generate bracket, and append "(" to it, else if right is less than left, we recursively generate ")" and append to string and add it to results.
11. **printAllSubsequencesPowerSet("abc");** - if count equals length of S, we stop, else, we recursively generate a power set, by appending element at each index, and then without appending any element at each index.
12. **printAllSubsequencesPowerSet({1,2,3});** - 