package io.github.knifeofdreams.adventofcode.day7;

import java.util.Set;

public class Parser {

  public int sumOfAllsizes(Node node) {
    if (node == null) {
      return 0;
    }
    var sum = 0;
    for (Node child : node.children) {
      sum += sumOfAllsizes(child);
    }
    return node.size + sum;
  }

  static class Node {

    public int size;
    public String name;
    public Node parent;
    private final Type type;
    public Set<Node> children;

    public Node(int size, String name, Node parent, Type type, Set<Node> children) {
      this.size = size;
      this.name = name;
      this.parent = parent;
      this.type = type;
      this.children = children;
    }
  }

  enum Type {FILE, FOLDER}

}

