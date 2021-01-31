package com.github.jinahya.prisonersdilemma.strategy;

import lombok.extern.slf4j.Slf4j;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Slf4j
class DecideRandomlyTest extends StrategyTest<DecideRandomly> {

    DecideRandomlyTest() {
        super(DecideRandomly.class);
    }

    @Override
    protected DecideRandomly strategyInstance() {
        try {
            return new DecideRandomly(SecureRandom.getInstanceStrong());
        } catch (final NoSuchAlgorithmException nsae) {
            throw new RuntimeException("failed to get a strong secure random", nsae);
        }
    }
}