package TOL2.other;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;

/**
 * Created by HuangTing on 2016/5/2.
 */
public class MytMethodInvokingFactoryBean extends MethodInvokingFactoryBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        super.afterPropertiesSet();
        Object[] args = getArguments();
        for (int i = 0; i < args.length; i++) {
            Object obj = args[i];
            if (obj instanceof String) {
                String arg =obj.toString();
                if(arg.startsWith("classpath:")||arg.startsWith("classpath*:")){
                    arg=arg.split(":")[1];
                    arg=this.getClass().getClassLoader().getResource(arg).getPath();
                    args[i]=arg;
                }
            }
        }
        setArguments(args);
    }
}
