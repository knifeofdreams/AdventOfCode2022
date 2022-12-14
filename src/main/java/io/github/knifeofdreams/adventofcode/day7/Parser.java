package io.github.knifeofdreams.adventofcode.day7;

import static io.github.knifeofdreams.adventofcode.day7.Parser.Type.*;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public class Parser {

  public long sumOfAllsizes(Node node) {
    var sum = 0L;
    var visited = new ArrayList<>();
    var stack = new ArrayList<Node>();
    stack.add(node);

    while (!stack.isEmpty()) {
      var n = stack.remove(stack.size() - 1);
      if (n.type == FOLDER && n.getSize() <= 100000) {
        sum += n.getSize();
      }
      System.out.println(n);
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

  public int folderToDelete(Node node) {
    var root = node;
    var sum = 0L;
    var visited = new ArrayList<Node>();
    var stack = new ArrayList<Node>();
    stack.add(node);

    while (!stack.isEmpty()) {
      var n = stack.remove(stack.size() - 1);
      if (n.type == FOLDER && n.getSize() <= 100000) {
        sum += n.getSize();
      }
      System.out.println(n);
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
    var targetSize = 30000000 - (70000000 - root.getSize());
    return visited.stream()
        .filter(n -> (n.type == FOLDER))
        .filter(n -> n.getSize() >= targetSize)
        .map(n -> n.getSize())
        .min(Integer::compare)
        .get();
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

    public String toString() {
      var builder = new StringBuilder();
      var tmp = parent;
      while (tmp != null) {
        builder.insert(0,"/")
            .insert(0, tmp.name);
        tmp = tmp.parent;
      }
      builder.append(name)
          .append(" ")
          .append(getSize());
      return builder.toString();
    }
  }

  enum Type {
    FILE,
    FOLDER
  }
}
