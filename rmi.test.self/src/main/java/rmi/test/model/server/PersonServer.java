package rmi.test.model.server;

import rmi.test.model.inter.Persion;
import rmi.test.model.skeleton.Person_Skeleton;

/**
 * Created by liyanan on 2019/8/30.
 */
public class PersonServer  implements Persion {
    private int age;
    private String name;
    public PersonServer(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int getAge() throws Throwable {
        return age;
    }

    @Override
    public String getName() throws Throwable {
        return name;
    }

    public static void main(String args []) {
        // new object server
        PersonServer person = new PersonServer("Richard", 34);
        Person_Skeleton skel = new Person_Skeleton(person);
        skel.start();
    }


}
