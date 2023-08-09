package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

class DriverTest {

  @Test
  public void mainTest() throws IOException {
    Driver d = new Driver();
    String[] args = {"testSample/", "createdDate", "output.txt"};
    String[] args2 = {"testSample/", "fileNames", "output.txt"};
    String[] args3 = {"testSample/", "modifiedDate", "output.md"};
    d.main(args);
    d.main(args2);
    d.main(args3);
    Path p = Paths.get("testSample/output.md");
    Files.exists(p);
  }

}