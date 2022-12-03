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
    var group = new ArrayList<String>();
    for (String item : items) {
      if (group.size() < 3) {
        group.add(item);
      }
      else {
        groups.add(group);
        group = new ArrayList<>();
      }
    }

    return groups.stream()
        .map(g -> {
          var first = new char[g.get(0).length()];
          var second = new char[g.get(1).length()];
          var third = new char[g.get(2).length()];
          g.get(0).getChars(0, g.get(0).length(), first, 0);
          g.get(1).getChars(0, g.get(1).length(), second, 0);
          g.get(2).getChars(0, g.get(2).length(), third, 0);
          Arrays.sort(first);
          Arrays.sort(second);
          Arrays.sort(third);

          int f = 0;
          int s = 0;
          int t = 0;
          while (f < first.length || s < second.length || t < third.length) {
            if (first[f] == second[s] && second[s] == third[t]) {
              return first[f];
            }
            else if (first[f] < second[s] && first[f] < third[t]) {
              f += 1;
            }
            else if (second[s] < first[f] && second[s] < third[t]) {
              s += 1;
            }
            else {
              t += 1;
            }
          }
          throw new IllegalArgumentException("No shared character in group");
        })
        .mapToInt(this::calculatePriority)
        .sum();
  }

  private char findDuplicateItem(String item) {
    var rightCompartment = new char[item.length() / 2];
    var leftCompartment = new char[item.length() / 2];
    item.getChars(0, item.length() / 2, rightCompartment, 0);
    item.getChars(item.length() / 2, item.length(), leftCompartment, 0);
    Arrays.sort(rightCompartment);
    Arrays.sort(leftCompartment);

    int l = 0;
    int r = 0;
    while (l < leftCompartment.length || r < rightCompartment.length) {
      if (leftCompartment[l] == rightCompartment[r]) {
        return leftCompartment[l];
      }
      else if (leftCompartment[l] < rightCompartment[r]) {
        l += 1;
      }
      else {
        r += 1;
      }
    }
    throw new IllegalArgumentException("No duplicate characters in string");
  }

  private int calculatePriority(char character) {
    if (character >= 'a' && character <= 'z') {
      return character - 'a' + 1;
    }
    return character - 'A' + 27;
  }
}
