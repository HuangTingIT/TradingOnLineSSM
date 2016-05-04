import Base.BaseTest;
import Base.JUnit4ClassRunner;
import TOL2.model.User;
import TOL2.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by HuangTing on 2016/5/2.
 */
@RunWith(JUnit4ClassRunner.class)
public class insertUser extends BaseTest {
    @Autowired
    UserService userService;
    @Test
    public void testInsertUser()throws Exception{
        User user=new User();
        user.setPassword("123456");
        user.setTelephone("17804316120");
        user.setEmail("yellow.ht@qq.com");
        user.setRealname("manamn");
        userService.insertUser(user);
    }
}
