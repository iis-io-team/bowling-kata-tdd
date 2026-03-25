package edu.se.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {

	@BeforeEach
	public void setUp() throws Exception {
	}

	@Test
	public void gutterGameScoresZero() {
		Game g = new Game();
		for (int i = 0; i < 20; i++) {
			g.roll(0);
		}
		assertEquals(0, g.score());
	}

	@Test
	public void allOneGameScoresTwenty() {
		Game g = new Game();
		for (int i = 0; i < 20; i++) {
			g.roll(1);
		}
		assertEquals(20, g.score());
	}

}
