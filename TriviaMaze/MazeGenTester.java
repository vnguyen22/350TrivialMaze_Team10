import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MazeGenTester {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testMazeGeneration() {
		//this is intended to assure that the maze entrance 
		//and exit will never overlap we cannot test infinitely so we are testing 10000 random mazes
		int flag = 0;
		int i = 10000;
		
		while(i > 0) {
			Maze m = new Maze(10, 10);
			if(m.getEntranceX() == m.getExitX() && m.getEntranceY() == m.getExitY()) {
				flag = 1;
			}
			i--;
		}
		assertEquals(0, flag);
	}
	@Test 
	void testMazeTooLarge(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Maze maze = new Maze(20, 20);
		});
	}
	@Test 
	void testMazeTooSmall(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Maze maze = new Maze(0, 0);
		});
	}

}
