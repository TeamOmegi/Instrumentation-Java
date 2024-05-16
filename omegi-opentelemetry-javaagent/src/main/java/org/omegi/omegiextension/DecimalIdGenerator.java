package org.omegi.omegiextension;

import io.opentelemetry.sdk.trace.IdGenerator;

import java.security.SecureRandom;
import java.math.BigInteger;

public class DecimalIdGenerator implements IdGenerator {
    private static final SecureRandom random = new SecureRandom();
    @Override
    public String generateTraceId() {
        return generateDecimalId(32);
    }

    @Override
    public String generateSpanId() {
        return generateDecimalId(16);
    }

    private String generateDecimalId(int length) {
        return new BigInteger(length, random).toString();
    }
}