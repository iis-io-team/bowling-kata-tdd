package edu.se.bowling;

public class Game {

	private int currentRoll = 0;
	private int[] rolls = new int[21];

	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}

	public int score() {
		int score = 0;
		for (int rollIdx = 0; rollIdx < rolls.length; rollIdx++) {
			score += rolls[rollIdx];
		}
		return score;
	}

}
