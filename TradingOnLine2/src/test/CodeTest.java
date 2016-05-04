import Base.BaseTest;
import Base.JUnit4ClassRunner;
import TOL2.mapper.UserMapper;
import TOL2.model.User;
import TOL2.other.CodeUtils;
import TOL2.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by HuangTing on 2016/5/2.
 */
//@RunWith(JUnit4ClassRunner.class)
public class CodeTest extends BaseTest {
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;
    @Test
    public void codeTest()throws Exception{
        String salt=CodeUtils.getSalt();
        User user=userService.findUserById(1);
        System.out.println("size():"+userMapper.findSalt(1).length());
        //userMapper.insertSalt(1,salt);
        System.out.println("pass:"+user.getPassword());
        String hashpass= CodeUtils.getHash(user.getPassword(),salt);
        System.out.println("hash:"+hashpass.length());
        boolean flag=CodeUtils.verify(hashpass,user.getPassword(),salt);
        System.out.println(flag);
    }
}
