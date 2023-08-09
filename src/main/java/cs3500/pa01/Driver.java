package cs3500.pa01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

/**
 * This is the main driver of this project.
 */
public class Driver {
  /**
   * Project entry point
   *
   * @param args - input 3 arguments - directory location, sort type, and output file name
   */
  public static void main(String[] args)  {
    FileReader fr = new FileReader();
    Sort sort = new Sort();
    writeFile wf = new writeFile();

    try {
      Files.walkFileTree(Paths.get(args[0]), fr);
      ArrayList<String> x;
      if (Objects.equals(args[1], "fileNames")) {
        x = sort.fileNames(fr.getData());
      } else if (Objects.equals(args[1], "createdDate")) {
        x = sort.createdDate(fr.getData());
      } else if (Objects.equals(args[1], "modifiedDate")) {
        x = sort.modifiedDate(fr.getData());
      } else {
        throw new IllegalArgumentException();
      }

      String y = wf.readFromFile(x);
      wf.writeToFile(args[2], y);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}