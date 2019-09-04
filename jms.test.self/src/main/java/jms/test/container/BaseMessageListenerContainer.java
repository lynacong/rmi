package jms.test.container;

import org.springframework.jms.listener.DefaultMessageListenerContainer;

/**
 * Created by liyanan on 2019/9/3.
 *
 * 设置监听容器
 */
public abstract class BaseMessageListenerContainer  extends DefaultMessageListenerContainer {

    @Override
    public void afterPropertiesSet(){
        setProperty();
        super.afterPropertiesSet();
    }
    public abstract void setProperty();
}
