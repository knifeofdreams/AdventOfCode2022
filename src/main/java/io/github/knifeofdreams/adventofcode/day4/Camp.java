package io.github.knifeofdreams.adventofcode.day4;

import java.util.List;

public class Camp {

  public long numberOfOverlaps(List<List<Section>> pairs) {
    return pairs.stream()
        .map(pair -> {
          var section1 = pair.get(0);
          var section2 = pair.get(1);

          return ((section1.beginning <= section2.beginning) && (section1.end >= section2.end))
              || ((section2.beginning <= section1.beginning) && (section2.end >= section1.end));
        })
        .filter(overlaps -> overlaps)
        .count();
  }

  record Section(int beginning, int end) {}
}
