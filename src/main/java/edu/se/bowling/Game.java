package edu.se.bowling;

public class Game {

	private static final int NUMBER_OF_FRAMES = 10;
	private static final int MAX_NUMBER_OF_ROLLS = 21;
	private static final int NUMBER_OF_PINS = 10;
	private int[] rolls = new int[MAX_NUMBER_OF_ROLLS];
	private int currentRoll = 0;

	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}

	public int score() {
		int score = 0;
		int rollIdx = 0;
		for (int frameIdx = 0; frameIdx < NUMBER_OF_FRAMES; frameIdx++) {
			if (isSpare(rollIdx)) {
				score += spareBonus(rollIdx);
			}
			score += rolls[rollIdx] + rolls[rollIdx + 1];
			rollIdx += 2;
		}
		return score;
	}

	private int spareBonus(int frameRollIdx) {
		return rolls[frameRollIdx + 2];
	}

	private boolean isSpare(int frameRollIdx) {
		return rolls[frameRollIdx] + rolls[frameRollIdx + 1] == NUMBER_OF_PINS;
	}

}
