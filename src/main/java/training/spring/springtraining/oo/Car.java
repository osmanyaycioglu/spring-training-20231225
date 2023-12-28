package training.spring.springtraining.oo;

import lombok.Data;

@Data
public class Car {
    private String name;
    private Integer horsePower;

    private Integer x;
    private Integer y;

    public void forward(){
    }

    public void backward(){
    }

    // Cohesion
    public void cook(){
    }
}
