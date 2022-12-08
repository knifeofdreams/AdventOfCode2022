package io.github.knifeofdreams.adventofcode.day7;

import static io.github.knifeofdreams.adventofcode.day7.Parser.Type.*;

import java.util.ArrayList;
import java.util.Set;

public class Parser {

  public long sumOfAllsizes(Node node) {
    var visited = new ArrayList<>();
    var stack = new ArrayList<Node>();
    stack.add(node);
    var sum = 0L;

    while (!stack.isEmpty()) {
      var n = stack.remove(stack.size() - 1);
      if (n.type == FOLDER && n.getSize() < 100000) {
        sum += n.getSize();
      }
      System.out.println("node: " + n.size + " " + n.name);
      visited.add(n);

      if (n.type == FILE || n.children == null) {
        continue;
      }
      for (Node c : n.children) {
        if (!visited.contains(c)) {
          stack.add(c);
        }
      }
    }
    return sum;
  }

  static class Node {

    public int size;
    public String name;
    public Node parent;
    public Type type;
    public Set<Node> children;

    public Node(int size, String name, Node parent, Type type, Set<Node> children) {
      this.size = size;
      this.name = name;
      this.parent = parent;
      this.type = type;
      this.children = children;
    }

    public int getSize() {
      if (type == FILE) {
        return size;
      }
      return children.stream().mapToInt(Node::getSize).sum();
    }
  }

  enum Type {
    FILE,
    FOLDER
  }
}
