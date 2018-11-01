package tech.weiyi.demo.agent.bb;

public class Hello {

    public long elapse(long startElapse) {
//        System.out.println("Hello Call Entry");
        return System.nanoTime() - startElapse;
    }
}
