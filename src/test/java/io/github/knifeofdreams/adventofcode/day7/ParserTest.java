package io.github.knifeofdreams.adventofcode.day7;

import static io.github.knifeofdreams.adventofcode.day7.Parser.Type.FILE;
import static io.github.knifeofdreams.adventofcode.day7.Parser.Type.FOLDER;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.knifeofdreams.adventofcode.day7.Parser.Node;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

class ParserTest {

  @Test
  public void sumOfTotalSizes() {
    var rootNode =
        createTree(
            List.of(
                //        "$ cd /",
                //                "$ ls",
                //                "dir a",
                "14848514 b.txt",
                "8504156 c.dat",
                //                "dir d",
                "$ cd a",
                //                "$ ls",
                //                "dir e",
                "29116 f",
                "2557 g",
                "62596 h.lst",
                "$ cd e",
                //                "$ ls",
                "584 i",
                "$ cd ..",
                "$ cd ..",
                "$ cd d",
                //                "$ ls",
                "4060174 j",
                "8033020 d.log",
                "5626152 d.ext",
                "7214296 k"));
    var parser = new Parser();
    assertEquals(95437, parser.sumOfAllsizes(rootNode));
  }

  private Node createTree(List<String> commands) {
    Node root = new Node(0, "/", null, FOLDER, new HashSet<>());
    Node node = root;
    Pattern cdFolder = Pattern.compile("\\$ cd ([a-zA-Z]+)");
    Pattern cdUp = Pattern.compile("\\$ cd \\.\\.");
    Pattern filePattern = Pattern.compile("(\\d+) (.*)");
    var x = new ArrayList<>();

    for (String command : commands) {
      var folderMatcher = cdFolder.matcher(command);
      var upMatcher = cdUp.matcher(command);
      var fileMatcher = filePattern.matcher(command);
      if (folderMatcher.matches()) {
        var tmp = new Node(0, folderMatcher.group(1), null, FOLDER, new HashSet<>());
        node.children.add(tmp);
        tmp.parent = node;
        node = tmp;
        x.add(node);
      } else if (upMatcher.matches()) {
        node = node.parent;
      } else if (fileMatcher.matches()) {
        var size = Integer.parseInt(fileMatcher.group(1));
        var name = fileMatcher.group(2);
        var tmp = new Node(size, name, node, FILE, new HashSet<>());
        node.children.add(tmp);
        tmp.parent = node;
        //        node = tmp;
        x.add(node);
      } else {
        throw new IllegalStateException("Could not parse command: " + command);
      }
    }

    return root;
  }
}
