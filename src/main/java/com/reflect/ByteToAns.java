package com.reflect;

import com.google.common.collect.Maps;

import java.lang.reflect.Constructor;
import java.util.Map;

/**
 * 将输入流构造成想要的request bean 对象
 */
public class ByteToAns {

    private static Map<Class<?>, Constructor> construcorMap = Maps.newConcurrentMap();

    public static <T> T getRequestBean(Class<T> classz, byte[] buffer) {
        Constructor<T> constructor = construcorMap.get(classz);
        T t = null;
        try {
            if (constructor == null) {
                constructor = classz.getConstructor(byte[].class, int.class);
                construcorMap.putIfAbsent(classz, constructor);
            }
            t = constructor.newInstance(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
}
