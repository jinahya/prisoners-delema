package com.github.jinahya.prisonersdilemma;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.Map;

public interface Rule {

    // --------------------------------------------------------------------------------------------------------- payoffs
    @NotNull Map<@NotNull Payoff, @Positive Integer> getPayoffs();

    // ----------------------------------------------------------------------------------------------------------- games

    /**
     * Returns the total number of iterations.
     *
     * @return the total number of iterations.
     */
    @Positive int getTotalIterations();
}
