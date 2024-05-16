package org.omegi.omegiextension;

import io.opentelemetry.sdk.trace.IdGenerator;
import java.util.Random;

public class DecimalIdGenerator implements IdGenerator {
    private final Random random;

    public DecimalIdGenerator() {
        this.random = new Random();
    }

    @Override
    public String generateTraceId() {
        return generateDecimalId(32);
    }

    @Override
    public String generateSpanId() {
        return generateDecimalId(16);
    }

    private String generateDecimalId(int length) {
        long maxValue = (long) Math.pow(10, length) - 1;
        long randomValue = Math.abs(random.nextLong()) % (maxValue + 1);
        return String.format("%0" + length + "d", randomValue);
    }
}