import com.guava.cache.CacheService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    public static void main(String[] args) {
//        FactoryBean
//        BeanFactory
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring.xml");
        CacheService bean = applicationContext.getBean(CacheService.class);
//        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
//        User u = defaultListableBeanFactory.getBean(User.class);
        System.out.println("hello");
        System.out.println(bean);

    }
}
