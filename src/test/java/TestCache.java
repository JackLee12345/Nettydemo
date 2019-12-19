import com.guava.cache.CacheService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestCache {

    @Autowired
    private CacheService cacheService;

    @Test
    public void testCache(){
        CacheService cacheService = new CacheService();
        String s = cacheService.getValue("s");
        System.out.println(s);
    }
}
