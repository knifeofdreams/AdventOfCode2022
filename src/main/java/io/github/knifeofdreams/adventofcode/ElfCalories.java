package io.github.knifeofdreams.adventofcode;

import java.util.List;

public class ElfCalories {

  public int maxCalorieCount(List<List<Integer>> calories) {
    return calories
        .stream()
        .map(c -> c.stream().reduce(0, Integer::sum))
        .max(Integer::compare)
        .get();
  }

}
