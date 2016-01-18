package com.cmcciot.demo.integration.cache;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * @Description
 * @Author 黄川
 * @Date 16/1/18
 */
public class KyroRedisSerializer implements RedisSerializer<Object> {

    private final Kryo kryo = new Kryo();

    private static final int BUFFER_SIZE = 1 << 15;

    @Override
    public byte[] serialize(Object o) throws SerializationException {
        Output output = new Output(BUFFER_SIZE);
        kryo.writeClassAndObject(output, o);

        return output.toBytes();
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if(bytes == null){
            return null;
        }

        return kryo.readClassAndObject(new Input(bytes));
    }

}
