package training.another.packages;

import org.springframework.stereotype.Component;

@Component
public class MyAnotherBean {

    public String execute(){
        return "Another bean executed";
    }

}

