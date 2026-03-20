package edu.se.bowling;

public class Game {

	private static final int NUMBER_OF_PINS = 10;
	private static final int NUMBER_OF_FRAMES = 10;
	private static final int MAX_NUMBER_OF_ROLLS = 21;
	
	private int currentRoll = 0;
	private int[] rolls = new int[MAX_NUMBER_OF_ROLLS];

	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}

	public int score() {
		int score = 0;
		int rollIdx = 0;
		for (int frame = 0; frame < NUMBER_OF_FRAMES; frame++) {
			score += rolls[rollIdx] + rolls[rollIdx + 1];
			if (isSpare(rollIdx))
				score += spareBonus(rollIdx);
			rollIdx += 2;
		}
		return score;
	}

	private boolean isSpare(int rollIdx) {
		return rolls[rollIdx] + rolls[rollIdx + 1] == NUMBER_OF_PINS;
	}

	private int spareBonus(int rollIdx) {
		return rolls[rollIdx + 2];
	}	
}
