package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testWriteFile {
  writeFile wf;

  /**
   * Set up the writeFile object.
   */
  @BeforeEach
  public void setup() {
    wf = new writeFile();
  }

  /**
   * Test the readFromFile method.
   */
  @Test
  public void readFromFile() {
    ArrayList<String> x = new ArrayList<>();
    x.add("test2/test1.md");
    String y = "\n";
    assertEquals(y, wf.readFromFile(x));
    ArrayList<String> z = new ArrayList<>();
    z.add("test2/test2.md");
    String w = "# test 2\n\n";
    assertEquals(w, wf.readFromFile(z));
    ArrayList<String> a = new ArrayList<>();
    a.add("test2/test3.md");
    String b = "- test \n";
    assertEquals(b, wf.readFromFile(a));
  }

  /**
  * Test the writeToFile method.
  */
  @Test
  public void writeToFile() {

  }
}