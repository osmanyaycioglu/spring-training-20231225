package training.spring.springtraining.beans;

import lombok.Data;

@Data
public class MyXmlBean {
    private String testText;

    public void writeMe(){
        System.out.println(testText);
    }
}
