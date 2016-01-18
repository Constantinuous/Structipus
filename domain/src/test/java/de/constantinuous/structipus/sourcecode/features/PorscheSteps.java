package de.constantinuous.structipus.sourcecode.features;

import net.thucydides.core.annotations.Step;

import java.util.Enumeration;
import java.util.Stack;

/**
 * Created by RichardG on 18.01.2016.
 */
public class PorscheSteps {

    private int speed;

    @Step
    public void buy_new_porsche(){
    }

    @Step
    public void accelerate_really_fast(){
        speed = 100;
    }

    @Step
    public void speed_should_be(int expected){
        int actual = speed;
        if (actual != expected)
            throw new RuntimeException("expected:"+expected+";actual:"+actual);
    }

}
