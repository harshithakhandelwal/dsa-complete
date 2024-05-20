package org.example.Arrays.Striver;

import org.example.DataStructures.DoubleNode;

public class DesignABrowserHistory {
  DoubleNode<String> current;

  public DesignABrowserHistory(String homepage){
    current = new DoubleNode<>(homepage);
    System.out.println("We are at " + current.data);
  }

  public void visit(String s){
    DoubleNode<String> newNode = new DoubleNode<>(s);
    current.next = newNode;
    newNode.back = current;
    current = newNode;
    System.out.println("We are at " + current.data);
  }

  public String back(int steps){
    while (steps>0) {
      if (current.back != null)
        current = current.back;
      steps--;
    }
    System.out.println("We are at " + current.data);
    return current.data;
  }

  public String forward(int steps)
  {
    while (steps>0) {
    if (current.next != null)
      current = current.next;
    steps--;
  }
    System.out.println("We are at " + current.data);
    return current.data;
  }
}
