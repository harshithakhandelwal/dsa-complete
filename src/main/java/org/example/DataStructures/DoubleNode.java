package org.example.DataStructures;

public class DoubleNode<T> {
  public T data;
  public DoubleNode<T> next;

  public DoubleNode<T> back;

  public DoubleNode(T data){
    this.data = data;
    this.next = null;
    this.back = null;
  }

}
