package rmi.test.inter.impl;

import rmi.test.inter.IremoteInter;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by liyanan on 2019/9/2.
 *  * 远程对象必须实现java.rmi.server.UniCastRemoteObject类，这样才能保证客户端访问获得远程对象时，
 * 该远程对象将会把自身的一个拷贝以Socket的形式传输给客户端，此时客户端所获得的这个拷贝称为“存根”，
 * 而服务器端本身已存在的远程对象则称之为“骨架”。其实此时的存根是客户端的一个代理，用于与服务器端的通信，
 * 而骨架也可认为是服务器端的一个代理，用于接收客户端的请求之后调用远程方法来响应客户端的请求。
 * @author  lyn实现
 * 这个是远程接口实现
 */
public class RemoteInterImpl extends UnicastRemoteObject implements IremoteInter {

    public RemoteInterImpl() throws RemoteException {
    }

    protected RemoteInterImpl(int port) throws RemoteException {
        super(port);
    }

    protected RemoteInterImpl(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

    @Override
    public String reInter(String s) throws RemoteException {
        System.out.println("this is RemoteInterImpl class");
        return "返回传入的参数是"+s;
    }
}

