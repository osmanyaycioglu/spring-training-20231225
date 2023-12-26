package training.another.packages;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// @Lazy
@Component
public class MyCache {
    private Map<String,String> cache = new ConcurrentHashMap<>();

    public String get(String key){
        return cache.get(key);
    }

}
