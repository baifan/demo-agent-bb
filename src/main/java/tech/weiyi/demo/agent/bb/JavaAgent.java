package tech.weiyi.demo.agent.bb;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

import java.lang.instrument.Instrumentation;

public class JavaAgent {

    public static void premain(String args, Instrumentation instrumentation) throws Exception {
        new AgentBuilder.Default()
                .type(ElementMatchers.named("tech.weiyi.demo.agent.bb.Hello"))
                .transform(new Transformer())
                .installOn(instrumentation);
    }

    private static class Transformer implements AgentBuilder.Transformer {
        public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassLoader classLoader, JavaModule module) {
            return builder.method(ElementMatchers.isPublic().and(ElementMatchers.named("elapse")))
                    .intercept(MethodDelegation.withDefaultConfiguration().to(new InstanceEnhancer()));
        }
    }

}
