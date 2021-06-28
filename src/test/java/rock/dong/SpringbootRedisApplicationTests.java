package rock.dong;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import rock.dong.pojo.User;
import rock.dong.configure.RedisConfig;

@SpringBootTest
class SpringbootRedisApplicationTests {
    @Autowired
    //@Qualifier("redisTemplate")

    private RedisTemplate<String, Object> myredisTemplate;


    @Test
    void contextLoads() {


    }
    @Test
    public void test(){
        User user = new User("rock",4);
        myredisTemplate.opsForValue().set("user", user);
        System.out.println(myredisTemplate.opsForValue().get("user"));

        myredisTemplate.opsForValue().set("user1",new User("rockdong",50));
        User user1 = (User)myredisTemplate.opsForValue().get("user1");
        System.out.println(user1);

    }

}
