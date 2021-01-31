package com.github.jinahya.prisonersdilemma.strategy;

class FixedDecisionTest<T extends FixedDecision> extends StrategyTest<T> {

    protected FixedDecisionTest(final Class<T> strategyClass) {
        super(strategyClass);
    }
}
