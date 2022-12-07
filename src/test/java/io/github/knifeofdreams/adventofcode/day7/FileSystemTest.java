package io.github.knifeofdreams.adventofcode.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.knifeofdreams.adventofcode.day7.Parser.Node;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

class FileSystemTest {

  @Test
  public void sumOfTotalSizes() {
    var rootNode =
        createTree(
            List.of(
                //        "$ cd /",
                "$ ls",
                "dir a",
                "14848514 b.txt",
                "8504156 c.dat",
                "dir d",
                "$ cd a",
                "$ ls",
                "dir e",
                "29116 f",
                "2557 g",
                "62596 h.lst",
                "$ cd e",
                "$ ls",
                "584 i",
                "$ cd ..",
                "$ cd ..",
                "$ cd d",
                "$ ls",
                "4060174 j",
                "8033020 d.log",
                "5626152 d.ext",
                "7214296 k"));
    var parser = new Parser();
    assertEquals(95437, parser.sumOfAllsizes(rootNode));
  }

  private Node createTree(List<String> commands) {
    Node root = new Node(0, "/", null, new HashSet<>());
    Node node = root;
    //    Pattern cdFolder = Pattern.compile("\\$ cd (.*)");
    Pattern cdFolder = Pattern.compile("\\$ cd ([a-zA-Z]+)");
    Pattern cdUp = Pattern.compile("\\$ cd \\.\\.");
    var x = new ArrayList<>();

    for (String command : commands) {
      var folderMatcher = cdFolder.matcher(command);
      var upMatcher = cdUp.matcher(command);
      if (folderMatcher.matches()) {
        var tmp = new Node(0, folderMatcher.group(1), null, new HashSet<>());
        node.children.add(tmp);
        tmp.parent = node;
        node = tmp;
        x.add(node);
      }
      else if (upMatcher.matches()) {
        node = node.parent;
      }
    }

    return root;
  }
}
