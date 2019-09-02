package rim.test.server;

import rmi.test.remote.inter.IremoteInter;
import rmi.test.remote.inter.impl.RemoteInterImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by liyanan on 2019/8/30.
 */
public class RemoteServer {
    public static void main(String [] args){
        try {
            IremoteInter ri=new RemoteInterImpl();
            /* 生成stub和skeleton,并返回stub代理引用 */
            /* 本地创建并启动RMI Service，被创建的Registry服务将在指定的端口上侦听到来的请求
             * 实际上，RMI Service本身也是一个RMI应用，我们也可以从远端获取Registry:
             *     public interface Registry extends Remote;
             *     public static Registry getRegistry(String host, int port) throws RemoteException;
             */

            LocateRegistry.createRegistry(9099);
            /* 将stub代理绑定到Registry服务的URL上 */
            java.rmi.Naming.rebind("rmi://localhost:9099/hello", ri);
            System.out.print("Ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
