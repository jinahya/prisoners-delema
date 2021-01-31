package com.github.jinahya.prisonersdilemma;

import com.github.jinahya.prisonersdilemma.strategy.Strategy;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class Iterated {


    @NotNull
    private final Strategy strategy1;

    @NotNull
    private final Strategy strategy2;

    @Positive
    private final int iteration;
}
