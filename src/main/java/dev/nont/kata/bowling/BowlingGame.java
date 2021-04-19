package dev.nont.kata.bowling;

public class BowlingGame {

    private final String result;

    public BowlingGame(String result) {
        this.result = result;
    }

    public int getScore() {
        var total = 0;
        char[] carray = result.toCharArray();
        boolean lastRound = false;
        for (int i = 0; i < carray.length ; i++) {
            if (Character.isDigit(carray[i])) {
                total += Character.getNumericValue(carray[i]);
                continue;
            }
            switch (carray[i]) {
                case '/':
                    total -= carray[i-1];
                    total += 10 + carray[i+1];
                    lastRound = i + 2 == carray.length;
                    break;
            }
            if (lastRound) {
                break;
            }
        }
        return total;
    }
}