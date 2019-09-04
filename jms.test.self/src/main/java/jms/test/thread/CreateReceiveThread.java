package jms.test.thread;

import jms.test.adapter.QueueFactoryAdapter;
import jms.test.container.BaseMessageListenerContainer;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * Created by liyanan on 2019/9/3.
 */
public class CreateReceiveThread  extends Thread {

    public QueueFactoryAdapter connectionFactory=new QueueFactoryAdapter();

    @Override
    public void run(){

        this.createReceiveContainer();

    }

    public void createReceiveContainer(){
        new BaseMessageListenerContainer(){
            @Override
            public void setProperty(){
                //设置对列名称
                this.setDestinationName("test_queue");
                this.setConnectionFactory(connectionFactory);
                this.setConcurrentConsumers(2);
                this.setCacheLevel(3);
              //  this.setMessageSelector("messageType='0'");
                this.setMessageListener(
                        new SessionAwareMessageListener() {
                            @Override
                            public void onMessage(Message message, Session session) throws JMSException {

                                System.out.println("接收到的消息是："+((TextMessage)message).getText());
                            }
                        }
                );
            }
        };
    }

}
