package org.example.DSAMisc.Striver;

import java.util.*;

public class StringsStriver {

  public void removeOuterMostParenthesis(String s) {
    //The Approach is to keep an incrementing count for open bracket and decrement count for closed bracket.
    //If a bracket is open then append or if a closed bracket is not closed then append.
    StringBuilder ans = new StringBuilder();
    int count = 0;
    for (char ch : s.toCharArray()) {
      if (ch == '(') {
        if (count != 0) ans.append(ch);
        count++;
      } else if (ch == ')') {
        if (count != 1) ans.append(ch);
        count--;
      }

    }
    System.out.println("final string is=" + ans);
  }

  public void reverseWordsInString(String s) {
    //Split the string, then append in reverse order and add all spaces, trim spaces from answer if any.
    String[] words = s.split(" ");
    StringBuilder answer = new StringBuilder();
    System.out.println(Arrays.toString(words));
    for (int i = words.length - 1; i >= 0; i--) {
      answer.append(words[i]);
      answer.append(" ");
    }
    System.out.println(answer.toString().trim());
  }

  public void largestOddNumberInString(String num) {
    //Check from an end, if num is not divisible by 2 then its odd, print all char(num) from begining to that index.
    String sub = "";
    for (int i = num.length() - 1; i >= 0; i--) {
      if (num.charAt(i) % 2 != 0) {
        sub = num.substring(0, i + 1);
        break;
      }
    }
    System.out.println(sub);
  }

  public void longestCommonPrefix(String[] strings) {
    //Sort the array of strings and compare char by char
    StringBuilder prefix = new StringBuilder();
    Arrays.sort(strings);
    String first = strings[0];
    String last = strings[strings.length - 1];
    for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
      if (first.charAt(i) == last.charAt(i)) {
        prefix.append(first.charAt(i));
      } else {
        System.out.println(prefix);
        break;
      }
    }
    System.out.println();
  }

  public void isIsomorphic(String s, String t) {
    //make 2 maps with char coding from s->t and t->s
    // and then check if any char already exists in map and is having a different mapping, if not add them to maps.
    HashMap<Character, Character> mapst = new HashMap<>();
    HashMap<Character, Character> mapts = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      if (mapst.get(s.charAt(i)) != null && mapst.get(s.charAt(i)) != t.charAt(i) || mapts.get(t.charAt(i)) != null && mapts.get(t.charAt(i)) != s.charAt(i))
        System.out.println("not isomorphic");
      mapst.put(s.charAt(i), t.charAt(i));
      mapts.put(t.charAt(i), s.charAt(i));
    }
    System.out.println("isomorphic");
  }

  public void rotateString(String s, String goal) {
    //to check if a roation exists, just concat the  string, the combination will be part of goal then it exists.
    if (s.length() == goal.length() && (s + s).contains(goal))
      System.out.println(true + (s + s));
    System.out.println(false);
  }

  public void anagramsOfString(String s1, String s2) {
    //For each character, make a freq map, such that, if all chars of s1 is present in s2 then it will a 0 array.
    //Then, if any freq map is not 0, it means it is not an anagram.
    int[] freq = new int[26];
    if (s1.length() != s2.length())
      System.out.println("Not an anagram");
    for (int i : s1.chars().toArray() ) freq[i - 'A']++;
    for (int i : s2.chars().toArray() ) freq[i - 'A']--;
    for (int i = 0; i < 26; i++)
      if (freq[i] != 0)
        System.out.println("Not an anagram");
    System.out.println("Anagram");
  }

  public void frequencySort(String s) {
    //
    HashMap<Character,Integer> freq = new HashMap<>();
    StringBuilder stringBuilder = new StringBuilder();
    for(char i: s.toCharArray())
      freq.put(i,freq.getOrDefault(i,0)+1);
    System.out.println(freq);
    PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
    pq.addAll(freq.entrySet());
    System.out.println(pq);
    while(!pq.isEmpty()) {
      Map.Entry<Character,Integer> map = pq.poll();
      stringBuilder.append(String.valueOf(map.getKey()).repeat(map.getValue()));
    }
    System.out.println(stringBuilder);
  }

  public void maxDepthOfANestedString(String s) {
    int count = 0;
    int maxNum = 0;
    for (char c : s.toCharArray()) {
      if (c == '(') {
        count++;
        if (maxNum < count)
          maxNum = count;
      } else if (c == ')') {
        count--;
      }
    }
  }


}


