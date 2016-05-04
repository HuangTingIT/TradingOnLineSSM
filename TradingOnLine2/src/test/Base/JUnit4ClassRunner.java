package Base;

import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

import java.io.FileNotFoundException;

/**
 * Created by HuangTing on 2016/5/2.
 */
/*
PS：Junit加载spring的runner（SpringJUnit4ClassRunner）要优先于spring加载log4j，
因此采用普通方法，无法实现spring先加载log4j后被Junit加载。
所以我们需要新建JUnit4ClassRunner类，修改SpringJUnit4ClassRunner加载log4j的策略。
这样加载log4j就会优先于加载spring了。
 */
public class JUnit4ClassRunner extends SpringJUnit4ClassRunner {

    static {
        try {
            Log4jConfigurer.initLogging("classpath:TOL2/conf/log4j.properties");
        } catch (FileNotFoundException ex) {
            System.err.println("Cannot Initialize log4j");
        }
    }

    public JUnit4ClassRunner(Class<?> clazz) throws InitializationError {
        super(clazz);
    }

}
