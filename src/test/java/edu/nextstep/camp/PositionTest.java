package edu.nextstep.camp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @Test
    public void create() {
        Position position = Position.ofZero();
        assertThat(position.toInt()).isEqualTo(0);
        assertThat(position).isEqualTo(Position.ofZero());
    }

    @Test
    public void move() {
        Position position = Position.ofZero();
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

    @Test
    public void compare() {
        Position position1 = Position.ofZero();
        position1.forward();
        Position position2 = Position.ofZero();
        assertThat(position1).isInstanceOf(Comparable.class);
        assertThat(position1.compareTo(position2)).isGreaterThan(0);
        assertThat(position2.compareTo(Position.ofZero())).isEqualTo(0);
    }
}
