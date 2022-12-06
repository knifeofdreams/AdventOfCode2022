package io.github.knifeofdreams.adventofcode.day6;

import java.util.HashSet;
import java.util.LinkedList;

public class Device {

  public int charsBeforeMarker(String datastreamBuffer, int packetLength) {
    var window = new LinkedList<>();
    for (int i = 0; i < packetLength; i++) {
      window.add(datastreamBuffer.charAt(i));
    }

    for (int i = packetLength; i < datastreamBuffer.length(); i++) {
      if (new HashSet<>(window).size() == window.size()) {
        return i;
      }

      window.removeFirst();
      window.addLast(datastreamBuffer.charAt(i));
    }
    throw new IllegalStateException("No marker found in " + datastreamBuffer);
  }
}
