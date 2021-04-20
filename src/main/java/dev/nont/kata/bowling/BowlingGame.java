package dev.nont.kata.bowling;

public class BowlingGame {

    public static final char MISSED = '-';
    private final String result;
    private final char SPARE = '/';
    private final char STRIKE = 'X';

    public BowlingGame(String result) {
        this.result = result;
    }

    public int getScore() {
        var total = 0;
        char[] scores = result.toCharArray();
        for (int i = 0; i < scores.length ; i++) {
            total += calculateCurrentThrow(i, scores);
            total += calculateBonus(i, scores);
            if (isAtLastRound(i, scores)) {
                break;
            }
        }
        return total;
    }

    private int calculateBonus(int index, char[] input) {
        switch (input[index]) {
            case SPARE:
                return calculateCurrentThrow(index + 1, input);
            case STRIKE:
                return calculateCurrentThrow(index + 1, input) + calculateCurrentThrow(index + 2, input);
        }
        return 0;
    }

    private boolean isAtLastRound(int index, char[] input) {
        switch (input[index]) {
            case SPARE:
                return index + 2 == input.length;
            case STRIKE:
                return index + 3 == input.length;
            default:
                return index == input.length - 1;
        }
    }

    private int calculateCurrentThrow(int index, char[] input) {
        switch (input[index]) {
            case SPARE:
                return 10 - calculateCurrentThrow(index - 1, input);
            case STRIKE:
                return 10;
            case MISSED:
                return 0;
            default:
                return Character.getNumericValue(input[index]);
        }
    }
}