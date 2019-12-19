package com.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.stereotype.Service;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Service
public class CacheService {

    private final LoadingCache<String, String> cache;

    public CacheService() {
        cache = CacheBuilder.newBuilder()
                .concurrencyLevel(4)
                .expireAfterAccess(5, TimeUnit.HOURS)
                .maximumSize(1000)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String s) throws Exception {
                        // 逻辑处理，调用数据库
                        return "hello world";
                    }
                });
    }

    public String getValue(String s) {
        String value = null;
        try {
            value = cache.get(s);
            if (value == null) {
                value = null;
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return value;
    }
}
