package Base;

import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by HuangTing on 2016/5/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration
        (locations = {"classpath:TOL2/conf/mybatis/sqlMapConfig.xml","classpath:TOL2/conf/spring/applicationContext-*.xml"}) //加载配置文件
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class BaseTest extends AbstractJUnit4SpringContextTests {


    public <T> T getBean(Class<T> type){
        return applicationContext.getBean(type);
    }

    public Object getBean(String beanName){
        return applicationContext.getBean(beanName);
    }
    protected ApplicationContext getContext(){
        return applicationContext;
    }
}
