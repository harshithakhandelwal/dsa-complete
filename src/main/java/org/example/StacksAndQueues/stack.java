package org.example.StacksAndQueues;

 class stack {

  private int size,top;
  private final int[] arr;

  public stack(int size) {
    arr = new int[size];
    top = -1;
  }
  public int top(){
    return arr[top];
  }

  public int pop() {
    int x = arr[top];
    top--;
   return x;
  }

  public void push(int x) {
    top++;
    arr[top] = x;
  }

  public int size() {
    return top+1;
  }

}
