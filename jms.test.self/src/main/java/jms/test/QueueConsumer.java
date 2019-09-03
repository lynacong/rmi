package jms.test;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by liyanan on 2019/9/3.
 */
public class QueueConsumer {
    public static void main(String[] args) {
        try {
            //1.创建连接工厂
            ActiveMQConnectionFactory connectionFactory=new ActiveMQConnectionFactory("MQ地址");
            //2.获取连接对象
            Connection  connection=connectionFactory.createConnection();
            //3.启动连接
            connection.start();
            //4.获取session
            Session session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
                    //5.创建对列对象
            Queue queue=session.createQueue("对列名称");
            //6.创建消费者
            MessageConsumer consumer=session.createConsumer(queue);
            //7.监听消息
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    TextMessage textMessage= (TextMessage) message;
                    try {
                        System.out.println("接收到的消息是："+textMessage.getText()) ;
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }

                }
            });
            //8.等待键盘输入
            System.in.read();
            //9.关闭资源
            consumer.close();
            session.close();
            connection.close();


        } catch (JMSException e) {
            e.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
