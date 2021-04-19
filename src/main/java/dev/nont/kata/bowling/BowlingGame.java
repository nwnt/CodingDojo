package dev.nont.kata.bowling;

public class BowlingGame {

    private final String result;

    public BowlingGame(String result) {
        this.result = result;
    }

    public int getScore() {
        var total = 0;
        char[] scores = result.toCharArray();
        boolean lastRound = false;
        for (int i = 0; i < scores.length ; i++) {
            switch (scores[i]) {
                case '/':
                    total -= valueOf(scores[i - 1]);
                    total += 10 + valueOf(scores[i + 1]);
                    lastRound = i + 2 == scores.length;
                    break;
                case 'X':
                    total += 10 + valueOf(scores[i + 1]) + valueOf(scores[i + 2]);
                    break;
                default:
                    total += valueOf(scores[i]);
                    break;
            }
            if (lastRound) {
                break;
            }
        }
        return total;
    }

    private int valueOf(char c) {
        switch (c) {
            case '/':
            case 'X':
                return 10;
            case '-':
                return 0;
            default:
                return Character.getNumericValue(c);
        }
    }
}