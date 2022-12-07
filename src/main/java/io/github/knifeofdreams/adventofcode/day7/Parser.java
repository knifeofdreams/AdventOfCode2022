package io.github.knifeofdreams.adventofcode.day7;

import java.util.List;
import java.util.Set;

public class Parser {

  public int sumOfAllsizes(Node rootNode) {
    return 0;
  }

  static class Node {

    public int size;
    public String value;
    public Node parent;
    public Set<Node> children;

    public Node(int size, String value, Node parent, Set<Node> children) {
      this.size = size;
      this.value = value;
      this.parent = parent;
      this.children = children;
    }
  }
}

