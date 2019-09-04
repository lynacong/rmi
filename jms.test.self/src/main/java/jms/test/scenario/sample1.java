package jms.test.scenario;

import jms.test.thread.CreateReceiveThread;

/**
 * Created by liyanan on 2019/9/3.
 * 场景一：

 1.Producer  -----> 发送消息到broker

 2.Customer------> 从broker 收到消息

 3.Customer------> 向broker 确认消息收到

 */
public class sample1 {
    public static void main(String[] args) {
        //创建接收线程
        CreateReceiveThread  crt=new CreateReceiveThread();
        //启动接收线程配置
        crt.start();
    }

}
