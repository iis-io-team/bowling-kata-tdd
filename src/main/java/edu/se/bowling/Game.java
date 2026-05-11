package edu.se.bowling;

public class Game {
	
	private static final int MAX_NUMBER_OF_ROLLS = 21;
	private static final int NUMBER_OF_PINS = 10;
	private static final int NUMBER_OF_FRAMES = 10;
	private int[] rolls = new int[MAX_NUMBER_OF_ROLLS];
	private int currentRoll = 0;

	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}

	public int score() {
		int score = 0;
		int i = 0;
		for (int frame = 0; frame < NUMBER_OF_FRAMES; frame++) {
			if (isStrike(i)) {
				score += NUMBER_OF_PINS + strikeBonus(i);
				i += 1;
			} else if (isSpare(i)) {
				score += NUMBER_OF_PINS + spareBonus(i);
				i += 2;
			} else {
				score += rolls[i] + rolls[i + 1];
				i += 2;
			}
		}
		return score;
	}

	private boolean isStrike(int firstRollInFrameIdx) {
		return rolls[firstRollInFrameIdx] == NUMBER_OF_PINS;
	}

	private int strikeBonus(int firstRollInFrameIdx) {
		return rolls[firstRollInFrameIdx + 1] + rolls[firstRollInFrameIdx + 2];
	}
	
	private boolean isSpare(int firstRollInFrameIdx) {
		return rolls[firstRollInFrameIdx] + rolls[firstRollInFrameIdx + 1] == NUMBER_OF_PINS;
	}

	private int spareBonus(int firstRollInFrameIdx) {
		return rolls[firstRollInFrameIdx + 2];
	}
	
}
