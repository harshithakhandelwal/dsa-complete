package org.example.Arrays.Striver;

import org.example.DataStructures.DoubleNode;
import org.example.DataStructures.Node;

import java.util.Objects;

public class LinkedListStriver {

  public Node<Integer> convertArrayToLinkedList(int[] arr) {

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

  public void reverseALinkedList(Node<Integer> head) {
    Node<Integer> temp = head;
    Node<Integer> prev = null;
    while (temp != null) {
      Node<Integer> front = temp.next;
      temp.next = prev;
      prev = temp;
      temp = front;
    }
    traverseALinkedList(prev);
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
    Node<Integer> temp = head;
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
    int count = 0;
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

  public void deleteTheMiddleNodeFromLinkedList(Node<Integer> head){
    Node<Integer> fast = head;
    Node<Integer> slow = head;
    Node<Integer> prev = null;
    while (fast!= null && fast.next!=null){
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
    if (head == null || head.next == null) {
      return;
    }
    Node<Integer> evenHead = head.next;
    Node<Integer> even = evenHead;
    Node<Integer> odd = head;

    while (even != null && even.next != null) {
      even.next = even.next.next;
      odd.next = odd.next.next;

      odd = odd.next;
      even = even.next;
    }
    odd.next = evenHead;
    traverseALinkedList(head);
  }
  public Node<Integer> sortElementsLinkedListUsingMergeSort(Node<Integer> head){
    //Overflow error!
    if(head==null || head.next==null)
      return head;
    Node<Integer> middle = findMiddleOfLL(head);
    Node<Integer> left = head;
    Node<Integer> right = middle.next;
    middle.next = null;
    left = sortElementsLinkedListUsingMergeSort(left);
    right = sortElementsLinkedListUsingMergeSort(right);
    return mergetwoLL(left,right);
  }

  private Node<Integer> mergetwoLL(Node<Integer> left, Node<Integer> right) {
    Node<Integer> current = new Node<>(-1);
    Node<Integer> temp = current;
    while (left != null && right!=null) {
      if (left.data < right.data) {
        temp.next = left;
        temp = left;
        left = left.next;
      }
      else {
        temp.next = right;
        temp = right;
        right = right.next;
      }
    }
    if(left!=null) temp.next = left;
    else if(right!=null) temp.next = right;
    return current.next;
  }

  private Node<Integer> findMiddleOfLL(Node<Integer> head) {
    Node<Integer> fast = head;
    Node<Integer> slow = head;
    while (fast!= null && fast.next!=null){
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}



