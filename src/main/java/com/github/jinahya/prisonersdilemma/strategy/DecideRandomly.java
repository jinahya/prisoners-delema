package com.github.jinahya.prisonersdilemma.strategy;

import com.github.jinahya.prisonersdilemma.Context;
import com.github.jinahya.prisonersdilemma.Decision;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

import static java.util.Objects.requireNonNull;

@Slf4j
public final class DecideRandomly implements Strategy {

    public DecideRandomly(final Random random) {
        super();
        this.random = requireNonNull(random, "random is null");
    }

    /**
     * Decides by {@link Random#nextBoolean()}.
     *
     * @param context {@inheritDoc}
     * @return a randomly selected value of {@link Decision}, always.
     */
    @Override
    public @NotNull Decision decide(@Valid @NotNull Context context) {
        return random.nextBoolean() ? Decision.C : Decision.D;
    }

    @NotNull
    protected final Random random;
}
