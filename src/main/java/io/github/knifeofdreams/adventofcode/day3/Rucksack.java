package io.github.knifeofdreams.adventofcode.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Rucksack {

  public int sumOfPriorities(List<String> allItems) {
    return allItems.stream()
        .mapToInt(
            items -> {
              var fullSet = new HashSet<Character>();
              for (int i = 0; i < items.length() / 2; i++) {
                fullSet.add(items.charAt(i));
              }
              for (int i = items.length() / 2; i < items.length(); i++) {
                if (fullSet.contains(items.charAt(i))) {
                  return calculatePriority(items.charAt(i));
                }
              }
              throw new IllegalArgumentException("No duplicate items found between: " + items);
            })
        .sum();
  }

  public int groupBadgePriorities(List<String> items) {
    var groups = new ArrayList<List<String>>();
    var g = new ArrayList<String>();
    for (String item : items) {
      if (g.size() < 3) {
        g.add(item);
      } else {
        groups.add(g);
        g = new ArrayList<>();
        g.add(item);
      }
    }
    groups.add(g);

    var sortedGroups = new ArrayList<ArrayList<String>>();
    for (List<String> group : groups) {
      var sortedItems = new ArrayList<String>();
      for (String contents : group) {
        char[] chars = contents.toCharArray();
        Arrays.sort(chars);
        sortedItems.add(new String(chars));
      }
      sortedGroups.add(sortedItems);
    }

    var sharedItems = new ArrayList<String>();
    for (ArrayList<String> contents : sortedGroups) {
      var first = contents.get(0);
      var second = contents.get(1);
      var third = contents.get(2);

      String sharedFirstSecond = getDuplicatedItems(first, second);
      String shared = getDuplicatedItems(sharedFirstSecond, third);

      sharedItems.add(shared);
    }

    var res = 0;
    for (String s : sharedItems) {
      res += calculatePriority(s.charAt(0));
    }
    return res;
  }

  private String getDuplicatedItems(String first, String second) {
    var shared = new HashSet<String>();
    var i = 0;
    var j = 0;
    while (i < first.length() && j < second.length()) {
      if (first.charAt(i) == second.charAt(j)) {
        shared.add(Character.toString(first.charAt(i)));
        i += 1;
      } else if (first.charAt(i) < second.charAt(j)) {
        i += 1;
      } else {
        j += 1;
      }
    }
    var str = new StringBuilder();
    for (String s : shared) {
      str.append(s);
    }
    String s = str.toString();
    char[] chars = s.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }

  private int calculatePriority(char character) {
    if (character >= 'a' && character <= 'z') {
      return character - 'a' + 1;
    }
    return character - 'A' + 27;
  }
}
