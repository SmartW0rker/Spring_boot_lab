package com.mk.finki.ukim.mk.lab.bootstrap;

import com.mk.finki.ukim.mk.lab.model.Balloon;
import com.mk.finki.ukim.mk.lab.model.Manufacturer;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {
    public static List<Balloon> balloons=new ArrayList<>();
    public static List<Manufacturer> manufacturers = new ArrayList<>();

    @PostConstruct
    public void init(){

        manufacturers.add(new Manufacturer("Nike","US","NewYork"));
        manufacturers.add(new Manufacturer("Adidas","UK","London"));
        manufacturers.add(new Manufacturer("Puma","Germany","Berlin"));
        manufacturers.add(new Manufacturer("Jako","MKD","Skopje"));
        manufacturers.add(new Manufacturer("Abibos","China","Peking"));

        for (int i=1;i<11;i++){
            balloons.add(new Balloon(String.format("%s",i),String.format("Balon %s",i),
                    manufacturers.get(i%5)));
        }
    }
}
