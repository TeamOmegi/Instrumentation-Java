package org.omegi.omegiextension;

import io.opentelemetry.sdk.trace.IdGenerator;

import java.security.SecureRandom;
import java.math.BigInteger;

public class DecimalIdGenerator implements IdGenerator {
    private static final SecureRandom random = new SecureRandom();

    @Override
    public String generateTraceId() {
        return generateDecimalId(38);
    }

    @Override
    public String generateSpanId() {
        return generateDecimalId(20);
    }

    private String generateDecimalId(int length) {
        BigInteger maxValue = BigInteger.TEN.pow(length).subtract(BigInteger.ONE);
        BigInteger randomValue;
        do {
            randomValue = new BigInteger(maxValue.bitLength(), random);
        } while (randomValue.compareTo(maxValue) >= 0);
        return String.format("%0" + length + "d", randomValue);
    }
}