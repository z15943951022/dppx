import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class TestMain {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void aa(){
        System.out.println(redisTemplate);
    }
}
