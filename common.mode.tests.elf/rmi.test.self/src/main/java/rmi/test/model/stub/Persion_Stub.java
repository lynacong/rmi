package rmi.test.model.stub;

import rmi.test.model.inter.Persion;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by liyanan on 2019/8/30.
 * Person_Stub是建立socket连接，并向Skeleton发请求，然后通过Skeleton调用PersonServer的方法，最后接收返回的结果。
 * RMI的传输协议是Socket。
 */
public class Persion_Stub   implements Persion {

    private Socket socket;
    //初始化创建stub
    public Persion_Stub() throws Throwable {
        // connect to skeleton
        socket = new Socket("localhost", 9000);
    }
    @Override
    public int getAge() throws Throwable {
        // pass method name to skeleton
        ObjectOutputStream outStream =
                new ObjectOutputStream(socket.getOutputStream());
        outStream.writeObject("age");
        outStream.flush();
        ObjectInputStream inStream =
                new ObjectInputStream(socket.getInputStream());
        return inStream.readInt();

    }

    @Override
    public String getName() throws Throwable {
        // pass method name to skeleton
        ObjectOutputStream outStream =
                new ObjectOutputStream(socket.getOutputStream());
        outStream.writeObject("name");
        outStream.flush();
        ObjectInputStream inStream =
                new ObjectInputStream(socket.getInputStream());
        return (String)inStream.readObject();
    }
}
