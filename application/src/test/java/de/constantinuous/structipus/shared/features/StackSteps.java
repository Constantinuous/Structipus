package de.constantinuous.structipus.shared.features;

import net.thucydides.core.annotations.Step;

import java.util.Enumeration;
import java.util.Stack;

/**
 * Created by RichardG on 18.01.2016.
 */
public class StackSteps {

    private Stack<String> stack;

    @Step
    public void create_an_empty_stack(){
        stack = new Stack<String>();
    }

    @Step
    public void push_an_item(String item){
        stack.push(item);
    }

    @Step
    public void pop_an_item(){
        stack.pop();
    }

    @Step
    public void count_should_be(int expected){
        int actual = getCount(stack);
        if (actual != expected)
            throw new RuntimeException("expected:"+expected+";actual:"+actual);
    }

    private int getCount(Stack<String> stack){
        int count = 0;

        Enumeration<String> stackEnum = stack.elements();
        while (stackEnum.hasMoreElements()){
            stackEnum.nextElement();
            count++;
        }
        return count;
    }
}
