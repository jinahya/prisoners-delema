package com.github.jinahya.prisonersdilemma.strategy;

import com.github.jinahya.prisonersdilemma.Context;
import com.github.jinahya.prisonersdilemma.Decision;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

/**
 * A class for testing {@link AlwaysDefect} class.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
class AlwaysDefectTest extends FixedDecisionTest<AlwaysDefect> {

    AlwaysDefectTest() {
        super(AlwaysDefect.class);
    }

    @Override
    protected AlwaysDefect strategyInstance() {
        return AlwaysDefect.getInstance();
    }

    /**
     * Asserts {@link AlwaysDefect#getInstance()} always {@link Decision#D defects}.
     */
    @Test
    void decide_Defect_Always() {
        assertThat(strategyInstance().decide(mock(Context.class))).isSameAs(Decision.D);
    }
}