package Testers;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class IndexTester {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Path p = Paths.get("junit.txt");
        try {
            Files.writeString(p, "Will Tester", StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		File f = new File("junit.txt");
		f.delete();
	}

	@Test
	void testInit() throws IOException {
		Index g = new Index();
		g.initialize();
		
		File file = new File("index.txt");
		assertTrue(file.exists());
		
		Path path  = Paths.get("objects");
		assertTrue(Files.exists(path));
		
	}
	
	@Test
	void testAdd() throws IOException, NoSuchAlgorithmException {
		Index i = new Index();
		i.add("junit.txt");
		File file = new File("objects/b34bcfc4d490f93ed9cf4e560c608b58cd688c24");
		assertTrue(file.exists());
	}
	
	
	@Test
	void testRemove() throws NoSuchAlgorithmException, IOException {
		Index i = new Index();
		i.remove("junit.txt");
		File file = new File("objects/b34bcfc4d490f93ed9cf4e560c608b58cd688c24");
		assertTrue(file.exists());
	}

}
