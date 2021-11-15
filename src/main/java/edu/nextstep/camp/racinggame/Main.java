package edu.nextstep.camp.racinggame;

import java.util.Collection;
import java.util.stream.Collectors;

import edu.nextstep.camp.racinggame.domain.car.Cars;
import edu.nextstep.camp.racinggame.domain.car.Name;
import edu.nextstep.camp.racinggame.domain.car.policy.RandomMovePolicy;
import edu.nextstep.camp.racinggame.domain.race.Race;
import edu.nextstep.camp.racinggame.domain.race.Turns;
import edu.nextstep.camp.racinggame.view.InputView;
import edu.nextstep.camp.racinggame.view.ResultView;

public class Main {
    private static final String DELIMITER = ",";
    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TURN_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public static void main(String[] args) {
        final Collection<Name> names = InputView.inputCSV(NAME_INPUT_MESSAGE, Name.NAME_LIMIT, DELIMITER)
                .stream()
                .map(Name::of)
                .collect(Collectors.toList());
        final Turns turns = Turns.of(InputView.inputPositiveNumber(TURN_INPUT_MESSAGE));

        final Cars cars = Cars.of(names, RandomMovePolicy.getInstance());
        final Race race = Race.of(cars, turns);
        while (!race.isEnded()) {
            race.process();
            ResultView.printResult(race.totalTurns().toInt(), race.gameResult());
        }

        ResultView.printWinners(race.winners());
    }
}