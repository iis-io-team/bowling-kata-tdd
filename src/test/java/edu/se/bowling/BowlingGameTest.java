package edu.se.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {

	private Game g;

	@BeforeEach
	public void setUp() throws Exception {
		g = new Game();
	}

	@Test
	public void gutterGameScoresZero() {
		rollMany(20, 0);
		assertEquals(0, g.score());
	}
	
	@Test
	public void allOnesGameScoresTwenty() {
		rollMany(20, 1);
		assertEquals(20, g.score());
	}
	
	@Test
	public void oneSpareAddsNextRollAsBonus() {
		g.roll(5);
		g.roll(5); //spare
		g.roll(3);
		rollMany(17, 0);
		assertEquals(16, g.score());
	}
	
	private void rollMany(int n, int pins) {
		for (int i = 0; i < n; i++) {
			g.roll(pins);
		}
	}
}
