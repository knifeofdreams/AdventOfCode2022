package io.github.knifeofdreams.adventofcode.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RucksackTest {
  public static final List<String> EXAMPLE_ITEMS =
      List.of(
          "vJrwpWtwJgWrhcsFMMfFFhFp",
          "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
          "PmmdzqPrVvPwwTWBwg",
          "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
          "ttgJtRGJQctTZtZT",
          "CrZsJsPPZsGzwwsLwLmpwMDw");
  public static final List<String> ITEMS = readInput();
  private Rucksack rucksack = new Rucksack();

  @Nested
  class DuplicateRucksackItemPriorities {

    @Test
    public void returnsSumOfPriorities() {
      assertEquals(157, rucksack.sumOfPriorities(EXAMPLE_ITEMS));
    }

    @Test
    public void returnsSumOfPrioritiesForMyInput() {
      assertEquals(8202, rucksack.sumOfPriorities(ITEMS));
    }
  }

  @Nested
  class GroupBadges {
    @Test
    public void sumsBadgePrioritiesForGroups() {
      assertEquals(70, rucksack.groupBadgePriorities(EXAMPLE_ITEMS));
    }

    @Test
    public void sumsBadgePrioritiesForGroupsForMyInput() {
      assertEquals(2864, rucksack.groupBadgePriorities(ITEMS));
    }
  }

  private static List<String> readInput() {
    try {
      return Files.readAllLines(
          Path.of(ClassLoader.getSystemResource("day3/day3-input.txt").toURI()));
    } catch (Exception e) {
      e.printStackTrace();
      throw new IllegalStateException("Cannot read input");
    }
  }
}
