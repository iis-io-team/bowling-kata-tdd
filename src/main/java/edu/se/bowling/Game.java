package edu.se.bowling;

public class Game {

	private int[] rolls = new int[21];
	private int currentRoll = 0;

	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}

	public int score() {
		int score = 0;
		int rollIdx = 0;
		for (int frameIdx = 0; frameIdx < 10; frameIdx++) {
			score += rolls[rollIdx] + rolls[rollIdx + 1];
			rollIdx += 2;
		}
		return score;
	}

}
