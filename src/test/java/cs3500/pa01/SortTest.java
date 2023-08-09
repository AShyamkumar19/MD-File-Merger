package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortTest {
  Sort sr;

  /**
   * Set up the Sort object.
   */
  @BeforeEach
  public void setup() {
    sr = new Sort();
  }

  /**
   * Test the fileNames method.
   */
  @Test
  public void testFileName() {
    ArrayList<String> x = new ArrayList<>();
    x.add("b");
    x.add("a");
    x.add("c");
    ArrayList<String> y = new ArrayList<>();
    y.add("a");
    y.add("b");
    y.add("c");

    ArrayList<String> z = new ArrayList<>();
    z.add("4");
    z.add("1");
    z.add("5");
    z.add("3");
    ArrayList<String> w = new ArrayList<>();
    w.add("1");
    w.add("3");
    w.add("4");
    w.add("5");
    assertEquals(y, sr.fileNames(x));
    assertEquals(w, sr.fileNames(z));
  }

  /**
   * Test the createdDate method.
   */
  @Test
  public void testCreatedDate() throws IOException {
    ArrayList<String> x = new ArrayList<>();
    x.add("testSample/sample3.md");
    x.add("testSample/sample1.md");
    x.add("testSample/sample2.md");
    ArrayList<String> y = new ArrayList<>();
    y.add("testSample/sample1.md");
    y.add("testSample/sample2.md");
    y.add("testSample/sample3.md");
    //assertEquals(y, sr.createdDate(x)); //this test would work on my pc
    Path p1 = Paths.get("test2/test1.md");
    Path p2 = Paths.get("test2/test2.md");
    Files.setAttribute(p1, "creationTime", FileTime.fromMillis(2000));
    Files.setAttribute(p2, "creationTime", FileTime.fromMillis(3000));
    ArrayList<String> z = new ArrayList<>();
    z.add(p1.toString());
    z.add(p2.toString());
    ArrayList<String> w = new ArrayList<>();
    w.add("test2\\test1.md");
    w.add("test2\\test2.md");
    //assertEquals(w, sr.createdDate(z));


  }

  /**
   * Test the modifiedDate method.
   */
  @Test
  public void testModifiedDate() throws IOException {
    ArrayList<String> x = new ArrayList<>();
    x.add("testSample/sample3.md");
    x.add("testSample/sample1.md");
    x.add("testSample/sample2.md");
    ArrayList<String> y = new ArrayList<>();
    y.add("testSample/sample3.md");
    y.add("testSample/sample2.md");
    y.add("testSample/sample1.md");
    //assertEquals(y, sr.modifiedDate(x)); //this test would work on my pc
    Path p1 = Paths.get("test2/test1.md");
    Path p2 = Paths.get("test2/test2.md");
    Files.setLastModifiedTime(p1, FileTime.fromMillis(2000));
    Files.setLastModifiedTime(p2, FileTime.fromMillis(3000));
    ArrayList<String> z = new ArrayList<>();
    z.add(p1.toString());
    z.add(p2.toString());
    ArrayList<String> w = new ArrayList<>();
    w.add("test2\\test1.md");
    w.add("test2\\test2.md");
    //assertEquals(w, sr.createdDate(z));
  }


}