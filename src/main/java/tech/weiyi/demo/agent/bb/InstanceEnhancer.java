package tech.weiyi.demo.agent.bb;


import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;

public class InstanceEnhancer {

    private HelloProxy injector;

    public InstanceEnhancer() {
        injector = new HelloProxy();
    }

    @RuntimeType
    public Object enhance(@AllArguments Object[] allArguments) {
//        System.out.println("Enhancer Call Entry");
        return injector.elapse((Long) (allArguments[0]));
    }
}
