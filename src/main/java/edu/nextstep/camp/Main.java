package edu.nextstep.camp;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import edu.nextstep.camp.view.InputView;
import edu.nextstep.camp.view.ResultView;

public class Main {
    private static final String DELIMITER = ",";

    public static void main(String[] args) {
        final InputView input = new InputView();

        final String[] names = input.inputCSV("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).", Name.NAME_LIMIT, DELIMITER);
        final int turns = input.inputPositiveNumber("시도할 회수는 몇 회 인가요?");

        final ResultView result = new ResultView(turns);

        final Collection<Name> nameCollection = Arrays.stream(names)
                .map(Name::of)
                .collect(Collectors.toList());
        final Cars cars = Cars.of(nameCollection, RandomMovePolicy.getInstance());
        final Race race = Race.of(cars, turns);
        while (!race.isEnded()) {
            race.process();
            result.printResult(race.gameResult());
        }

        result.printWinners(race.winners()
                .stream()
                .map(Name::toString)
                .collect(Collectors.toList())
        );
    }
}
