package rmi.test.inter.impl;

import rmi.test.inter.IremoteInter;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by liyanan on 2019/9/2.
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

