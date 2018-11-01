package tech.weiyi.demo.agent.bb;

public class HelloProxy {

    public long elapse(long startElapse) {
//        System.out.println("Injector Call Entry");
        return System.nanoTime() - startElapse;
    }
}
