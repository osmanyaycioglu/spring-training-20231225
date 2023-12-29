package training.spring.springtraining.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MySpringBean {

    private static final Logger logger = LoggerFactory.getLogger(MySpringBean.class);

    private int counter = 0;

    @Scheduled(initialDelay = 2_000, fixedDelay = 10_000)
    public void runMe1() {
        this.counter++;
        if (logger.isDebugEnabled()) {
            logger.debug("Logger test " + this.counter);
        }
        logger.info("-----SCHEDULE RUN RUNME1-----");
    }

    @Scheduled(initialDelay = 2_000, fixedRate = 10_000)
    public static void runMe2() {
        logger.info("-----SCHEDULE RUN RUNME2-----");
    }


    @Scheduled(cron = "0/10 * * * * *")
    public static void runMe3() {
        logger.info("-----SCHEDULE RUN RUNME3-----");
    }

}
