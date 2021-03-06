package com.dbschema.codec.jlong;

import com.datastax.driver.core.DataType;
import com.datastax.driver.core.exceptions.InvalidTypeException;

import java.nio.ByteBuffer;

/**
 * @author Liudmila Kornilova
 **/
public class DoubleCodec extends BaseLongCodec {

    public static final DoubleCodec INSTANCE = new DoubleCodec();

    private DoubleCodec() {
        super(DataType.cdouble());
    }

    @Override
    int getNumberOfBytes() {
        return 8;
    }

    @Override
    void serializeNoBoxingInner(long value, ByteBuffer bb) throws InvalidTypeException {
        bb.putDouble(value);
    }

    @Override
    long deserializeNoBoxingInner(ByteBuffer bytes) {
        return (long) bytes.getDouble();
    }
}
