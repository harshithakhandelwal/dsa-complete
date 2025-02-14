package org.example.StacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Queues {

  public void implementationOfQueueUsingArrays(){
    queue q = new queue(6);
    q.push(4);
    q.push(14);
    q.push(24);
    q.push(34);

    while (q.size()!=0){
      System.out.println(q.pop());
    }
  }

  public void implementQueueUsingStacks(){
    queueUsingStacks q = new queueUsingStacks();
    q.push(1);
    q.push(2);
    q.push(3);
    System.out.println(q.top());
    q.pop();
    System.out.println(q.top());
  }

  public void implementQueuesUsingLinkedList(){
    queuesUsingLinkedList q = new queuesUsingLinkedList();
    q.push(2);
    q.push(3);
    q.push(4);
    System.out.println(q.top());
    System.out.println(q.pop());
    System.out.println(q.top());

  }

  static class queueUsingStacks {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    int element;

    void push(int element){
      while (!s1.empty())
        s2.add(s1.pop());
      s1.add(element);
      System.out.println("element"+element +" is inserted");
      while (!s2.empty())
        s1.add(s2.pop());
    }

    int pop(){
      if (s1.empty()) {
        System.out.println("Stack is empty");
      }
      return s1.pop();
    }

    int top(){
      if (s1.empty()) {
        System.out.println("Stack is empty");
      }
      return s1.peek();
    }

    int size(){
      return s1.size();
    }
  }

  static class queuesUsingLinkedList{
    LinkedList<Integer> l = new LinkedList<>();

    void push(int x){
      System.out.println("inserted element is: " + x);
      l.add(x);
    }

    int pop(){
      if(l.isEmpty())
        return -1;
      return l.removeFirst();
    }

    int top(){
      if(l.isEmpty())
        return -1;
      return l.getFirst();
    }

    int size(){
      return l.size();
    }
  }
  }

