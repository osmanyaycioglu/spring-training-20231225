package training.spring.springtraining.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Component
public class MyAsyncBean {

    @Async
    public Future<String> asyncMethod(String stringParam) {
        System.out.println("asyncMethod : " + Thread.currentThread()
                                                    .getName());
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException eParam) {
        }
        return CompletableFuture.completedFuture("test Async : " + stringParam + " " + Thread.currentThread()
                                                                                             .getName());
    }

}
