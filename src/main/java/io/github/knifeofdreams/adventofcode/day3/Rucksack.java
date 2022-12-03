package io.github.knifeofdreams.adventofcode.day3;

import java.util.Arrays;
import java.util.List;

public class Rucksack {

  public int sumOfPriorities(List<String> items) {
    return items.stream()
        .map(this::findDuplicateItem)
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
      } else if (leftCompartment[l] < rightCompartment[r]) {
        l += 1;
      } else {
        r += 1;
      }
    }
    throw new IllegalArgumentException("No duplicate charecters in string");
  }

  private int calculatePriority(Character character) {
    if (character >= 'a' && character <= 'z') {
      return character - 'a' + 1;
    }
    return character - 'A' + 27;
  }
}
