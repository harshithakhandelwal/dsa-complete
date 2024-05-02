package org.example.Arrays.Striver;

import org.example.DataStructures.DoubleNode;
import org.example.DataStructures.Node;

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

  public DoubleNode<Integer> convertArrayToDoublyLinkedList(int[] arr){
    DoubleNode<Integer> head = new DoubleNode<>(arr[0]);
    head.back = null;
    DoubleNode<Integer> mover = head;
    for(int i = 1; i<arr.length;i++){
     DoubleNode<Integer> temp = new DoubleNode<>(arr[i]);
      mover.next =  temp;
      temp.back = mover;
      mover=temp;
    }
    System.out.println(head.data);
    return head;
  }

  public void traverseADoublyLinkedList(DoubleNode<Integer> head){
    DoubleNode<Integer> temp = head;
    while(temp!=null){
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
    DoubleNode<Integer> current = head;
    while(current!=null && current.next!=null){
      current = current.next;
    }
    while (current!=null){
      System.out.print(current.data+ " ");
      current = current.back;
    }
  }

  public void deleteInDoublyLinkedList(DoubleNode<Integer> head){
    if(head==null) return;
    else if(head.next==null && head.back==null)
      System.out.println();
    else {
      head = head.next;
      System.out.println(head.data);
      head.back = null;
      traverseADoublyLinkedList(head);
      System.out.println();
    }
  }
  public void deleteTailInDoublyLinkedList(DoubleNode<Integer> head){
    if(head==null) return;
    else if(head.next==null && head.back==null)
      System.out.println();
    else {
      DoubleNode<Integer> current = head;
      while (current!=null && current.next.next!=null)
        current=current.next;
      current.next = null;
    }
    traverseADoublyLinkedList(head);
  }
  public void deleteKthPositionInDoublyLinkedList(DoubleNode<Integer> head,int position){
    traverseADoublyLinkedList(head);
    System.out.println();
    if(head==null) return;
    if(position==1)
      deleteInDoublyLinkedList(head);
    if(position==5)
      deleteTailInDoublyLinkedList(head);
    else {
      DoubleNode<Integer> current = head;
      int count = 0;
      while(current!=null){
        count++;
        if(position==count) {
          current.back.next = current.next;
          current.next.back = current.back;
          break;
        }
        current=current.next;
      }
    }
    traverseADoublyLinkedList(head);
  }

}
