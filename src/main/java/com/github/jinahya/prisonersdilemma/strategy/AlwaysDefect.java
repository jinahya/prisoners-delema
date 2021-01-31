package com.github.jinahya.prisonersdilemma.strategy;

import com.github.jinahya.prisonersdilemma.Decision;

/**
 * A strategy always {@link Decision#D defects}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see AlwaysCooperate
 */
public final class AlwaysDefect extends FixedDecision {

    private static final class InstanceHolder {

        private static final AlwaysDefect INSTANCE = new AlwaysDefect();

        private InstanceHolder() {
            throw new AssertionError("instantiation is not allowed");
        }
    }

    /**
     * Returns the instance.
     *
     * @return the instance.
     */
    public static AlwaysDefect getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private AlwaysDefect() {
        super(Decision.D);
    }
}
