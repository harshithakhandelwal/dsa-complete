package org.example.LinkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class LinkedListStriver {

  public Node<Integer> convertArrayToLinkedList(int[] arr) {
    if (arr.length == 0) return null;
    Node<Integer> head = new Node<>(arr[0]);
    Node<Integer> mover = head;
    for (int i = 1; i < arr.length; i++) {
      Node<Integer> temp = new Node<>(arr[i]);
      mover.next = temp;
      mover = temp;
    }
    System.out.println(head.data);
    return head;
  }

  public void traverseALinkedList(Node<Integer> head) {
    Node<Integer> temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
  }

  public void lengthOfALinkedList(Node<Integer> head) {
    int count = 0;
    Node<Integer> temp = head;
    while (temp != null) {
      count++;
      temp = temp.next;
    }
    System.out.println("Count is" + count);
  }

  public void searchInALinkedList(Node<Integer> head, int target) {
    Node<Integer> temp = head;
    while (temp != null) {
      if (temp.data == target)
        System.out.println("target found!");
      temp = temp.next;
    }
  }

  public void deleteHeadNodeOfALinkedList(Node<Integer> head) {
    if (head == null) return;
    System.out.println("Deleted node is" + head.data);
    head = head.next;
    traverseALinkedList(head);
  }

  public void deleteTailNodeOfALinkedList(Node<Integer> head) {
    if (head == null || head.next == null) return;
    Node<Integer> temp = head;
    while (temp.next.next != null)
      temp = temp.next;
    System.out.println("Deleted node is" + temp.next.data);
    temp.next = null;
    traverseALinkedList(head);
  }

  public void deleteKPositionOfALinkedList(Node<Integer> head, int position) {
    Node<Integer> temp = head;
    int count = 0;
    Node prev = null;
    if (head == null)
      System.out.println(head);
    if (position == 1) {
      deleteHeadNodeOfALinkedList(head);
      return;
    }
    if (position > 5)
      System.out.println(head);
    while (temp != null) {
      count++;
      if (count == position) {
        prev.next = prev.next.next;
        break;
      }
      prev = temp;
      temp = temp.next;
    }
    traverseALinkedList(head);
  }

  public void deleteKValueOfALinkedList(Node<Integer> head, int value) {
    Node<Integer> temp = head;
    Node<Integer> prev = null;
    if (head.data == value) {
      deleteHeadNodeOfALinkedList(head);
      return;
    }
    while (temp != null) {
      if (temp.data == value) {
        prev.next = prev.next.next;
        break;
      }
      prev = temp;
      temp = temp.next;
    }
    traverseALinkedList(head);
  }

  public void insertionInaLinkedList(Node<Integer> head, int element, int position) {
    Node<Integer> newnode = new Node<>(element);
    if (head == null)
      head = newnode;
    Node<Integer> temp = head;
    Node<Integer> prev = null;
    int count = 0;
    if (position == 1) {
      head = newnode;
      head.next = temp;
      traverseALinkedList(head);
      return;
    }
    while (temp != null) {
      count++;
      if (position == count) {
        newnode.next = temp;
        prev.next = newnode;
      }
      if (temp.next == null) {
        temp.next = newnode;
        traverseALinkedList(head);
        return;
      }
      prev = temp;
      temp = temp.next;
    }
    traverseALinkedList(head);
  }

  public DoubleNode<Integer> convertArrayToDoublyLinkedList(int[] arr) {
    if (arr.length == 0)
      return null;
    DoubleNode<Integer> head = new DoubleNode<>(arr[0]);
    head.back = null;
    DoubleNode<Integer> mover = head;
    for (int i = 1; i < arr.length; i++) {
      DoubleNode<Integer> temp = new DoubleNode<>(arr[i]);
      mover.next = temp;
      temp.back = mover;
      mover = temp;
    }
    System.out.println(head.data);
    return head;
  }

  public void traverseADoublyLinkedList(DoubleNode<Integer> head) {
    DoubleNode<Integer> temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
    DoubleNode<Integer> current = head;
    while (current != null && current.next != null) {
      current = current.next;
    }
    while (current != null) {
      System.out.print(current.data + " ");
      current = current.back;
    }
  }

  public void deleteInDoublyLinkedList(DoubleNode<Integer> head) {
    if (head == null) return;
    else if (head.next == null && head.back == null)
      System.out.println();
    else {
      head = head.next;
      System.out.println(head.data);
      head.back = null;
      traverseADoublyLinkedList(head);
      System.out.println();
    }
  }

  public void deleteTailInDoublyLinkedList(DoubleNode<Integer> head) {
    if (head == null) return;
    else if (head.next == null && head.back == null)
      System.out.println();
    else {
      DoubleNode<Integer> current = head;
      while (current != null && current.next.next != null)
        current = current.next;
      current.next = null;
    }
    traverseADoublyLinkedList(head);
  }

  public void deleteKthPositionInDoublyLinkedList(DoubleNode<Integer> head, int position) {
    traverseADoublyLinkedList(head);
    System.out.println();
    if (head == null) return;
    if (position == 1)
      deleteInDoublyLinkedList(head);
    if (position == 5)
      deleteTailInDoublyLinkedList(head);
    else {
      DoubleNode<Integer> current = head;
      int count = 0;
      while (current != null) {
        count++;
        if (position == count) {
          current.back.next = current.next;
          current.next.back = current.back;
          break;
        }
        current = current.next;
      }
    }
    traverseADoublyLinkedList(head);
  }

  public void insertInDoublyLinkedList(DoubleNode<Integer> head, int target, int position) {
    DoubleNode<Integer> newNode = new DoubleNode<>(target);
    if (head == null) return;
    DoubleNode<Integer> current = head;
    if (position == 1) {
      head = newNode;
      head.next = current;
      current.back = head;
      traverseADoublyLinkedList(head);
    } else if (position == 5) {
      while (current.next != null) {
        current = current.next;
      }
      current.next = newNode;
      newNode.back = current;
      traverseADoublyLinkedList(head);
    } else {
      int count = 0;
      while (current.next != null) {
        count++;
        if (position == count) {
          newNode.back = current.back;
          newNode.next = current;
          current.back.next = newNode;
          current.back = newNode;
          break;
        }
        current = current.next;
      }
      traverseADoublyLinkedList(head);
    }
  }

  public void reverseADoublyLinkedList(DoubleNode<Integer> head) {
    DoubleNode<Integer> current = head;
    DoubleNode<Integer> prev = null;
    while (current != null) {
      prev = current.back;
      current.back = current.next;
      current.next = prev;
      current = current.back;
    }
    traverseADoublyLinkedList(prev.back);
  }

  public void findMiddleOfADoublyLinkedList(DoubleNode<Integer> head) {
    traverseADoublyLinkedList(head);
    DoubleNode<Integer> slow = head;
    DoubleNode<Integer> fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    System.out.println("Middle element is " + slow.data);
  }

  public Node<Integer> reverseALinkedList(Node<Integer> head) {
    Node<Integer> temp = head;
    Node<Integer> prev = null;
    while (temp != null) {
      Node<Integer> front = temp.next;
      temp.next = prev;
      prev = temp;
      temp = front;
    }
    traverseALinkedList(prev);
    return prev;
  }

  public void detectACycleInLinkedList() {
    Node<Integer> head = new Node<>(1);
    Node<Integer> second = new Node<>(2);
    Node<Integer> third = new Node<>(3);
    Node<Integer> fourth = new Node<>(4);
    Node<Integer> fifth = new Node<>(5);

    head.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = fifth;
    // Create a loop
    fifth.next = third;

    Node<Integer> slow = head;
    Node fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        System.out.println("cycle detected!");
        break;
      }
    }
  }

  public Node<Integer> reverseALinkedListUsingRecursion(Node<Integer> head) {
    if (head == null || head.next == null)
      return head;
    Node<Integer> newHead = reverseALinkedListUsingRecursion(head.next);
    Node<Integer> front = head.next;
    front.next = head;
    head.next = null;
    return newHead;
  }

  public void findStartingNodeOfaLoopInLinkedList() {
    Node<Integer> head = new Node<>(1);
    Node<Integer> second = new Node<>(2);
    Node<Integer> third = new Node<>(3);
    Node<Integer> fourth = new Node<>(4);
    Node<Integer> fifth = new Node<>(5);

    head.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = fifth;
    // Create a loop
    fifth.next = third;

    Node<Integer> slow = head;
    Node fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        System.out.println("cycle detected!");
        slow = head;
        while (slow != fast) {
          slow = slow.next;
          fast = fast.next;
        }
        System.out.println(slow.data);

        break;
      }
    }
  }

  public void lengthOfLoopOfALinkedList() {
    Node<Integer> head = new Node<>(1);
    Node<Integer> second = new Node<>(2);
    Node<Integer> third = new Node<>(3);
    Node<Integer> fourth = new Node<>(4);
    Node<Integer> fifth = new Node<>(5);

    head.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = fifth;
    // Create a loop
    fifth.next = third;

    Node<Integer> slow = head;
    Node<Integer> fast = head;
    int count = 1;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        while (slow != fast) {
          count++;
          fast = fast.next;
        }
      }
      System.out.println("cycle detected!");
      System.out.println(count);
      break;
    }
  }

  public void checkIfLinkedListIsPalindromeOrNot(Node<Integer> head) {
    Node<Integer> fast = head;
    Node<Integer> slow = head;
    while (fast != null && fast.next != null) {
      slow = fast.next;
      fast = fast.next.next;
    }
    Node<Integer> temp = slow;
    Node<Integer> prev = null;
    while (temp != null) {
      Node<Integer> front = temp.next;
      temp.next = prev;
      prev = temp;
      temp = front;
    }
    Node<Integer> first = head;
    Node<Integer> second = prev;
    while (first != null && second != null) {
      if (!Objects.equals(first.data, second.data)) {
        System.out.println("Not a palindrome!");
        break;
      }
      first = first.next;
      second = second.next;
    }
    System.out.println("Palindrome!");

  }


  public void sortALinkedList(Node<Integer> head) {
    Node<Integer> current = head;
    Node<Integer> newHead = new Node<>(-1);
    Node<Integer> oneHead = new Node<>(-1);
    Node<Integer> twoHead = new Node<>(-1);
    Node<Integer> zero = newHead;
    Node<Integer> one = oneHead;
    Node<Integer> two = twoHead;

    while (current != null) {
      if (current.data == 0) {
        zero.next = current;
        zero = current;
      } else if (current.data == 1) {
        one.next = current;
        one = current;
      } else if (current.data == 2) {
        two.next = current;
        two = current;
      }
      current = current.next;
    }
    zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
    one.next = twoHead.next;
    twoHead.next = null;

    newHead = newHead.next;
    traverseALinkedList(newHead);
  }

  public void removeNthNodeFromBackOfALinkedList(Node<Integer> head, int n) {
    Node<Integer> fast = head;
    Node<Integer> slow = head;
    if (head == null || head.next == null)
      return;
    for (int i = 1; i <= n; i++) {
      fast = fast.next;
    }
    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
    traverseALinkedList(head);
  }

  public void deleteTheMiddleNodeFromLinkedList(Node<Integer> head) {
    Node<Integer> fast = head;
    Node<Integer> slow = head;
    Node<Integer> prev = null;
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    assert prev != null;
    prev.next = slow.next;
    traverseALinkedList(head);
  }

  public void oddEvenLinkedList(Node<Integer> head) {
    //This does not work idk why
    Node<Integer> evenHead = new Node<>(-1);
    ;
    Node<Integer> oddHead = new Node<>(-1);
    ;
    Node<Integer> even = evenHead;
    Node<Integer> odd = oddHead;
    Node<Integer> itr = head;
    int count = 1;
    while (itr != null) {
      if (count % 2 == 0) {
        even.next = itr;
        itr = itr.next;
        even = even.next;
      } else {
        odd.next = itr;
        itr = itr.next;
        odd = odd.next;
      }
      count++;
    }
    odd.next = evenHead.next;
    traverseALinkedList(oddHead.next);
  }

  public Node<Integer> sortElementsLinkedListUsingMergeSort(Node<Integer> head) {
    //Overflow error!
    if (head == null || head.next == null)
      return head;
    Node<Integer> middle = findMiddleOfLL(head);
    Node<Integer> left = head;
    Node<Integer> right = middle.next;
    middle.next = null;
    left = sortElementsLinkedListUsingMergeSort(left);
    right = sortElementsLinkedListUsingMergeSort(right);
    return mergetwoLL(left, right);
  }

  private Node<Integer> mergetwoLL(Node<Integer> left, Node<Integer> right) {
    Node<Integer> current = new Node<>(-1);
    Node<Integer> temp = current;
    while (left != null && right != null) {
      if (left.data <= right.data) {
        temp.next = left;
        temp = left;
        left = left.next;
      } else {
        temp.next = right;
        temp = right;
        right = right.next;
      }
    }
    if (left != null) temp.next = left;
    else if (right != null) temp.next = right;
    return current.next;
  }

  private Node<Integer> findMiddleOfLL(Node<Integer> head) {
    Node<Integer> fast = head.next;
    Node<Integer> slow = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public void intersectionOfTwoLists() {
    Node<Integer> head = null;
    head = insertNode(head, 1);
    head = insertNode(head, 3);
    head = insertNode(head, 1);
    head = insertNode(head, 2);
    head = insertNode(head, 4);
    Node<Integer> head1 = head;
    head = head.next.next.next;
    Node<Integer> headSec = null;
    headSec = insertNode(headSec, 3);
    Node<Integer> head2 = headSec;
    headSec.next = head;
    System.out.print("List1: ");
    traverseALinkedList(head1);
    System.out.print("List2: ");
    traverseALinkedList(head2);

    HashSet<Node<Integer>> st = new HashSet<>();
    Node<Integer> temp1 = head1;
    Node<Integer> temp2 = head2;
    while (temp1 != null) {
      st.add(temp1);
      temp1 = temp1.next;
    }
    while (temp2 != null) {
      if (st.contains(temp2)) {
        System.out.println("Intersection element is " + temp2.data);
        break;
      }
      temp2 = temp2.next;
    }
  }

  static Node<Integer> insertNode(Node<Integer> head, int val) {
    Node<Integer> newNode = new Node<>(val);

    if (head == null) {
      head = newNode;
      return head;
    }

    Node<Integer> temp = head;
    while (temp.next != null) temp = temp.next;

    temp.next = newNode;
    return head;
  }

  public void add1ToLinkedListNumber(Node<Integer> head) {
    Node<Integer> newNode = reverseALinkedList(head);
    Node<Integer> newHead = newNode;
    boolean carry = false;
    while (newNode != null) {
      if (carry) {
        if (newNode.data + 1 == 10) {
          newNode.data = 0;
        } else {
          newNode.data = newNode.data + 1;
          carry = false;
        }
      } else {
        if (newNode.data + 1 == 10) {
          newNode.data = 0;
          carry = true;
        } else {
          newNode.data = newNode.data + 1;
          break;
        }
      }
      if (newNode.next == null && carry) {
        newNode.next = new Node<>(1);
        break;
      }
      newNode = newNode.next;
    }
    System.out.println("\n" + "The final answer is ");
    reverseALinkedList(newHead);
  }

  public void addTwoNumbersAsLinkedList(Node<Integer> head1, Node<Integer> head2) {
    Node<Integer> dummy = new Node<>(-1);
    Node<Integer> current = dummy;
    Node<Integer> temp1 = head1;
    Node<Integer> temp2 = head2;
    int carry = 0;
    while (temp1 != null || temp2 != null) {
      int sum = carry;
      if (temp1 != null) sum += temp1.data;
      if (temp2 != null) sum += temp2.data;
      carry = sum / 10;
      current.next = new Node<>(sum % 10);
      current = current.next;
      if (temp1 != null) temp1 = temp1.next;
      if (temp2 != null) temp2 = temp2.next;
    }
    if (carry != 0) {
      Node<Integer> newAdd = new Node<>(1);
      current.next = newAdd;
    }
    reverseALinkedList(dummy.next);
  }

  public void deleteAllOccurrencesOfKeyInDLL(DoubleNode<Integer> head, int key) {
    traverseADoublyLinkedList(head);
    if (head == null || head.next == null)
      return;
    DoubleNode<Integer> current = head;
    while (current != null) {
      if (current.data == key) {
        if (current == head)
          head = current.next;
        DoubleNode<Integer> front = current.next;
        DoubleNode<Integer> prev = current.back;
        if (prev != null) prev.next = front;
        if (front != null) front.back = prev;
        current = current.next;
      } else
        current = current.next;
    }
    traverseADoublyLinkedList(head);
  }

  public void findPairsWithGivenSumInDLL(DoubleNode<Integer> doubleHead, int sum) {
    DoubleNode<Integer> temp = doubleHead;
    HashSet<Integer> set = new HashSet<>();
    while (temp != null) {
      int diff = sum - temp.data;
      if (set.contains(diff))
        System.out.println("Pair = " + temp.data + " " + diff);
      set.add(temp.data);
      temp = temp.next;
    }
  }

  public void removeDuplicatesFromSortedDLL(DoubleNode<Integer> head) {
    traverseADoublyLinkedList(head);
    if (head == null || head.next == null)
      return;
    HashSet<Integer> visited = new HashSet<>();
    DoubleNode<Integer> current = head;
    while (current != null) {
      if (visited.contains(current.data)) {
        if (current == head)
          head = current.next;
        DoubleNode<Integer> front = current.next;
        DoubleNode<Integer> prev = current.back;
        if (prev != null) prev.next = front;
        if (front != null) front.back = prev;
        current = current.next;
      } else {
        visited.add(current.data);
        current = current.next;
      }
    }
    System.out.println(" \n New list is = ");
    traverseADoublyLinkedList(head);
  }

  public Node<Integer> reverseALinkedListInGroupOfK(Node<Integer> head, int k) {
    Node<Integer> current = head;
    Node<Integer> prev = null;
    Node<Integer> front = null;
    int count = 0;

    while (count < k && current != null) {
      front = current.next;
      current.next = prev;
      prev = current;
      current = front;
      count++;
    }

    if (count < k) {
      Node<Integer> temp = prev;
      prev = null;
      while (temp != null) {
        while (temp != null) {
          front = temp.next;
          temp.next = prev;
          prev = temp;
          temp = front;
        }
        return prev;
      }
    }
    if(front!=null) {
      head.next = reverseALinkedListInGroupOfK(front,k);
    }
    System.out.println();
    traverseALinkedList(prev);
    return prev;
  }

  public void rotateALinkedListByKPlaces(Node<Integer> head, int k) {
    if(head == null||head.next == null||k == 0) return;
    Node<Integer> current = head;
    int count = 1;
    while (current.next != null) {
      current = current.next;
      count++;
    }
    System.out.println(count);
    current.next = head;
    k = k % count;
    int diff = count - k;
    while (diff > 0) {
      current = current.next;
      diff--;
    }
    head = current.next;
    current.next = null;
    traverseALinkedList(head);
  }

  public void flattenABottomLinkedList(){
    DoubleNode<Integer> doubleNode = new DoubleNode<>(5);
    doubleNode.back = new DoubleNode<>(7);
    doubleNode.back.back = new DoubleNode<>(8);
    doubleNode.back.back.back = new DoubleNode<>(30);

    doubleNode.next = new DoubleNode<>(10);
    doubleNode.next.back = new DoubleNode<>(20);

    doubleNode.next.next = new DoubleNode<>(19);
    doubleNode.next.next.back = new DoubleNode<>(22);
    doubleNode.next.next.back.back = new DoubleNode<>(50);

    doubleNode.next.next.next = new DoubleNode<>(28);
    doubleNode.next.next.next.back = new DoubleNode<>(35);
    doubleNode.next.next.next.back.back = new DoubleNode<>(40);
    doubleNode.next.next.next.back.back.back = new DoubleNode<>(45);
    System.out.println();
    flatten(doubleNode);
    printFlattenList(doubleNode);
  }
  public void printFlattenList(DoubleNode<Integer> head){
    DoubleNode<Integer> temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.back;
    }
    System.out.println();
  }
  public DoubleNode<Integer> flatten(DoubleNode<Integer> head){
    if(head==null || head.next==null)
      return head;
    DoubleNode<Integer> mergeHead = flatten(head.next);
    head = mergeDLL(mergeHead,head);
    return head;
  }

  private DoubleNode<Integer> mergeDLL(DoubleNode<Integer> list1, DoubleNode<Integer> list2) {
    DoubleNode<Integer> dummy = new DoubleNode<>(-1);
    DoubleNode<Integer> res = dummy;
    while (list1!=null && list2!=null){
      if(list1.data< list2.data) {
        res.back = list1;
        res = list1;
        list1 = list1.back;
      }
      else {
        res.back = list2;
        res = list2;
        list2 = list2.back;
      }
    }
    if(list1!=null) res.back = list1;
    else res.back = list2;
    return dummy.back;
  }


  public void cloneLLWithNextAndRandomListBrute(){
    //back is random here!
    DoubleNode<Integer> head = new DoubleNode<>(7);
    head.next = new DoubleNode<>(14);
    head.next.next = new DoubleNode<>(21);
    head.next.next.next = new DoubleNode<>(28);

    // Assigning random pointers
    head.back = head.next.next;
    head.next.back = head;
    head.next.next.back = head.next.next.next;
    head.next.next.next.back = head.next;

    HashMap<DoubleNode<Integer>,DoubleNode<Integer>> map = new HashMap<>();
    DoubleNode<Integer> temp = head;
    while (temp!=null){
      DoubleNode<Integer> newNode = new DoubleNode<>(temp.data);
      map.put(temp,newNode);
      temp = temp.next;
    }
    temp = head;
    while (temp!=null){
      DoubleNode<Integer> copyNode = map.get(temp);
      copyNode.next = map.get(temp.next);
      copyNode.back = map.get(temp.back);
      temp = temp.next;


      while (head != null) {
        System.out.print("Data: " + head.data);
        if (head.back != null) {
          System.out.print(", Random: " + head.back.data);
        } else {
          System.out.print(", Random: nullptr");
        }
        System.out.println();
        head = head.next;
      }

    }

  }
  public void cloneWithNextAndRandomLLOptimal(){
    //back is random here!
    DoubleNode<Integer> head = new DoubleNode<>(7);
    head.next = new DoubleNode<>(14);
    head.next.next = new DoubleNode<>(21);
    head.next.next.next = new DoubleNode<>(28);

    // Assigning random pointers
    head.back = head.next.next;
    head.next.back = head;
    head.next.next.back = head.next.next.next;
    head.next.next.next.back = head.next;
    DoubleNode<Integer> temp = head;
    while (temp != null){
      DoubleNode<Integer> next = temp.next;
      DoubleNode<Integer> copyNode = new DoubleNode<>(temp.data);
      copyNode.next = next;
      temp.next = copyNode;
      temp = next;
    }
    temp = head;
    while (temp!=null){
      DoubleNode<Integer> copyNode = temp.next;
      if(temp.back!=null)
        copyNode.back = temp.back.next;
      else copyNode.back = null;
      temp = temp.next.next;
    }
    temp=head;
    DoubleNode<Integer> dummy = new DoubleNode<>(-1);
    DoubleNode<Integer> res = dummy;
    while (temp!=null){
      res.next = temp.next;
      temp.next = temp.next.next;
      res = res.next;
      temp = temp.next;
    }

    while (dummy != null) {
      System.out.print("Data: " + dummy.data);
      if (dummy.back != null) {
        System.out.print(", Random: " + dummy.back.data);
      } else {
        System.out.print(", Random: nullptr");
      }
      System.out.println();
      dummy = dummy.next;
    }

  }
}






