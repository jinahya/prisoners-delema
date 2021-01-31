package com.github.jinahya.prisonersdilemma;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.Map;

public interface Context {

    // --------------------------------------------------------------------------------------------------------- payoffs
    @NotNull Map<@NotNull Payoff, @Positive Integer> getPayoffs();

    // ----------------------------------------------------------------------------------------------------------- games

    /**
     * Returns the total number of games of current match.
     *
     * @return total number of games of current match.
     */
    @Positive int getTotalNumberOfGames();

    /**
     * Returns the current game number in current match.
     *
     * @return current game number in current match.
     */
    @PositiveOrZero int getCurrentGameNumber();

    default @PositiveOrZero int getRemainingNumberOfGames() {
        return getTotalNumberOfGames() - getCurrentGameNumber();
    }

    // -----------------------------------------------------------------------------------------------------------------
    Decision getDecisionAt(@Positive int rounds);
}
