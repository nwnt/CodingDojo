package dev.nont.kata.bowling;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameTest {

    @DisplayName("Test a valid game")
    @Test
    public void validGame() {
        var result = "12345123451234512345";
        var expect = 60;
        BowlingGame sut = new BowlingGame(result);
        assertThat(sut.getScore())
                .isEqualTo(expect);
    }
}
