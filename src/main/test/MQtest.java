import com.sx.entity.User;
import com.sx.queen.TestProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * moayi
 *
 * @create 2018-05-30 13:10
 **/
// 配置Spring中的测试环境
@RunWith(SpringJUnit4ClassRunner.class)
// 指定测试环境使用的ApplicationContext是WebApplicationContext类型的
// value指定web应用的根
@WebAppConfiguration(value = "src/main/webapp")
// 指定Spring容器层次和配置文件路径
@ContextHierarchy({
        @ContextConfiguration(name = "parent", locations = {"classpath*:/spring/applicationContext-bean.xml"}),
        @ContextConfiguration(name = "child", locations = {"classpath*:/mvc/mvc.xml"})
})
// 测试类开启事务,需要指定事务管理器,默认测试完成后,数据库操作自动回滚
@Transactional(transactionManager = "transactionManager")
// 指定数据库操作不回滚,可选
@Rollback(value = true)
public class MQtest {
    @Autowired
   private TestProvider testProvider;
    @Test
    public  void send(){
        User u =new User();
        u.setId("123456789");
        testProvider.sendMessage(u);
    }
}