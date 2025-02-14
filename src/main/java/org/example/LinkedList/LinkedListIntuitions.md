## LinkedList Problems

1. **convertArrayToLinkedList(new int[]{1, 2, 3, 4, 5})**- read each element of array, the first node is head, for next use a pointer to point to the next new node.
2. **traverseALinkedList(head)**—until a temp pointer is not null, traverse and print the node.
3. **lengthOfALinkedList(head)**—increment count while traversing. 
4. **searchInALinkedList(head, 67)**- linearly until an element is found.
5. **deleteHeadNodeOfALinkedList(head)** - make head.next as head. java will perform gc.
6. **deleteTailNodeOfALinkedList(head)**—traverse till the last but one node and point the next to null.
7. **deleteKPositionOfALinkedList(head, 4)**- traverse till the node and keep a previous pointer and a count of current element and move ahead.
8. **deleteKValueOfALinkedList(head, 15)**—traverse till value of a node matches given K and delete it by pointing the previous to its next and incrementing it.
9. **insertionInaLinkedList(head, 50, 6**)- if inserted at head, make the new node point to head and heads next as current head, if inserted at any other position, reach the count, and keep track of visited element, attach the new node as next of it, and the next of new node as original next element.
10. **reverseALinkedList(head)**—to a reverse singly linked list, we need to keep a track of previous visited element and update current next to previous.
11. **detectACycleInLinkedList()** - use Tortoise and hare algorithm, if slow == fast then there is a loop.
12. **findStartingNodeOfaLoopInLinkedList()** - detect the cycle when slow == fast then make slow point to head and move one step each both slow and fast until it's not equal.
13. **reverseALinkedListUsingRecursion(head)** - recursively reach the last element and update its next to current head as backtracking it. finally, update actual head to null and return new head.
14. **checkIfLinkedListIsPalindromeOrNot(head)** - use the TH algorithm to reach the mid and then reverse the second half. start comparing from start this half reverses if it matches.
15. **removeNthNodeFromBackOfALinkedList(head, 2)-** move a fast pointer till the nth node, then move both pointers until reaching the end, then update the slow pointer to the next element which deletes the nth end from end. as slow points to n-1 node.
16. **deleteTheMiddleNodeFromLinkedList(head)** - use TH algorithm and delete it by making the previous node point to the next node(keep previous track).
17. **sortElementsLinkedListUsingMergeSort(head)** - fin middle element, then sort left side and sort right side recursively, then start merging the left and right. (use dummy node to create individual nodes to merge)
18. **oddEvenLinkedList(head)**—to arrange elements in odd even fashion based on indices, follow similar approach of having two heads and for each even index, link it to even a new dummy list and similarly for odd. finally, attach odd head to even head.
19. **sortALinkedList(head)**—we need to arrange all elements with 0,1,2 in sorted fashion, we create 3 dummy heads and everytime we encounter elements of the respective head, we add those elements. we attach one head or two heads depending on its existence to zero heads and two heads. Next to null.
20. **intersectionOfTwoLists() -** to find the intersection between two lists, add one list elements in the array, and if any other element exists from list2 then print it as the intersecting element. 
21. **add1ToLinkedListNumber(head)** - we use the concept of carry, reverse the linked list, then use new head and check if carry is present, if yes, then add 1 to the node data and continue, if carry added we get sum == 10 we keep it as 0 and continue the carry. once we traverse, if still carry is remaining, then we create a new node with 1 and append it to the nxt, now we reverse back the list.
22. **addTwoNumbersAsLinkedList(head1, head2)-** - we use dummy to simply the head handling. until any of the loop runs null, take a sum initialized with carry, add element 1 and 2. update carry with sum/10 and new node with sum%10. then move the temp pointers if not null. if still carry remains, add new node, and append. finally, reverse the list and print answer.
23. **reverseALinkedListInGroupOfK(head, 3)-** until count is less than k reverse the list, if count is still less than reverse it back. then if front there are nodes, then recall this method recursively.
24. **rotateALinkedListByKPlaces(head, 9)-** if we have to rotate in right by k places, we can do it by making the list circular and keeping count of elements. calculate diff as number of nodes from start to that node to traverse from head, this becomes the new head and now break the head. Next to null at the end.


## DoublyLinkedList

1. **convertArrayToDoublyLinkedList(new int[]{})**- for each node updated the back and front pointers with temp and currently pointed element.
2. **traverseADoublyLinkedList(doubleHead)**—traverse nodes until null in next, then from previous travel back until null in head.
3. **deleteInDoublyLinkedList(doubleHead)**—to delete head, set the head to next element and delete its back link to null.
4. **deleteTailInDoublyLinkedList(doubleHead**) - reach the element before it, and set its next to null to delete a tail element.
5. **deleteKthPositionInDoublyLinkedList(doubleHead, 3)** - reach the element before it, and update it next to the deleted element's next. and update the back of it to the current element.
6. **insertInDoublyLinkedList(doubleHead, 3, 3)**- TO INSERT at head, make the new node point to the current head and new node back to null. make the current head point to the new node at the back, for tail position, make the next node point to null and the new node's back to the current last element. For element at any K's position, make the prev element point to the new node, and the new node next point to the current element's next node.
7. **reverseADoublyLinkedList(doubleHead)** - we need to keep traversing each node and exchange the pointers of each node until we reach null.
8. **findMiddleOfADoublyLinkedList(doubleHead)** - we use tortoise and hare algorithm. fast pointer moves two places, another slow one moves one place. until a fast pointer moves to null.
9. **deleteAllOccurrencesOfKeyInDLL(doubleHead, 2)** - once we find the elements that match the key, we remove its back and front and update the nodes.
10. **findPairsWithGivenSumInDLL(doubleHead, 5)-** create a hash set, if the compliment of sum exists with a current element, that's the pair, or just add the element into the hashset.
11. **removeDuplicatesFromSortedDLL(doubleHead) -** create a hash set, delete duplicate occurrences by updating the back and front pointer.
12. **flattenABottomLinkedList() -** we recursively call flatten head with each head. then we call merge to merge 1st list with second. by calling it bottom traversal.
13. **cloneLLWithNextAndRandomListBrute()** - add all nodes to a hashmap (node and a new node copy), then while traversing, get the node and duplicate it by adding the next and random to it. 
14. **cloneWithNextAndRandomLLOptimal()** - first, between each node of the list we add our copy node with the same data. then in second, we set the random pointers to these copy nodes. in third we seperate the copy node list by using a dummy list and advancing two hops to copy only copy nodes.

## Application problem

**_DesignABrowserHistory("TUF")-_** Define three functions visit, back forward. in visit, create a new node,
