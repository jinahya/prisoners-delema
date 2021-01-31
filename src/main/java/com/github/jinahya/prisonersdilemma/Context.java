package com.github.jinahya.prisonersdilemma;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public interface Context {

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the rule of current game.
     *
     * @return the rule of current game.
     */
    @Valid @NotNull Rule getRule();

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the current game number in current match.
     *
     * @return current game number in current match.
     */
    @PositiveOrZero int getCurrentIteration();

    default boolean isFirstIteration() {
        return getCurrentIteration() == 0;
    }

    default boolean isLastIteration() {
        return getRule().getTotalIterations() == getCurrentIteration() + 1;
    }

    /**
     * Returns the remaining iterations excluding current iteration.
     *
     * @return the remaining iterations.
     */
    default @PositiveOrZero int getRemainingIterations() {
        return getRule().getTotalIterations() - getCurrentIteration();
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns prisoner's all decisions made before this iteration.
     *
     * @return prisoner's all decisions made before this iteration.
     */
    Iterable<Decision> getPrisonerDecisions();

    /**
     * Returns prisoner's decision before specified iterations.
     *
     * @param iterations the iterations.
     * @return prisoner's decision before specified iterations.
     * @throws IllegalArgumentException if {@code iterations} is greater than {@link #getCurrentIteration()}.
     */
    Decision getPrisonerDecisionBefore(@Positive final int iterations);

    /**
     * Returns prisoner's previous decision.
     *
     * @return prisoner's previous decision.
     * @throws IllegalStateException if this iteration is the {@link #isFirstIteration() first} iteration.
     */
    default Decision getPrisonerPreviousDecision() {
        if (isFirstIteration()) {
            throw new IllegalStateException("no previous decisions");
        }
        return getPrisonerDecisionBefore(1);
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns opponent's all decisions made before this iteration.
     *
     * @return opponent's all decisions made before this iteration.
     */
    Iterable<Decision> getOpponentDecisions();

    /**
     * Returns opponent's decision before specified iterations.
     *
     * @param iterations the iterations.
     * @return opponent's decision before specified iterations.
     * @throws IllegalArgumentException if {@code iterations} is greater than {@link #getCurrentIteration()}.
     */
    Decision getOpponentDecisionBefore(@Positive int iterations);

    /**
     * Returns opponent's previous decision.
     *
     * @return opponent's previous decision.
     * @throws IllegalStateException if this iteration is the {@link #isFirstIteration() first} iteration.
     */
    default Decision getOpponentPreviousDecision() {
        if (isFirstIteration()) {
            throw new IllegalStateException("no previous decisions");
        }
        return getOpponentDecisionBefore(1);
    }
}
