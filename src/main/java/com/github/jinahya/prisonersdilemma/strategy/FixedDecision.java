package com.github.jinahya.prisonersdilemma.strategy;

import com.github.jinahya.prisonersdilemma.Context;
import com.github.jinahya.prisonersdilemma.Decision;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import static java.util.Objects.requireNonNull;

abstract class FixedDecision implements Strategy {

    protected FixedDecision(final Decision decision) {
        super();
        this.decision = requireNonNull(decision, "decision is null");
    }

    /**
     * Returns, always, {@link #decision}.
     *
     * @param context {@inheritDoc}
     * @return {@link #decision}, regardless of {@code context}.
     */
    @Override
    public @NotNull Decision decide(@Valid @NotNull Context context) {
        return decision;
    }

    /**
     * The fixed decision.
     */
    @NotNull
    protected final Decision decision;
}
