package rmi.test.model.client;

import rmi.test.model.inter.Persion;
import rmi.test.model.stub.Persion_Stub;

/**
 * Created by liyanan on 2019/8/30.
 */
public class PersonClient {
    public static void main(String [] args) {
        try {
            Persion person = new Persion_Stub();
            int age = person.getAge();
            String name = person.getName();
            System.out.println(name + " is " + age + " years old");
        } catch(Throwable t) {
            t.printStackTrace();
        }
    }

}
