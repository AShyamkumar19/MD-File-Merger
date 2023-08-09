package cs3500.pa01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is for reading and writing files.
 */
public class writeFile {

  /**
   * @param files - all files are read and appended together
   * @return - returns a String with all the contents of the files merged
   */
  public String readFromFile(ArrayList<String> files) {
    Scanner s;
    StringBuilder sb = new StringBuilder();
    for (String file : files) {
      try {
        s = new Scanner(new File(file));
        while (s.hasNextLine()) {
          String line = s.nextLine();
          if (line.contains("#")) {
            sb.append(line).append("\n");
          }
          if (line.contains("[[")) {
            int startIndex = line.indexOf("[[");
            int endIndex = line.indexOf("]]");
            String result = line.substring(startIndex + 2, endIndex);
            sb.append("- ").append(result).append(" ");
          }
          sb.append("\n");
        }
        s.close();
      } catch (FileNotFoundException e) {
        throw new IllegalArgumentException(e);
      }
    }
    return sb.toString();
  }

  /**
   *
   * @param path - the path to where to write the file
   * @param contents - the contents to write to the file
   */
  public void writeToFile(String path, String contents) {
    try {
      FileWriter fw = new FileWriter(path);
      fw.write(contents);
      fw.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
