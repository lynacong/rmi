package jms.test.adapter;

import jms.test.util.MqUtil;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;

/**
 * Created by liyanan on 2019/9/3.
 *
 * 创建对列的适配器
 */
public class QueueFactoryAdapter  implements QueueConnectionFactory {

    private static QueueConnectionFactory connectionFactory;
    @Override
    public QueueConnection createQueueConnection() throws JMSException {
        return connectionFactory.createQueueConnection();
    }

    @Override
    public QueueConnection createQueueConnection(String s, String s1) throws JMSException {
        return connectionFactory.createQueueConnection(s, s1);
    }

    @Override
    public Connection createConnection() throws JMSException {
        return connectionFactory.createConnection();
    }

    @Override
    public Connection createConnection(String s, String s1) throws JMSException {
        return connectionFactory.createConnection(s, s1);
    }

    static {
        try {
            ActiveMQConnectionFactory mqConnectionFactory=new ActiveMQConnectionFactory();
            mqConnectionFactory.setBrokerURL("tcp://127.0.0.1:61616");
            mqConnectionFactory.setUserName(ActiveMQConnectionFactory.DEFAULT_USER);
            mqConnectionFactory.setPassword(ActiveMQConnectionFactory.DEFAULT_PASSWORD);
            connectionFactory=mqConnectionFactory;

        }catch (Exception  e){

            e.printStackTrace();
        }
    }
}
