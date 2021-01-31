package com.github.jinahya.prisonersdilemma.strategy;

import com.github.jinahya.prisonersdilemma.Context;
import com.github.jinahya.prisonersdilemma.Decision;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

/**
 * A class for testing {@link AlwaysCooperate} class.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
class AlwaysCooperateTest extends FixedDecisionTest<AlwaysCooperate> {

    AlwaysCooperateTest() {
        super(AlwaysCooperate.class);
    }

    @Override
    protected AlwaysCooperate strategyInstance() {
        return AlwaysCooperate.getInstance();
    }

    /**
     * Asserts {@link AlwaysCooperate#getInstance()} always {@link Decision#C cooperates}.
     */
    @Test
    void decide_Cooperate_Always() {
        assertThat(strategyInstance().decide(mock(Context.class))).isSameAs(Decision.C);
    }
}