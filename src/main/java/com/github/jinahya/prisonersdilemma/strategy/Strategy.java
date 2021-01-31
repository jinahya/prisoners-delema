package com.github.jinahya.prisonersdilemma.strategy;

import com.github.jinahya.prisonersdilemma.Context;
import com.github.jinahya.prisonersdilemma.Decision;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Objects.requireNonNull;

public interface Strategy {

    static Strategy random(final Random random) {
        requireNonNull(random, "random is null");
        return new Strategy() {
            @Override
            public @NotNull Decision decide(@Valid @NotNull Context context) {
                return random.nextBoolean() ? Decision.C : Decision.D;
            }
        };
    }

    static Strategy random() {
        return random(ThreadLocalRandom.current());
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Decides based on specified context.
     *
     * @param context the context.
     * @return a decision.
     */
    @NotNull Decision decide(@Valid @NotNull Context context);
}
