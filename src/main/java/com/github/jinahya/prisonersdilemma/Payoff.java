package com.github.jinahya.prisonersdilemma;

import static java.util.Objects.requireNonNull;

/**
 * Constants for payoffs.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public enum Payoff {

    /**
     * Temptation payoff.
     */
    T(Decision.D, Decision.C),

    /**
     * Reward payoff.
     */
    R(Decision.C, Decision.C),

    /**
     * Punishment payoff.
     */
    P(Decision.D, Decision.D),

    /**
     * "Sucker's" payoff.
     */
    S(Decision.C, Decision.D);

    /**
     * Returns the value of specified decisions.
     *
     * @param decision the prisoner's decision.
     * @param against  the opponent prisoner's decision.
     * @return the value of {@code decision} and {@code against}.
     */
    public static Payoff valueOf(final Decision decision, final Decision against) {
        requireNonNull(decision, "decision is null");
        requireNonNull(against, "against is null");
        for (final Payoff value : values()) {
            if (value.decision == decision && value.against == against) {
                return value;
            }
        }
        throw new AssertionError("no constant for " + decision + ", " + against);
    }

    /**
     * Creates a new instance.
     *
     * @param decision the prisoner's decision.
     * @param against  the opponent's decision.
     */
    Payoff(final Decision decision, final Decision against) {
        this.decision = requireNonNull(decision, "decision is null");
        this.against = requireNonNull(against, "against is null");
    }

    private final Decision decision;

    private final Decision against;
}
