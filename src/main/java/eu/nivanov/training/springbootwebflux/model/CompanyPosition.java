package eu.nivanov.training.springbootwebflux.model;

/**
 * Created by Nikolay Ivanov on 2021-11-09.
 */

public enum CompanyPosition {
    MANAGER,
    SENIOR_DEVELOPER,
    MID_DEVELOPER,
    JUNIOR_DEVELOPER,
    TRAINEE_DEVELOPER;

    public CompanyPosition getHigherPosition() {
        int nextOrdinal = this.ordinal() - 1;
        if (nextOrdinal < 0) {
            nextOrdinal = 0;
        }
        return CompanyPosition.values()[nextOrdinal];
    }

    public CompanyPosition getLowerPosition() {
        CompanyPosition[] allPositions = CompanyPosition.values();

        int nextOrdinal = this.ordinal() + 1;
        if (nextOrdinal >= allPositions.length) {
            nextOrdinal = allPositions.length - 1;
        }
        return allPositions[nextOrdinal];
    }
}
