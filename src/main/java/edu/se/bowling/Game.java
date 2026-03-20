package edu.se.bowling;

public class Game {

	private int currentRoll = 0;
	private int[] rolls = new int[21];

	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}

	public int score() {
		int score = 0;
		int rollIdx = 0;
		for (int frame = 0; frame < 10; frame++) {
			score += rolls[rollIdx] + rolls[rollIdx + 1];
			if (rolls[rollIdx] + rolls[rollIdx + 1] == 10) //spare
				score += rolls[rollIdx + 2];
			rollIdx += 2;
		}
		return score;
	}

}
