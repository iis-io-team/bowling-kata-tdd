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
	public void allOneGameScoresTwenty() {
		rollMany(20, 1);
		assertEquals(20, g.score());
	}

	@Test
	public void spareScoresBonusNextRoll() {
		rollSpare();
		g.roll(3);
		rollMany(17, 0);
		assertEquals(16, g.score());
	}

	@Test
	public void strikeScoresBonusTwoNextRolls() {
		g.roll(10); //strike
		g.roll(4);
		g.roll(3);
		rollMany(16, 0);
		assertEquals(24, g.score());
	}

	private void rollSpare() {
		g.roll(5);
		g.roll(5);
	}

	private void rollMany(int rolls, int pins) {
		for (int i = 0; i < rolls; i++) {
			g.roll(pins);
		}
	}
}
