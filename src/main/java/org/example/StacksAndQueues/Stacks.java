package org.example.StacksAndQueues;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Stacks {


  public void implementStackUsingArrays(int[] array) {
    stack s = new stack(1000);
    for (int j : array) {
      s.push(j);
    }
    while (s.size() > 0) {
      System.out.println(s.pop());
    }
  }

  public void implementStackUsingQueue() {
    stackUsingQueue stackUsingQueue = new stackUsingQueue();
    stackUsingQueue.push(2);
    stackUsingQueue.push(3);
    stackUsingQueue.push(20);
    stackUsingQueue.push(34);
    System.out.println("Top is" + stackUsingQueue.top());
    while (stackUsingQueue.size() != 0) {
      System.out.println(stackUsingQueue.pop());
    }
  }

  public void implementStackUsingLinkedList() {
    stackUsingLinkedList s = new stackUsingLinkedList();
    s.push(2);
    s.push(3);
    s.push(5);
    System.out.println(s.top());
    System.out.println(s.pop());
    System.out.println(s.top());
  }

  public void checkParenthesis(String s) {
    if (s.isEmpty()) return;
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '{' || c == '[') {
        stack.add(c);
      } else if (c == ')' || c == '}' || c == ']') {
        if (stack.isEmpty()) return;
        char top = stack.peek();
        if ((top == '(' && c == ')') || (top == '{' && c == '}') || (top == '[' && c == ']'))
          stack.pop();
        else
          System.out.println("nah");
      }
    }
    if (stack.isEmpty())
      System.out.println("Valid parenthesis");
  }

  public void implementMinStack() {
    minstack minstack = new minstack();
    minstack.push(2);
    minstack.push(5);
    minstack.push(-1);
    minstack.push(-5);
    minstack.push(-4);
    System.out.println(minstack.pop());
    System.out.println(minstack.getMin());
    System.out.println(minstack.top());
  }

  public void infixToPostfix(String infix) {
    System.out.println(infix);
    Stack<Character> stack = new Stack<>();
    StringBuilder postfix = new StringBuilder();
    if (infix.isEmpty())
      System.out.println("nah");
    for (int i = 0; i < infix.length(); i++) {

      char ch = infix.charAt(i);
      if (Character.isLetterOrDigit(ch))
        postfix.append(ch);

      else if (ch == '(')
        stack.push(ch);

      else if (ch == ')') {
        while (!stack.isEmpty() && stack.peek() != '(')
          postfix.append(stack.pop());

        if (!stack.isEmpty() && stack.peek() != '(') {
          System.out.println("invalid");
          return;
        } else stack.pop();
      } else {
        while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
          if (stack.peek() == '(') {
            System.out.println("invalid");
            return;
          }
          postfix.append(stack.pop());
        }
        stack.push(ch);
      }
    }
    while (!stack.isEmpty()) {
      if (stack.peek() == '(') {
        System.out.println("invalid");
        return;
      }
      postfix.append(stack.pop());
    }
    System.out.println(postfix);
  }

  public static int precedence(char ch) {
    return switch (ch) {
      case '+', '-' -> 1;
      case '*', '/' -> 2;
      case '^' -> 3;
      default -> -1;
    };
  }

  private boolean isOperator(char c){
    return c == '+' || c == '-' || c == '^' || c == '/' || c == '*';
  }
  public void prefixToInfix(String prefix){
    Stack<String> stack = new Stack<>();
    StringBuilder reversePrefix = new StringBuilder(prefix).reverse();
    for(int i = 0;i<reversePrefix.length();i++){
      char ch = reversePrefix.charAt(i);

      if(!isOperator(ch))
        stack.push(ch+"");
      else {
        if(stack.size()<2) {
          System.out.println("invalid");
          return;
        }
        String op1 = stack.pop();
        String op2 = stack.pop();

        String infix = "(" +op1 + ch + op2 + ")";
        stack.push(infix);
      }
    }
    System.out.println(stack.pop());

  }
  public void prefixTPostfix(String prefix){
    Stack<String> stack = new Stack<>();
    StringBuilder reversePrefix = new StringBuilder(prefix).reverse();
    for(int i = 0;i<reversePrefix.length();i++){
      char ch = reversePrefix.charAt(i);

      if(!isOperator(ch))
        stack.push(ch+"");
      else {
        if(stack.size()<2) {
          System.out.println("invalid");
          return;
        }
        String op1 = stack.pop();
        String op2 = stack.pop();

        String postfix = op1+op2+ch;
        stack.push(postfix);
      }
    }
    System.out.println(stack.pop());

  }

  public void postfixToPrefix(String postfix){
    Stack<String> stack = new Stack<>();
    for(int i = 0;i<postfix.length();i++){
      char ch = postfix.charAt(i);

      if(!isOperator(ch))
        stack.push(ch+"");
      else {
        if(stack.size()<2) {
          System.out.println("invalid");
          return;
        }
        String op1 = stack.pop();
        String op2 = stack.pop();

        String prefix = ch+op1+op2;
        stack.push(prefix);
      }
    }
    System.out.println(stack.pop());

  }

  public void postfixToInfix(String postfix){
    Stack<String> stack = new Stack<>();
    for(int i = 0;i<postfix.length();i++){
      char ch = postfix.charAt(i);

      if(!isOperator(ch))
        stack.push(ch+"");
      else {
        if(stack.size()<2) {
          System.out.println("invalid");
          return;
        }
        String op1 = stack.pop();
        String op2 = stack.pop();

        String infix = "(" +op1 + ch + op2 + ")";
        stack.push(infix);
      }
    }
    System.out.println(stack.pop());

  }

  public void infixToPrefix(String infix){
    //reverse the expression and do infix to postfix, then reverse the final solution to get prefix.
  }

  public void nextGreaterElement(int[] arr){
    int count = 0;
    Stack<Integer> stack = new Stack<>();
    int n = arr.length;
    int[] nge = new int[n];
    for(int i=2*n-1; i>=0;i--) {
      while (!stack.isEmpty() && stack.peek() <= arr[i % n])
        stack.pop();
      if (i < n)
        if (!stack.isEmpty()) {
          nge[i] = stack.peek();
          count++;
        }
        else nge[i] = -1;

      stack.push(arr[i % n]);
    }
    System.out.println(count);
    System.out.println(Arrays.toString(nge));
  }

  public void nextSmallestElement(int[] arr){
    Stack<Integer> stack = new Stack<>();
    int n = arr.length;
    int[] nse = new int[n];
    for(int i=2*n-1;i>=0;i--){
      while (!stack.isEmpty() && stack.peek()>=arr[i%n])
        stack.pop();
      if(i<n)
        if(!stack.isEmpty()) nse[i] = stack.peek();
      else nse[i] = -1;

      stack.push(arr[i%n]);
    }
    System.out.println(Arrays.toString(nse));
  }

  public void numberOfNextSmallestElement(int[] arr){
    int count = 0;
    Stack<Integer> stack = new Stack<>();
    int n = arr.length;
    int[] nse = new int[n];
    for(int i=2*n-1;i>=0;i--){
      while (!stack.isEmpty() && stack.peek()>=arr[i%n])
        stack.pop();
      if(i<n)
        if(!stack.isEmpty()) {
          nse[i] = stack.peek();
          count++;
        }
        else nse[i] = -1;

      stack.push(arr[i%n]);
    }
    System.out.println(count);
    System.out.println(Arrays.toString(nse));
  }

  static class minstack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minstack = new Stack<>();

    void push(int x) {
      stack.push(x);
      if (minstack.empty() || x < minstack.peek())
        minstack.push(x);
    }

    int pop() {
      if (stack.empty())
        return -1;
      int val = stack.pop();
      if (val == minstack.peek()) {
        minstack.pop();
      }
      return val;
    }

    int size() {
      return stack.size();
    }

    int top() {
      if (stack.empty())
        return -1;
      return stack.peek();
    }

    int getMin() {
      if (minstack.empty())
        System.out.println("no element");
      return minstack.peek();
    }
  }

  static class stackUsingQueue {
    Queue<Integer> q = new LinkedList<>();

    void push(int x) {
      q.add(x);
      int size = q.size();
      for (int i = 0; i < size - 1; i++) {
        q.add(q.remove());
      }
    }

    int pop() {
      return q.remove();
    }

    int size() {
      return q.size();
    }

    int top() {
      if (q.isEmpty()) {
        System.out.println("Queue is empty!");
        return -1;
      }
      return q.peek();
    }

  }

  static class stackUsingLinkedList {
    LinkedList<Integer> list = new LinkedList<>();

    void push(int x) {
      System.out.println("pushed" + x + " into stack");
      list.add(x);
    }

    int pop() {
      if (list.isEmpty())
        return -1;
      return list.removeLast();
    }

    int size() {
      return list.size();
    }

    int top() {
      if (!list.isEmpty())
        return list.getLast();
      return -1;
    }
  }
}
