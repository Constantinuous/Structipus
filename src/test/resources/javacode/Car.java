package javacode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by RichardG on 17.12.2015.
 */
public class Car implements Vehicle{

    private List<Wheel> wheels = new LinkedList<>();

    /**
     * This is a Constructor
     */
    public Car(){
        wheels.add(new Wheel(10));
        wheels.add(new Wheel(10));
        wheels.add(new Wheel(10));
        wheels.add(new Wheel(100));
    }

    @Override
    public int getWheelCount() {
        return 0;
    }

    @Override
    public Wheel getWheel(int index) {
        return wheels.get(index);
    }
}
