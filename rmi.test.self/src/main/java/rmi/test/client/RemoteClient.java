package rmi.test.client;

import rmi.test.inter.IremoteInter;

import java.rmi.Naming;

/**
 * Created by liyanan on 2019/9/2.
 */
public class RemoteClient {

    public static void main(String[] args) {
        try {
                        /* 从RMI Registry中请求stub
                           * 如果RMI Service就在本地机器上，URL就是：rmi://localhost:1099/hello
                           * 否则，URL就是：rmi://RMIService_IP:1099/hello
                           */
            IremoteInter hello = (IremoteInter) Naming.lookup("rmi://localhost:9099/hello");
                        /* 通过stub调用远程接口实现 */
            System.out.println(hello.reInter("zhangxianxin"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
