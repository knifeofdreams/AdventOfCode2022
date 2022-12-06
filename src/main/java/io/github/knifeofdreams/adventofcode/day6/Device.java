package io.github.knifeofdreams.adventofcode.day6;

import java.util.ArrayList;
import java.util.HashSet;

public class Device {

  public int charsBeforeMarker(String datastreamBuffer) {
    var window = new ArrayList<String>();

    for (int i = 0; i < datastreamBuffer.length(); i++) {
      String c = String.valueOf(datastreamBuffer.charAt(i));
      if (window.size() < 4) {
        window.add(c);
      }
      else {
        if (new HashSet<String>(window).size() == window.size()) {
          return i;
        }
        else {
          window.remove(0);
          window.add(c);
        }

      }
    }
    throw new IllegalStateException("No marker found in " + datastreamBuffer);
  }
}