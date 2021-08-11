package ru.svetlov.webapp.service.util;

import java.util.Random;

public class RndGen {
    private static final Random random = new Random();
    public static double getNextDouble(double lowerInclusive, double upperExclusive){
        return (lowerInclusive + random.nextDouble()*(upperExclusive - lowerInclusive));
    }
}
