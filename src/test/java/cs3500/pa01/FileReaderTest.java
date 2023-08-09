package cs3500.pa01;

import static java.nio.file.FileVisitResult.CONTINUE;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileReaderTest {
  FileReader fr;

  /**
   * Set up the FileReader object.
   */
  @BeforeEach
  public void setup() {
    fr = new FileReader();
  }

  /**
   * Test the preVisitDirectory method.
   */
  @Test
  void preVisitDirectory() throws IOException {
    Path path = Paths.get("test2/");
    BasicFileAttributes bf = Files.readAttributes(path, BasicFileAttributes.class);
    assertEquals(CONTINUE, fr.preVisitDirectory(path, bf));
  }

  /**
   * Test the visitFile method.
   */
  @Test
  void visitFile() throws IOException {
    Path path = Paths.get("test2/");
    Path path2 = Paths.get("test2/test1.md");
    BasicFileAttributes bf = Files.readAttributes(path, BasicFileAttributes.class);
    Files.walkFileTree(path, fr);
    Files.walkFileTree(path2, fr);
    assertEquals(CONTINUE, fr.preVisitDirectory(path, bf));
    assertEquals(CONTINUE, fr.visitFile(path2, bf));
  }

  /**
   * Test the visitFileFailed method.
   */
  @Test
  void visitFileFailed() throws IOException {
    assertEquals(CONTINUE, fr.visitFileFailed(Paths.get("test2/"), new IOException()));
  }

  /**
   * Test the postVisitDirectory method.
   */
  @Test
  void postVisitDirectory() throws IOException {
    assertEquals(CONTINUE, fr.postVisitDirectory(Paths.get("test2/"), new IOException()));
  }

}