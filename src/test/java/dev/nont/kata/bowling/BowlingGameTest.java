package dev.nont.kata.bowling;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameTest {

    @DisplayName("No strikes and no spares is a sum of all points")
    @Test
    public void validGame() {
        var result = "12345123451234512345";
        var expect = 60;
        BowlingGame sut = new BowlingGame(result);
        assertThat(sut.getScore())
                .isEqualTo(expect);
    }

    @DisplayName("A - means a miss (0 score)")
    @Test
    public void heartbreak9pins() {
        var result = "9-9-9-9-9-9-9-9-9-9-";
        var expect = 90;
        BowlingGame sut = new BowlingGame(result);
        assertThat(sut.getScore())
                .isEqualTo(expect);
    }

    @DisplayName("A spare at the beginning")
    @Test
    public void spareAtTheBeggining() {
        var result = "9/111111111111111111";
        var expect = 29;
        BowlingGame sut = new BowlingGame(result);
        assertThat(sut.getScore())
                .isEqualTo(expect);
    }

    @DisplayName("Mid game spare")
    @Test
    public void midGameSpare() {
        var result = "119/1111111111111111";
        var expect = 29;
        BowlingGame sut = new BowlingGame(result);
        assertThat(sut.getScore())
                .isEqualTo(expect);
    }

    @DisplayName("End game spare")
    @Test
    public void endGameSpare() {
        var result = "1111111111111111111/9";
        var expect = 37;
        BowlingGame sut = new BowlingGame(result);
        assertThat(sut.getScore())
                .isEqualTo(expect);
    }

    @DisplayName("missing at the end game with spare")
    @Test
    public void endgamesparebutmiss() {
        var result = "1111111111111111111/-";
        var expect = 28;
        BowlingGame sut = new BowlingGame(result);
        assertThat(sut.getScore())
                .isEqualTo(expect);
    }

    @DisplayName("Missing before the last spare")
    @Test
    public void missingBeforeLastSpare() {
        var result = "111111111111111111-/1";
        var expect = 29;
        BowlingGame sut = new BowlingGame(result);
        assertThat(sut.getScore())
                .isEqualTo(expect);
        result = "111111111111111111-/-";
        expect = 28;
        sut = new BowlingGame(result);
        assertThat(sut.getScore())
                .isEqualTo(expect);
    }

    @DisplayName("Two spares in a row")
    @Test
    public void twoSparesInARow() {
        var result = "1/1/1111111111111111";
        var expect = 38;
        BowlingGame sut = new BowlingGame(result);
        assertThat(sut.getScore())
                .isEqualTo(expect);
    }

    @DisplayName("Strike at the beginning")
    @Test
    public void strikeAtFirstSight() {
        var result = "X111111111111111111";
        var expect = 30;
        BowlingGame sut = new BowlingGame(result);
        assertThat(sut.getScore())
                .isEqualTo(expect);
    }

    @DisplayName("Two and three strikes in a row")
    @Test
    public void twoAndThreeStrikesInARow() {
        var result = "XX1111111111111111";
        var expect = 49;
        BowlingGame sut = new BowlingGame(result);
        assertThat(sut.getScore())
                .isEqualTo(expect);
        result = "XXX11111111111111";
        expect = 77;
        sut = new BowlingGame(result);
        assertThat(sut.getScore())
                .isEqualTo(expect);
        result = "11XXX111111111111";
        expect = 77;
        sut = new BowlingGame(result);
        assertThat(sut.getScore())
                .isEqualTo(expect);
    }

    @DisplayName("A strike then spare")
    @Test
    public void strikeAndThenSpare() {
        var result = "1111X1/111111111111";
        var expect = 47;
        BowlingGame sut = new BowlingGame(result);
        assertThat(sut.getScore())
                .isEqualTo(expect);
        result = "11XX-/111111111111";
        expect = 65;
        sut = new BowlingGame(result);
        assertThat(sut.getScore())
                .isEqualTo(expect);
    }

    @DisplayName("A strike at the end")
    @Test
    public void strikeAtTheEnd() {
        var result = "111111111111111111X35";
        var expect = 36;
        BowlingGame sut = new BowlingGame(result);
        assertThat(sut.getScore())
                .isEqualTo(expect);
    }

    @DisplayName("A strike at the end and a spare")
    @Test
    public void strikeAtTheEndWithASpare() {
        var result = "111111111111111111X9/";
        var expect = 38;
        BowlingGame sut = new BowlingGame(result);
        assertThat(sut.getScore())
                .isEqualTo(expect);
    }

    @DisplayName("A strike at the end and a strike")
    @Test
    public void twoStrikesAtTheEnd() {
        var result = "111111111111111111XX5";
        var expect = 43;
        BowlingGame sut = new BowlingGame(result);
        assertThat(sut.getScore())
                .isEqualTo(expect);
    }

    @DisplayName("Triple strikes at the end")
    @Test
    public void tripleStrikesAtTheEnd() {
        var result = "111111111111111111XXX";
        var expect = 48;
        BowlingGame sut = new BowlingGame(result);
        assertThat(sut.getScore())
                .isEqualTo(expect);
    }

    @DisplayName("Perfect Game")
    @Test
    public void perfectGame() {
        var result = "XXXXXXXXXXXX";
        var expect = 300;
        BowlingGame sut = new BowlingGame(result);
        assertThat(sut.getScore())
                .isEqualTo(expect);
    }

    @DisplayName("Spare every round")
    @Test
    public void allSpares() {
        var result = "5/5/5/5/5/5/5/5/5/5/5";
        var expect = 150;
        BowlingGame sut = new BowlingGame(result);
        assertThat(sut.getScore())
                .isEqualTo(expect);
    }

    @DisplayName("Noob")
    @Test
    public void noob() {
        var result = "--------------------";
        var expect = 0;
        BowlingGame sut = new BowlingGame(result);
        assertThat(sut.getScore())
                .isEqualTo(expect);
    }
}