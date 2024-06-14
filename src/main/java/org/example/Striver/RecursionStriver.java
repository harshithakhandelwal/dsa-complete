package org.example.Striver;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RecursionStriver {

  int mod = (int) 1e9 + 7;

  public void stringToIntegerAtoi(String s) {
    int count = 0;
    int res = 0;
    while (count < s.length() && s.charAt(count) == ' ') {
      count++;
    }
    int sign = 1;
    if (s.charAt(count) == '-') {
      sign = -1;
      count++;
    } else if (s.charAt(count) == '+') {
      count++;
    }
    while (count < s.length()) {
      if (Character.isDigit(s.charAt(count))) {
        res = res * 10 + (s.charAt(count) - '0');
        if (res > Integer.MAX_VALUE && sign == -1)
          System.out.println(Integer.MIN_VALUE);
        else if (res > Integer.MAX_VALUE && sign == 1)
          System.out.println(Integer.MAX_VALUE);
        count++;
      } else {
        System.out.println(res * sign);
        return;
      }
    }
    res = res * sign;
    System.out.println(res);
  }

  public void generateAllBinaryStringsWithoutConsecutive1s(int k) {
    ArrayList<String> binaryStrings = generateStrings(k);
    for (String s : binaryStrings) {
      System.out.print(s + " ");
    }
  }

  private ArrayList<String> generateStrings(int k) {
    if (k == 0) {
      ArrayList<String> emptylist = new ArrayList<>();
      emptylist.add("");
      return emptylist;
    }
    if (k == 1) {
      ArrayList<String> list = new ArrayList<>();
      list.add("0");
      list.add("1");
      return list;
    }
    ArrayList<String> result = new ArrayList<>();
    ArrayList<String> prevList = generateStrings(k - 1);
    for (String s : prevList) {
      result.add(s + "0");
      if (s.charAt(s.length() - 1) != '1') {
        result.add(s + "1");
      }
    }
    return result;
  }

  public void powerOfANumber(double x, int n) {
    double res = 1.0;
    long nn = n;
    if (nn < 0)
      nn = -1 * nn;
    while (nn > 0) {
      if (nn % 2 == 1) {
        res = res * x;
        nn = nn - 1;
      } else {
        x = x * x;
        nn = nn / 2;
      }
    }
    if (n < 0) res = 1.0 / res;
    System.out.println(res);
//    if (n == 0) {
//      return 1;
//    }
//    // If the exponent is negative, invert the base and make the exponent positive
//    if (n < 0) {
//      return 1.0 / powerOfANumber(x, -n);
//    }
//    // Recursive case: multiply base by the result of base raised to the power of (exponent - 1)
//    return x * powerOfANumber(x, n - 1);
  }

  public void countGoodNumbers(long n) {
    long first = (n % 2 == 0 ? n / 2 : (n / 2) + 1);
    long second = n / 2;
    long mul1 = power(5, first) % mod;
    long mul2 = power(4, second) % mod;
    long ans = 1;
    ans = mul1 * ans;
    ans = (second != 0 ? (ans * mul2) % mod : ans);
    System.out.println((int) ans % mod);
  }

  private long power(long x, long i) {
    long temp;
    if (i == 0)
      return 1;
    temp = power(x, i / 2);
    if (i % 2 == 0) return (temp * temp) % mod;
    else return (x * temp * temp) % mod;
  }

  public void sortStackUsingRecursion() {
    Stack<Integer> stack = new Stack<>();
    stack.add(1);
    stack.add(2);
    stack.add(4);
    stack.add(7);
    stack.add(3);
    stack.add(6);
    System.out.println(stack);
    sortStack(stack);
    System.out.println(stack);
  }

  private void sortStack(Stack<Integer> stack) {
    if (!stack.isEmpty()) {
      int top = stack.pop();
      sortStack(stack);
      insertSorted(stack, top);
    }
  }

  private void insertSorted(Stack<Integer> stack, int top) {
    if (stack.isEmpty()) {
      stack.push(top);
    } else {
      int element = stack.pop();
      insertSorted(stack, top);
      stack.push(element);
    }
  }

  public void reverseStackUsingRecursion() {
    Stack<Integer> stack = new Stack<>();
    stack.add(1);
    stack.add(2);
    stack.add(3);
    stack.add(4);
    stack.add(5);
    stack.add(6);
    System.out.println(stack);
    reverseStack(stack);
    System.out.println(stack);
  }

  private void reverseStack(Stack<Integer> stack) {
    if (!stack.isEmpty()) {
      int top = stack.pop();
      reverseStack(stack);
      insertSorted(stack, top);
    }
  }

  public void binarySearchUsingRecursion(int[] arr, int key) {
    int low = 0;
    int high = arr.length - 1;
    boolean ans = binarySearch(arr, low, high, key);
    if (ans)
      System.out.println("found");
    else
      System.out.println("not found");
  }

  private boolean binarySearch(int[] arr, int low, int high, int key) {
    if (low > high)
      return false;
    int mid = (low + high) / 2;
    if (arr[mid] == key)
      return true;
    else if (arr[mid] < key)
      return binarySearch(arr, mid + 1, high, key);
    else
      return binarySearch(arr, low, mid - 1, key);
  }

  public void reverseStringUsingRecursion(String s) {
    StringBuilder newS = new StringBuilder();
    String res = reverseStringBrute(s, 0, newS);
    char[] newChar = s.toCharArray();
    reverseStringOptimal(newChar, 0, newChar.length - 1);
    System.out.println(res);
    String reverse = new String(newChar);
    System.out.println(reverse);
  }

  private void reverseStringOptimal(char[] arr, int i, int j) {
    if (i > j)
      return;
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
    reverseStringOptimal(arr, i + 1, j - 1);
  }

  private String reverseStringBrute(String s, int position, StringBuilder newString) {
    if (position == s.length())
      return "";
    reverseStringBrute(s, position + 1, newString);
    return newString.append(s.charAt(position)).toString();
  }

  public void checkIfStringIsAPalindrome(String s) {
    char[] newChar = s.toCharArray();
    reverseStringOptimal(newChar, 0, newChar.length - 1);
    String reverse = new String(newChar);
    if (reverse.equalsIgnoreCase(s))
      System.out.println("Its a palindrome");
    else System.out.println("Not a palindrome");
  }

  public void generateParentheses(int n) {
    List<String> res = new ArrayList<>();
    recurseParenthesis(res, 0, 0, "", n);
    System.out.println(res);
  }

  private void recurseParenthesis(List<String> res, int left, int right, String s, int n) {
    if (s.length() == n * 2) {
      res.add(s);
      return;
    }
    if (left < n) {
      recurseParenthesis(res, left + 1, right, s + "(", n);
    }
    if (right < left) {
      recurseParenthesis(res, left, right + 1, s + ")", n);
    }
  }

  public void printAllSubsequencesPowerSet(String s) {
    generateSubstrings("", 0, s.toCharArray());
    // generateSubsetsUsingRecursion(new int[]{1,2,3},new ArrayList<>());
  }

  private void generateSubstrings(String s, int count, char[] input) {
    if (count == input.length) {
      System.out.println(s);
      return;
    }
    if (count < input.length) {
      generateSubstrings(s + input[count], count + 1, input);
    }
    generateSubstrings(s, count + 1, input);
  }
}




