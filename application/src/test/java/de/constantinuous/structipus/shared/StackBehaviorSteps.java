package de.constantinuous.structipus.shared;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.util.Enumeration;
import java.util.Stack;

/**
 * Created by RichardG on 14.01.2016.
 */
public class StackBehaviorSteps {

    private Stack<String> stack;

    @Given("I have an empty stack")
    public void givenIHaveAnEmptyStack() { stack = new Stack<>(); }

    @When("I push an item $item")
    public void whenIPushAnItem(@Named("item") String item) { stack.push(item); }

    @Then("I should count $expected")
    public void thenIShouldCount(@Named("expected") int expected) {

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
