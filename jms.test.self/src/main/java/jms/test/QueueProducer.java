package jms.test;



import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by liyanan on 2019/9/2.
 *
 * 创建生产者
 */
public class QueueProducer {

    public static void main(String[] args) {
        try {
            //1.创建连接工厂
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
            //2.获取连接
            Connection connection = connectionFactory.createConnection();
            //3.启动连接
            connection.start();
            //4.获取session
            Session  session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            //5.创建对列对象
            Queue queue=session.createQueue("test_queue");
            //6.创建消息生产者
            MessageProducer producer=session.createProducer(queue);
            //7.创建消息
            TextMessage textMessage=session.createTextMessage("测试消息zhege shi 这个是什么时候的消息");
            //8.发送消息
            producer.send(textMessage);
            //9.关闭资源
            producer.close();
            session.close();
            connection.close();


        } catch (Exception e){
            e.printStackTrace();
        }



    }
}
