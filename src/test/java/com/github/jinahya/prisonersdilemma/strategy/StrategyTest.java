package com.github.jinahya.prisonersdilemma.strategy;

import java.lang.reflect.Constructor;

import static java.util.Objects.requireNonNull;

/**
 * An abstract class for testing subclasses of {@link Strategy} interface.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public abstract class StrategyTest<T extends Strategy> {

    /**
     * Creates a new instance with specified strategy class.
     *
     * @param strategyClass the strategy class to test.
     * @see #strategyClass
     */
    protected StrategyTest(final Class<T> strategyClass) {
        this.strategyClass = requireNonNull(strategyClass, "strategyClass is null");
    }

    /**
     * Creates a new instance of {@link #strategyClass}.
     *
     * @return a new instance of {@link #strategyClass}.
     */
    protected T strategyInstance() {
        try {
            final Constructor<T> constructor = strategyClass.getConstructor();
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return constructor.newInstance();
        } catch (final ReflectiveOperationException roe) {
            throw new RuntimeException("failed to instantiate " + strategyClass);
        }
    }

    /**
     * The strategy class to test.
     */
    protected final Class<T> strategyClass;
}