package training.spring.springtraining.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import training.spring.springtraining.async.MyAsyncBean;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/async")
@RequiredArgsConstructor
public class AsyncTestRest {
    private final MyAsyncBean myAsyncBean;

    @GetMapping("/test1")
    public String test1() throws Exception {
        System.out.println("TEST1 : " + Thread.currentThread().getName());
        Future<String> stringLoc = myAsyncBean.asyncMethod("test1");
        while (!stringLoc.isDone()){
            try {
                System.out.println("Hala bekliyorum");
                Thread.sleep(100);
            } catch (InterruptedException eParam) {
            }
        }

        return stringLoc.get(10_000,
                             TimeUnit.MILLISECONDS);
    }

}
