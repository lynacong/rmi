package rmi.test.remote.inter;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by liyanan on 2019/8/30.
 */
public interface IremoteInter extends Remote {

    public  String reInter(String s) throws RemoteException;
}
