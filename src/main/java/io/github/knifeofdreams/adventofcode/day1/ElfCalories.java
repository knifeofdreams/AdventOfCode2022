package io.github.knifeofdreams.adventofcode.day1;

import java.util.Comparator;
import java.util.List;

public class ElfCalories {

  public int maxCalorieCount(List<List<Integer>> calories) {
    return calories
        .stream()
        .mapToInt(c -> c.stream().reduce(0, Integer::sum))
        .max()
        .getAsInt();
  }

  public int sumOfTopThree(List<List<Integer>> calories) {
    return calories
        .stream()
        .map(c -> c.stream().reduce(0, Integer::sum))
        .sorted(Comparator.reverseOrder())
        .limit(3)
        .reduce(0, Integer::sum);
  }

}
