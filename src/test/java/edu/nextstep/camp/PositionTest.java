package edu.nextstep.camp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @Test
    public void create() {
        Position position = Position.of(0);
        assertThat(position.toInt()).isEqualTo(0);
        assertThat(position).isEqualTo(Position.of(0));
    }

    @Test
    public void move() {
        Position position = Position.of(0);
        assertThat(position.toInt()).isEqualTo(0);
        position.forward();
        assertThat(position.toInt()).isEqualTo(1);
        position.forward();
        assertThat(position.toInt()).isEqualTo(2);
        position.forward();
        assertThat(position.toInt()).isEqualTo(3);
        position.forward();
        assertThat(position.toInt()).isEqualTo(4);
    }
}
