package cs3500.pa01;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * A class that sorts all files
 */
public class Sort {

  /**
   * @param data  - Alphabetizes the file names
   * @return - Alphabetized file names
   */
  public ArrayList<String> fileNames(ArrayList<String> data) {
    Collections.sort(data);
    return data;
  }

  /**
     * @param data - Sorts files based on creation of data
     * @return - outputs sorted Array list based on creation date
     */
  public ArrayList<String> createdDate(ArrayList<String> data) {

    Collections.sort(data, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        File file1 = new File(o1);
        File file2 = new File(o2);
        try {
          BasicFileAttributes attr1 =
              Files.readAttributes(Paths.get(o1), BasicFileAttributes.class);
          BasicFileAttributes attr2 =
              Files.readAttributes(Paths.get(o2), BasicFileAttributes.class);
          return attr1.creationTime().compareTo(attr2.creationTime());
        } catch (IOException e) {
          e.printStackTrace();
        }
        return 0;
      }
    });
    return data;
  }

  /**
   * @param data - Sorts files based on last modified date
   * @return - outputs sorted Array list based on last modified date
   */
  public ArrayList<String> modifiedDate(ArrayList<String> data) {
    Collections.sort(data, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        File file1 = new File(o1);
        File file2 = new File(o2);
        return Long.compare(file1.lastModified(), file2.lastModified());
      }
    });
    return data;
  }
}
