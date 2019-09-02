package rmi.server;

import rmi.remote.inter.IinterRemote;
import rmi.remote.inter.impl.InterRemoteImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by liyanan on 2019/8/29.
 * Remote method invocation  定义服务端代码
 */
public class RmiServer   {
    public static void main(String[] args) {
        try {
            IinterRemote hello = new InterRemoteImpl(); /* 生成stub和skeleton,并返回stub代理引用 */
            /* 本地创建并启动RMI Service，被创建的Registry服务将在指定的端口上侦听到来的请求
             * 实际上，RMI Service本身也是一个RMI应用，我们也可以从远端获取Registry:
             *     public interface Registry extends Remote;
             *     public static Registry getRegistry(String host, int port) throws RemoteException;
             */
            LocateRegistry.createRegistry(1099);
            /* 将stub代理绑定到Registry服务的URL上 */
            java.rmi.Naming.rebind("rmi://localhost:1099/hello", hello);
            System.out.print("Ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
