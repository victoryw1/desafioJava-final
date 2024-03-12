package br.com.biblioteca;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MainServerTests {

	@Test
	void contextLoads() {
		MainServer.main(new String[] {});
		assertTrue(true);
	}

}
