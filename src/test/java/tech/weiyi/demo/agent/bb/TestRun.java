package tech.weiyi.demo.agent.bb;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestRun {

    public static void main(String[] args) throws Exception {
        final int threadSize = 100;
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService es = Executors.newFixedThreadPool(threadSize);
        for (int i = 0; i < threadSize; i++) {
            es.submit(() -> {
                for (int j = 0; j < 1000000; j++) {
                    Hello hello = new Hello();
                    long elapse = hello.elapse(System.nanoTime());
                    if (elapse > 50000000) {
                        System.out.println(elapse);
                    }
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        es.shutdownNow();
        System.out.println("结束");
    }
}
