import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;


class Car{
    private String brand;
    private String model;
    private double price;

    Car(String brand,String model,double price){
        this.brand=brand;
        this.model=model;
        this.price=price;
    }

    public String getbrand(){
        return brand;
    }

    public String getmodel(){
        return model;
    }

    public double getprice(){
        return price;
    }
}

public class CarObject{
    public static void main(String[] args){

        Car car=new Car("BMW", "8A", 320000000);
        ObjectMappper mapper =new ObjectMapper();
    }
}