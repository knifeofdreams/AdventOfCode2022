package io.github.knifeofdreams.adventofcode.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

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

  public int groupBadgePriorities(List<String> contents) {
    List<List<String>> groups = groupByThree(contents);

    return groups.stream()
        .map(group -> group.stream()
            .map(this::sortString)
            .collect(Collectors.toList()))
        .map(group -> {
            var first = group.get(0);
            var second = group.get(1);
            var third = group.get(2);

            String sharedFirstSecond = getDuplicatedItems(first, second);
            String shared = getDuplicatedItems(sharedFirstSecond, third);

            return shared;
        })
        .map(sharedItem -> sharedItem.charAt(0))
        .mapToInt(this::calculatePriority)
        .sum();
  }

  private List<List<String>> groupByThree(List<String> items) {
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
    return groups;
  }

  private String sortString(String contents) {
    char[] chars = contents.toCharArray();
    Arrays.sort(chars);
    String sortedString = new String(chars);
    return sortedString;
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
