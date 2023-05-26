//4.

import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        try {
            Adder skeleton = (Adder) Naming.lookup("rmi://localhost:1234/nist");
            System.out.println(skeleton.add(5, 9));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}