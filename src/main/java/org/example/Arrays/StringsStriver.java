package org.example.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class StringsStriver {

  public void removeOuterMostParenthesis(String s){
    StringBuilder ans = new StringBuilder();
    int count = 0;
    for(char ch: s.toCharArray()) {
      if (ch == '(') {
        if (count != 0) ans.append(ch);
        count++;
      } else if (ch == ')'){
        if (count != 1) ans.append(ch);
      count--;
    }

    }
    System.out.println("final string is="+ ans);
  }

  public void reverseWordsInString(String s) {
    String[] words = s.split(" ");
    StringBuilder answer = new StringBuilder();
    System.out.println(Arrays.toString(words));
    for(int i = words.length-1; i>=0;i--) {
      answer.append(words[i]);
      answer.append(" ");
    }
    System.out.println(answer.toString().trim());
  }
  public void largestOddNumberInString(String num){
    String sub = "";
    for(int i = num.length()-1; i>=0; i--){
      if(num.charAt(i)%2!=0){
       sub = num.substring(0,i+1);
       break;
      }
    }
    System.out.println(sub);
  }

  public void longestCommonPrefix(String[] strings){
    StringBuilder prefix = new StringBuilder();
    Arrays.sort(strings);
    String first = strings[0];
    String last = strings[strings.length-1];
    for(int i = 0; i<Math.min(first.length(),last.length());i++){
      if(first.charAt(i)==last.charAt(i)){
        prefix.append(first.charAt(i));
      }
      else {
        System.out.println(prefix);
        break;
      }
    }
    System.out.println();
  }
  }


