package com.github.jinahya.prisonersdilemma.strategy;

import com.github.jinahya.prisonersdilemma.Decision;

/**
 * A strategy of always {@link Decision#C cooperates}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see AlwaysDefect
 */
public final class AlwaysCooperate extends FixedDecision {

    private static final class InstanceHolder {

        private static final AlwaysCooperate INSTANCE = new AlwaysCooperate();

        private InstanceHolder() {
            throw new AssertionError("instantiation is not allowed");
        }
    }

    /**
     * Returns the instance.
     *
     * @return the instance.
     */
    public static AlwaysCooperate getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private AlwaysCooperate() {
        super(Decision.C);
    }
}
