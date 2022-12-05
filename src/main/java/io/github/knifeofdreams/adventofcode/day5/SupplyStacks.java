package io.github.knifeofdreams.adventofcode.day5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SupplyStacks {

  public String rearrange(ArrayList<ArrayList<String>> stacks, List<List<Integer>> moves) {
    for (List<Integer> move : moves) {
      var pieces = move.get(0);
      var from = move.get(1);
      var to = move.get(2);

      var s = "";
      for (int i = 0; i < pieces; i++) {
        s += stacks.get(from - 1).remove(stacks.get(from - 1).size() - 1);
      }

      for (int i = 0; i < s.length(); i++) {
        stacks.get(to - 1).add(Character.toString(s.charAt(i)));
      }
    }

    var res = "";
    for (ArrayList<String> box : stacks) {
      res += box.get(box.size() - 1);
    }
    return res;
  }


  public String rearrangeImproved(ArrayList<ArrayList<String>> stacks, List<List<Integer>> moves) {
    for (List<Integer> move : moves) {
      var pieces = move.get(0);
      var from = move.get(1);
      var to = move.get(2);

      var tmp = new ArrayList<String>();
      for (int i = 0; i < pieces; i++) {
        tmp.add(stacks.get(from - 1).remove(stacks.get(from - 1).size() - 1));
      }

      Collections.reverse(tmp);

      for (int i = 0; i < tmp.size(); i++) {
        stacks.get(to - 1).add(tmp.get(i));
      }
    }

    var res = "";
    for (ArrayList<String> box : stacks) {
      res += box.get(box.size() - 1);
    }
    return res;
  }
}
