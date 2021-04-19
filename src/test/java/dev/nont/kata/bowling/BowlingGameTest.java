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

}
