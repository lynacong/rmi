package rmi.test.inter;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by liyanan on 2019/9/2.
 *  * *　在Java中，只要一个类extends了java.rmi.Remote接口，即可成为存在于服务器端的远程对象，
 * 供客户端访问并提供一定的服务。JavaDoc描述：Remote 接口用于标识其方法可以从非本地虚拟机上
 * 调用的接口。任何远程对象都必须直接或间接实现此接口。只有在“远程接口”
 * （扩展 java.rmi.Remote 的接口）中指定的这些方法才可被远程调用。
 *
 * 定义一个接口用于调用的远程接口
 */
public interface IremoteInter extends Remote {

    public  String reInter(String s) throws RemoteException;
}
